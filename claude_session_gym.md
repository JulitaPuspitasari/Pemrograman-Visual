# Claude Session — Gym Me NetBeans Build

Memo lengkap proses membangun aplikasi **Gym-koneksi-api-netbeans** dari project sumber **Gym-koneksi-api**. Pakai ini sebagai referensi kalau ada tugas serupa (Java Swing + NetBeans + REST API).

---

## 1. Konteks Project

- **Mata kuliah**: Pemrograman Visual, UAS Semester 6 Unindra
- **Stack**: Java Swing, NetBeans IDE 8.0.1, JDK 8, MariaDB Connector
- **Backend**: REST API PHP di `https://api-perpustakaan.tofla.id/api/gym` (database `db_gym` di server `100.115.114.8`)
- **Bukan koneksi DB langsung** — aplikasi cuma HTTP client ke API server
- **Login default**: `admin` / `admin123`

### Struktur folder akhir
```
Gym-koneksi-api-netbeans/
├── api_server/        → dokumentasi & PHP source (referensi server)
├── build/, dist/      → output compile (auto by NetBeans)
├── build.xml          → entry build script
├── database/gym_me.sql → skema database
├── jalankan.bat       → launcher manual (tanpa NetBeans)
├── lib/mariadb-java-client-3.3.3.jar
├── manifest.mf
├── nbproject/         → project.xml, project.properties, genfiles.properties
└── src/gym/
    ├── komponen/      → Custom Swing components (lihat bagian 3)
    │   ├── ButtonGradient.java
    │   ├── DesktopPaneGym.java
    │   ├── PanelGradient.java
    │   ├── PanelKartu.java
    │   └── SwingUtil.java
    ├── koneksi/
    │   ├── ApiClient.java         → HTTP client + JSON parser manual
    │   └── KoneksiDatabase.java   → JDBC (fallback, tidak terpakai default)
    ├── form/          → 9 .java + 9 .form (FormLogin, FormMenuUtama, 7 CRUD)
    └── report/        → 4 .java + 4 .form (4 laporan JFrame)
```

---

## 2. Format NetBeans `.form` — GOTCHAS PENTING

### 2.1. Class name di Constraint (BUG #1 di session ini)

❌ **SALAH** (NetBeans gak bisa parse, reset semua posisi ke x=0,y=0,w=-1,h=-1):
```xml
value="org.netbeans.modules.form.compat2.layouts.AbsoluteLayout$AbsoluteConstraintsDescription"
```

✅ **BENAR**:
```xml
value="org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout$AbsoluteConstraintsDescription"
```

Pakai `DesignAbsoluteLayout` (bukan `AbsoluteLayout`) di nama class `value=...$AbsoluteConstraintsDescription`. Tapi di `layoutClass` attribute masih `DesignAbsoluteLayout`:
```xml
<Constraint layoutClass="org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout" value="org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout$AbsoluteConstraintsDescription">
  <AbsoluteConstraints x="20" y="25" width="180" height="30"/>
</Constraint>
```

### 2.2. Form Size — `formSizePolicy` (BUG #2)

❌ `formSizePolicy=1` → NetBeans generate `pack()` di `initComponents()` → form collapse jadi kotak kecil
✅ `formSizePolicy=2` + `formSize` synthetic property → NetBeans generate `setSize(w, h)`

```xml
<SyntheticProperties>
  <SyntheticProperty name="formSize" type="java.awt.Dimension" value="-84,-19,0,5,115,114,0,18,106,97,118,97,46,97,119,116,46,68,105,109,101,110,115,105,111,110,65,-114,-39,-41,-84,95,68,20,2,0,2,73,0,6,104,101,105,103,104,116,73,0,5,119,105,100,116,104,120,112,0,0,1,-12,0,0,3,-124"/>
  <SyntheticProperty name="formSizePolicy" type="int" value="2"/>
  <SyntheticProperty name="generateCenter" type="boolean" value="true"/>
</SyntheticProperties>
```

#### Cara hitung `formSize` bytes (serialized `java.awt.Dimension`)

Header tetap (selalu sama):
```
-84,-19,0,5,115,114,0,18,106,97,118,97,46,97,119,116,46,68,105,109,101,110,115,105,111,110,65,-114,-39,-41,-84,95,68,20,2,0,2,73,0,6,104,101,105,103,104,116,73,0,5,119,105,100,116,104,120,112
```

Lalu **8 bytes data**: 4 byte big-endian `height` + 4 byte big-endian `width`. Konversi int → 4 byte signed:
- 500 = 0x000001F4 → `0,0,1,-12` (F4=244, signed byte = -12)
- 900 = 0x00000384 → `0,0,3,-124` (84=132, signed byte = -124)
- 1024 = 0x00000400 → `0,0,4,0`
- 700 = 0x000002BC → `0,0,2,-68`
- 550 = 0x00000226 → `0,0,2,38`
- 950 = 0x000003B6 → `0,0,3,-74`
- 1000 = 0x000003E8 → `0,0,3,-24`
- 1050 = 0x0000041A → `0,0,4,26`

Format: `header + height_bytes + width_bytes`

Untuk **JInternalFrame** gak perlu `formSize` (karena setSize manual di constructor pun cukup, atau tinggal pakai `setSize` di GEN block via .form).

### 2.3. JInternalFrame template `.form`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<Form version="1.5" maxVersion="1.9" type="org.netbeans.modules.form.forminfo.JInternalFrameFormInfo">
  <Properties>
    <Property name="closable" type="boolean" value="true"/>
    <Property name="iconifiable" type="boolean" value="true"/>
    <Property name="maximizable" type="boolean" value="true"/>
    <Property name="resizable" type="boolean" value="true"/>
    <Property name="title" type="java.lang.String" value="..."/>
  </Properties>
  <Layout class="org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout">
    <Property name="useNullLayout" type="boolean" value="true"/>
  </Layout>
  <SubComponents>...</SubComponents>
</Form>
```

### 2.4. JFrame template `.form` (dengan menu bar)

```xml
<Form version="1.5" ... type="org.netbeans.modules.form.forminfo.JFrameFormInfo">
  <Properties>
    <Property name="defaultCloseOperation" type="int" value="3"/>
    <Property name="title" type="java.lang.String" value="..."/>
  </Properties>
  <SyntheticProperties>
    <SyntheticProperty name="formSize" type="java.awt.Dimension" value="...bytes..."/>
    <SyntheticProperty name="formSizePolicy" type="int" value="2"/>
    <SyntheticProperty name="generateCenter" type="boolean" value="true"/>
    <SyntheticProperty name="menuBar" type="java.lang.String" value="menuBar"/>  <!-- if menu -->
  </SyntheticProperties>
  ...
  <SubComponents>...visible components...</SubComponents>
  <NonVisualComponents>
    <Menu class="javax.swing.JMenuBar" name="menuBar">...</Menu>
  </NonVisualComponents>
</Form>
```

### 2.5. Format `.java` dengan NetBeans GEN markers (WAJIB)

```java
public class FormXxx extends javax.swing.JFrame {
    public FormXxx() {
        initComponents();
        setupTambahan();  // custom code OUTSIDE GEN block
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        // NetBeans akan REGENERATE seluruh isi block ini dari .form
        // Jangan tulis custom logic di sini
        ...
    }// </editor-fold>//GEN-END:initComponents

    private void btnXxxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXxxActionPerformed
        // Event handler — boleh edit antara FIRST dan LAST
    }//GEN-LAST:event_btnXxxActionPerformed

    // ... method custom lainnya, OUTSIDE GEN block ...

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXxx;
    private gym.komponen.PanelGradient panelHeader;
    // ...
    // End of variables declaration//GEN-END:variables
}
```

**Aturan**: kode dalam block `//GEN-BEGIN:initComponents` ... `//GEN-END:initComponents` AKAN ditimpa NetBeans tiap kali user edit di Design View. Custom logic harus di **luar** block ini — taruh di constructor (setelah `initComponents()`) atau di method lain.

---

## 3. Custom Swing Components (`gym.komponen`)

NetBeans Design View bisa render custom subclass JPanel/JButton **selama**:
1. Class punya constructor no-arg
2. Method `paintComponent()` dioverride (atau pakai bean properties)
3. Reference fully-qualified di `.form`: `<Component class="gym.komponen.PanelGradient" name="..."/>`

### Components yang dibuat:

| Class | Fungsi | Properties |
|-------|--------|------------|
| `PanelGradient` | Panel dengan gradient background | `colorStart`, `colorEnd`, `vertical` |
| `PanelKartu` | Panel rounded putih dengan shadow | `arc` |
| `ButtonGradient` | Button rounded dengan gradient | `colorStart`, `colorEnd`, `colorHover`, `colorPressed`, `arc` |
| `DesktopPaneGym` | JDesktopPane dengan watermark text | `watermark`, `subtitle` |
| `SwingUtil` | Helper static — `makeOpaque()`, `styleTableHeader()` | - |

### Pattern customisasi per-form

Default colors di-set di class. Untuk form yang butuh warna berbeda, override **di luar GEN block**:
```java
public FormPersonalTrainer() {
    initComponents();
    panelHeader.setColorStart(new Color(243, 156, 18));  // orange — custom
    setupTabel();
    tampilData();
}
```

Atau set property `colorStart` langsung di `.form`:
```xml
<Container class="gym.komponen.PanelGradient" name="panelHeader">
  <Properties>
    <Property name="colorStart" type="java.awt.Color" editor="org.netbeans.beaninfo.editors.ColorEditor">
      <Color blue="12" green="9c" red="f3" type="rgb"/>
    </Property>
  </Properties>
  ...
```

---

## 4. Network/HTTP Gotchas

### 4.1. Cloudflare Error 1010 (BUG #3)

API server di-proxy Cloudflare. Java default `User-Agent: Java/1.8.0_xxx` di-block sebagai bot, return **HTTP 403 + body "error code: 1010"**.

✅ **Fix**: set User-Agent ke browser string:
```java
conn.setRequestProperty("User-Agent",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
    "(KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
```

Tambahkan di **setiap** `HttpURLConnection` (`FormLogin.login()` dan `ApiClient.request()`).

### 4.2. TLS 1.2 untuk JDK 8 lama

JDK 8 < 8u162 default-nya TLS 1.0, sedangkan server modern butuh TLS 1.2+. Tambahkan di `main()` dan static block:
```java
System.setProperty("https.protocols", "TLSv1.2");
System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
```

### 4.3. Debug response

Untuk troubleshooting login/API gagal, tampilkan **status + response body** di error dialog, bukan cuma "gagal":
```java
JOptionPane.showMessageDialog(this,
    "Login Gagal!\nStatus HTTP: " + status + "\nResponse: " + response,
    "Login Gagal", JOptionPane.ERROR_MESSAGE);
System.out.println("[FormLogin] Status: " + status);
System.out.println("[FormLogin] Response: " + response);
```

---

## 5. Windows Look & Feel Gotchas

### 5.1. JButton `setBackground` di-ignore (BUG #4)

Windows L&F render JButton via native theme painter — `setBackground()` di-ignore. Hasilnya: text putih di background putih = invisible.

✅ **Fix komplit** (di `SwingUtil.makeOpaque()`):
```java
public static void makeOpaque(JButton... buttons) {
    for (JButton b : buttons) {
        b.setOpaque(true);
        b.setContentAreaFilled(true);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setUI(new javax.swing.plaf.basic.BasicButtonUI());  // ← KUNCI
        b.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }
}
```

`setUI(new BasicButtonUI())` paksa pakai Basic UI delegate, override Windows native painter. Tanpa ini, walaupun setOpaque(true) tetep gak kelihatan.

### 5.2. JTableHeader colors di-ignore

Sama, `header.setBackground/setForeground` di-ignore. Fix: custom renderer:
```java
public static void styleTableHeader(JTable table) {
    table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
            JLabel lbl = (JLabel) super.getTableCellRendererComponent(t, v, s, f, r, c);
            lbl.setBackground(new Color(44, 62, 80));
            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
            lbl.setOpaque(true);
            lbl.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
            return lbl;
        }
    });
}
```

Call `SwingUtil.makeOpaque(...)` dan `SwingUtil.styleTableHeader(table)` dari `setupTabel()` di setiap form.

---

## 6. Workflow Build Project dari Awal

Kalau ada tugas serupa (NetBeans Java Swing + API/DB), ikuti urutan ini:

1. **Setup folder** + copy lib/database/api dependencies
2. **Buat custom Swing components** dulu di `package.komponen` (PanelGradient, ButtonGradient, helper SwingUtil) — supaya Design View kenal kelas-kelasnya
3. **Class koneksi** (`ApiClient` atau `KoneksiDatabase`):
   - HTTP: pakai HttpURLConnection + User-Agent browser + TLS 1.2 setting
   - JSON parsing manual (tanpa Gson) — pakai pattern di `ApiClient.parseDataArray()` & `parseObject()`
4. **Form per form**, untuk masing-masing:
   - Tulis `.java` dengan GEN markers, semua component di `initComponents()` dengan `setBounds(x,y,w,h)`
   - Tulis `.form` paralel — class name benar (`DesignAbsoluteLayout$AbsoluteConstraintsDescription`)
   - Untuk JFrame: `formSizePolicy=2` + `formSize` bytes
   - Custom setup (tabel, event listener tabel, makeOpaque, styleTableHeader) di method `setupTabel()` di luar GEN block, dipanggil dari constructor
5. **Project files NetBeans** (`nbproject/project.xml`, `nbproject/project.properties`, `build.xml`, `manifest.mf`, `genfiles.properties`)
6. **Compile test** pakai `javac --release 8` untuk verifikasi sebelum buka di NetBeans
7. **Buka di NetBeans** → Clean and Build → Run

### Test cepat kalau API kerja
```bash
curl -s -X POST -H "Content-Type: application/json" \
  -H "User-Agent: Mozilla/5.0 ..." \
  -d '{"username":"admin","password":"admin123"}' \
  https://api-perpustakaan.tofla.id/api/gym/login
```

### Compile manual (kalau NetBeans bermasalah)
```bash
cd <project-dir>
find src -name "*.java" > sources.txt
javac --release 8 -d build/classes -cp "lib/mariadb-java-client-3.3.3.jar" @sources.txt
java -cp "build/classes;lib/mariadb-java-client-3.3.3.jar" gym.form.FormLogin
```

---

## 7. Endpoint API Gym

Base URL: `https://api-perpustakaan.tofla.id/api/gym`

| Method | Path | Fungsi |
|--------|------|--------|
| POST | `/login` | Login admin |
| GET | `/member`, `/trainer`, `/paket`, `/kelas`, `/pendaftaran`, `/jadwal`, `/billing` | List semua |
| GET | `/{resource}/{id}` | Detail |
| POST | `/{resource}` | Insert |
| PUT | `/{resource}/{id}` | Update |
| DELETE | `/{resource}/{id}` | Hapus |

Response sukses umum: `{"data": [...]}` untuk list, `{...}` untuk detail, `{"success":true}` untuk login/post/put/delete.

Skema database lengkap di `database/gym_me.sql`. Detail field & endpoint di `api_server/dokumentasi_api.txt`.

---

## 8. Bug Sequence yang Pernah Terjadi (Cronological)

1. ❌ `.form` pake `AbsoluteLayout$AbsoluteConstraintsDescription` (salah) → NetBeans wipe semua posisi jadi 0,0/-1,-1 → form kosong di Design View
2. ❌ `formSizePolicy=1` → `pack()` generated → form jadi kotak kecil saat run
3. ❌ Java default User-Agent → Cloudflare 1010 (HTTP 403) → "login salah" walaupun credentials benar
4. ❌ Windows L&F native button paint → setBackground ignored → text putih di bg putih → tombol kosong
5. ❌ JTableHeader native paint → setBackground ignored → header kosong putih

Semua sudah di-fix di session ini. Detail solusi di bagian 2, 4, 5 di atas.

---

## 9. Upgrade Report ke JasperReports (2026-05-23)

Sebelumnya semua 4 laporan pakai `JTable.print()` — sederhana tapi tidak profesional. Sekarang sudah di-upgrade ke **JasperReports 6.20.6** (last version yang support JDK 8).

### 9.1. Dependencies di `lib/`
| JAR | Size | Fungsi |
|-----|------|--------|
| jasperreports-6.20.6.jar | 5.5 MB | Core library |
| commons-beanutils-1.9.4.jar | 247 KB | Bean property access |
| commons-collections4-4.4.jar | 752 KB | Collection utilities |
| commons-digester-2.1.jar | 197 KB | XML parsing |
| commons-logging-1.2.jar | 62 KB | Logging facade |
| groovy-3.0.9.jar | 8.0 MB | Expression evaluation (default expression language) |

### 9.2. Pattern Implementation

**1 helper class + 4 .jrxml + 4 Java update**:

```
src/gym/report/
├── JasperHelper.java                    ← helper compile + fill + viewer
├── laporan_member.jrxml                 ← template design
├── laporan_trainer.jrxml
├── laporan_transaksi_membership.jrxml
├── laporan_rekap_jadwal.jrxml
├── LaporanMember.java + .form           ← UI tetap, tinggal panggil helper
├── LaporanTrainer.java + .form
├── LaporanTransaksiMembership.java + .form
└── LaporanRekapJadwal.java + .form
```

### 9.3. Cara kerja
1. `Laporan*.java` saat `muatData()` selain isi `DefaultTableModel` (untuk preview JTable), juga simpan `List<Map<String,?>> dataLaporan`
2. Klik tombol "Cetak Laporan" → panggil `JasperHelper.tampilkanLaporan(this, "/gym/report/laporan_xxx.jrxml", "Judul", dataLaporan)`
3. Helper: load .jrxml dari classpath → `JasperCompileManager.compileReport()` → `JRMapCollectionDataSource(data)` → `JasperFillManager.fillReport()` → tampilkan `JRViewer` di `JDialog`

### 9.4. Format .jrxml dipakai
- Page: A4 Landscape (842×595), margin 20
- Title band: gradient warna sesuai laporan (red/orange/blue/green) + parameter `$P{judul}` + `$P{tanggalCetak}`
- Column header: bg dark navy (#2C3E50) putih bold
- Detail band: 22px row, border tipis #DDDDDD
- Summary: total record via `$V{REPORT_COUNT}`
- PageFooter: brand info + page number

### 9.5. Field mapping (Map key → $F{...})
Pakai `JRMapCollectionDataSource` jadi field di .jrxml harus match key di Map:
- Member: `no`, `id_member`, `nama`, `jenis_kelamin`, `tempat_lahir`, `tanggal_lahir`, `alamat`, `no_hp`, `email`, `tanggal_daftar`
- Trainer: `no`, `id_trainer`, `nama`, `spesialisasi`, `no_hp`, `email`, `status`, `total_kelas`
- Transaksi: `no`, `id_pendaftaran`, `nama_member`, `nama_paket`, `tanggal_daftar`, `tanggal_expired`, `status`
- Jadwal: `no`, `id_jadwal`, `nama_member`, `nama_kelas`, `nama_trainer`, `hari`, `jam`, `tanggal`

### 9.6. Classpath update
File: `nbproject/project.properties`:
```properties
file.reference.jasperreports-6.20.6.jar=lib/jasperreports-6.20.6.jar
file.reference.commons-beanutils-1.9.4.jar=lib/commons-beanutils-1.9.4.jar
# ... (semua 6 JAR)
javac.classpath=\
    ${file.reference.mariadb-java-client-3.3.3.jar}:\
    ${file.reference.jasperreports-6.20.6.jar}:\
    ${file.reference.commons-beanutils-1.9.4.jar}:\
    ${file.reference.commons-collections4-4.4.jar}:\
    ${file.reference.commons-digester-2.1.jar}:\
    ${file.reference.commons-logging-1.2.jar}:\
    ${file.reference.groovy-3.0.9.jar}
```

File: `jalankan.bat` — tambahkan semua JAR ke `-cp`.

### 9.7. Gotchas saat setup
- **.jrxml harus ada di classpath** — NetBeans Ant build auto-copy resources non-`.java`/`.form` ke `build/classes/`. Untuk testing manual, perlu `cp src/gym/report/*.jrxml build/classes/gym/report/` setelah javac.
- **`isStretchWithOverflow` deprecated** di JR 6.x — masih jalan, tapi warning. Pengganti: `textAdjust="StretchHeight"`. Saat ini masih dipakai karena lebih compatible dengan iReport lama.
- **JDK 8 + JR 7.x tidak compatible** — JR 7.x butuh Java 11+. Stick dengan 6.20.x.
- Versi groovy untuk JR 6.20: groovy 3.0.x (groovy 4.x mungkin error).

### 9.7.1. BUG #6: `UnsupportedClassVersionError class file version 67.0` saat klik Cetak

**Gejala**: Klik tombol Cetak Laporan → di console NetBeans muncul:
```
Exception in thread "AWT-EventQueue-0" java.lang.UnsupportedClassVersionError:
  laporan_member_xxx has been compiled by a more recent version of the Java Runtime
  (class file version 67.0), this version of the Java Runtime only recognizes class
  file versions up to 52.0
```

**Penyebab**: JR default language `"java"` → tidak ada JDT bundled di JR 6.20.6 → fallback ke `JRJavacCompiler` → invoke external `javac` dari PATH. Kalau PATH user ada JDK 21+ (class version 65+) sementara JVM runtime JDK 8 (max 52), bytecode tidak bisa di-load.

**Fix**: Pakai **Groovy compiler** (in-process, otomatis match JDK runtime). Dua langkah:

1. Tambahkan `language="groovy"` di root tag setiap `.jrxml`:
```xml
<jasperReport ... name="xxx" language="groovy" pageWidth="842" ...>
```

2. Set property di `JasperHelper` (defense in depth):
```java
static {
    DefaultJasperReportsContext.getInstance().setProperty(
        "net.sf.jasperreports.compiler.class",
        "net.sf.jasperreports.compilers.JRGroovyCompiler");
}
```

**IMPORTANT — class name yang benar di JR 6.20.6**: `net.sf.jasperreports.compilers.JRGroovyCompiler` (dengan prefix `JR`). NOT `ReportGroovyCompiler` (itu nama yang masuk JR 7.x).

Verifikasi class tersedia di JAR:
```powershell
Add-Type -AssemblyName System.IO.Compression.FileSystem
$zip = [System.IO.Compression.ZipFile]::OpenRead("lib/jasperreports-6.20.6.jar")
$zip.Entries | Where-Object { $_.FullName -match "Groovy" }
$zip.Dispose()
```
Output di JR 6.20.6 berisi `JRGroovyCompiler.class`, BUKAN `ReportGroovyCompiler.class`.

**Verifikasi**: `groovy-3.0.9.jar` HARUS sudah ada di classpath (sudah ditambahkan di section 9.1). Setelah edit `.jrxml`, **Clean and Build** project (Shift+F11) — jangan cuma Run, karena cache build/classes harus di-refresh.

### 9.8. Verifikasi build
```bash
cd <project>
javac -source 1.8 -target 1.8 -d build/classes \
  -cp "lib/jasperreports-6.20.6.jar;lib/commons-beanutils-1.9.4.jar;lib/commons-collections4-4.4.jar;lib/commons-digester-2.1.jar;lib/commons-logging-1.2.jar;lib/groovy-3.0.9.jar;lib/mariadb-java-client-3.3.3.jar" \
  @sources.txt
# expected: only deprecation warnings, no errors
```

---

## 10. Anggota Kelompok 2 (untuk header dokumentasi)

1. Sri Wahyuni (202343501188)
2. Angelina Elvira Irani (202343501184)
3. Hamdan Hafizh (202343501215)
4. Aditya Darma (202343501179)
5. Aditya Nugraha (202343501284)
6. Muhammad Billadilathof (202343501282)
