package gym.form;

import gym.koneksi.ApiClient;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class FormJadwalKelas extends javax.swing.JInternalFrame {

    private DefaultTableModel model;

    public FormJadwalKelas() {
        initComponents();
        panelHeader.setColorStart(new Color(39, 174, 96));
        setupTabel();
        tampilData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new gym.komponen.PanelGradient();
        lblHeader = new javax.swing.JLabel();
        panelInput = new javax.swing.JPanel();
        lblIdJadwal = new javax.swing.JLabel();
        txtIdJadwal = new javax.swing.JTextField();
        lblIdMember = new javax.swing.JLabel();
        txtIdMember = new javax.swing.JTextField();
        lblIdKelas = new javax.swing.JLabel();
        txtIdKelas = new javax.swing.JTextField();
        lblIdTrainer = new javax.swing.JLabel();
        txtIdTrainer = new javax.swing.JTextField();
        lblHari = new javax.swing.JLabel();
        txtHari = new javax.swing.JTextField();
        lblJam = new javax.swing.JLabel();
        txtJam = new javax.swing.JTextField();
        lblFmt1 = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        lblFmt2 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCariJadwal = new javax.swing.JButton();
        btnCariMember = new javax.swing.JButton();
        btnCariKelas = new javax.swing.JButton();
        btnCariTrainer = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tabelJadwal = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Jadwal Kelas & Trainer");
        getContentPane().setLayout(null);

        panelHeader.setLayout(null);

        lblHeader.setFont(new java.awt.Font("Segoe UI", 1, 16));
        lblHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblHeader.setText("Jadwal Kelas & Trainer");
        panelHeader.add(lblHeader);
        lblHeader.setBounds(15, 8, 400, 25);

        getContentPane().add(panelHeader);
        panelHeader.setBounds(0, 0, 1000, 40);

        panelInput.setBackground(new java.awt.Color(255, 255, 255));
        panelInput.setLayout(null);

        lblIdJadwal.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblIdJadwal.setForeground(new java.awt.Color(44, 62, 80));
        lblIdJadwal.setText("ID Jadwal");
        panelInput.add(lblIdJadwal);
        lblIdJadwal.setBounds(20, 25, 110, 25);

        txtIdJadwal.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtIdJadwal);
        txtIdJadwal.setBounds(140, 22, 180, 30);

        lblIdMember.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblIdMember.setForeground(new java.awt.Color(44, 62, 80));
        lblIdMember.setText("ID Member");
        panelInput.add(lblIdMember);
        lblIdMember.setBounds(20, 60, 110, 25);

        txtIdMember.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtIdMember);
        txtIdMember.setBounds(140, 57, 180, 30);

        lblIdKelas.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblIdKelas.setForeground(new java.awt.Color(44, 62, 80));
        lblIdKelas.setText("ID Kelas");
        panelInput.add(lblIdKelas);
        lblIdKelas.setBounds(20, 95, 110, 25);

        txtIdKelas.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtIdKelas);
        txtIdKelas.setBounds(140, 92, 180, 30);

        lblIdTrainer.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblIdTrainer.setForeground(new java.awt.Color(44, 62, 80));
        lblIdTrainer.setText("ID Trainer");
        panelInput.add(lblIdTrainer);
        lblIdTrainer.setBounds(20, 130, 110, 25);

        txtIdTrainer.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtIdTrainer);
        txtIdTrainer.setBounds(140, 127, 180, 30);

        btnCariJadwal.setBackground(new java.awt.Color(39, 174, 96));
        btnCariJadwal.setFont(new java.awt.Font("Segoe UI", 1, 11));
        btnCariJadwal.setForeground(new java.awt.Color(255, 255, 255));
        btnCariJadwal.setText("Cari");
        btnCariJadwal.setBorderPainted(false);
        btnCariJadwal.setFocusPainted(false);
        btnCariJadwal.setToolTipText("Cari ID Jadwal");
        btnCariJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnCariJadwalActionPerformed(evt); }
        });
        panelInput.add(btnCariJadwal);
        btnCariJadwal.setBounds(325, 22, 70, 30);

        btnCariMember.setBackground(new java.awt.Color(39, 174, 96));
        btnCariMember.setFont(new java.awt.Font("Segoe UI", 1, 11));
        btnCariMember.setForeground(new java.awt.Color(255, 255, 255));
        btnCariMember.setText("Cari");
        btnCariMember.setBorderPainted(false);
        btnCariMember.setFocusPainted(false);
        btnCariMember.setToolTipText("Cari ID Member");
        btnCariMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnCariMemberActionPerformed(evt); }
        });
        panelInput.add(btnCariMember);
        btnCariMember.setBounds(325, 57, 70, 30);

        btnCariKelas.setBackground(new java.awt.Color(39, 174, 96));
        btnCariKelas.setFont(new java.awt.Font("Segoe UI", 1, 11));
        btnCariKelas.setForeground(new java.awt.Color(255, 255, 255));
        btnCariKelas.setText("Cari");
        btnCariKelas.setBorderPainted(false);
        btnCariKelas.setFocusPainted(false);
        btnCariKelas.setToolTipText("Cari ID Kelas");
        btnCariKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnCariKelasActionPerformed(evt); }
        });
        panelInput.add(btnCariKelas);
        btnCariKelas.setBounds(325, 92, 70, 30);

        btnCariTrainer.setBackground(new java.awt.Color(39, 174, 96));
        btnCariTrainer.setFont(new java.awt.Font("Segoe UI", 1, 11));
        btnCariTrainer.setForeground(new java.awt.Color(255, 255, 255));
        btnCariTrainer.setText("Cari");
        btnCariTrainer.setBorderPainted(false);
        btnCariTrainer.setFocusPainted(false);
        btnCariTrainer.setToolTipText("Cari ID Trainer");
        btnCariTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnCariTrainerActionPerformed(evt); }
        });
        panelInput.add(btnCariTrainer);
        btnCariTrainer.setBounds(325, 127, 70, 30);

        lblHari.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblHari.setForeground(new java.awt.Color(44, 62, 80));
        lblHari.setText("Hari");
        panelInput.add(lblHari);
        lblHari.setBounds(20, 165, 110, 25);

        txtHari.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtHari);
        txtHari.setBounds(140, 162, 150, 30);

        lblJam.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblJam.setForeground(new java.awt.Color(44, 62, 80));
        lblJam.setText("Jam");
        panelInput.add(lblJam);
        lblJam.setBounds(20, 200, 110, 25);

        txtJam.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtJam);
        txtJam.setBounds(140, 197, 150, 30);

        lblFmt1.setFont(new java.awt.Font("Segoe UI", 2, 11));
        lblFmt1.setForeground(new java.awt.Color(149, 165, 166));
        lblFmt1.setText("(cth: 08:00 - 09:00)");
        panelInput.add(lblFmt1);
        lblFmt1.setBounds(295, 200, 150, 25);

        lblTanggal.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblTanggal.setForeground(new java.awt.Color(44, 62, 80));
        lblTanggal.setText("Tanggal");
        panelInput.add(lblTanggal);
        lblTanggal.setBounds(500, 25, 100, 25);

        txtTanggal.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtTanggal);
        txtTanggal.setBounds(600, 22, 150, 30);

        lblFmt2.setFont(new java.awt.Font("Segoe UI", 2, 11));
        lblFmt2.setForeground(new java.awt.Color(149, 165, 166));
        lblFmt2.setText("(yyyy-MM-dd)");
        panelInput.add(lblFmt2);
        lblFmt2.setBounds(755, 25, 100, 25);

        btnSimpan.setBackground(new java.awt.Color(46, 204, 113));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.setBorderPainted(false);
        btnSimpan.setFocusPainted(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnSimpanActionPerformed(evt); }
        });
        panelInput.add(btnSimpan);
        btnSimpan.setBounds(500, 65, 110, 33);

        btnEdit.setBackground(new java.awt.Color(41, 128, 185));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.setBorderPainted(false);
        btnEdit.setFocusPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnEditActionPerformed(evt); }
        });
        panelInput.add(btnEdit);
        btnEdit.setBounds(615, 65, 110, 33);

        btnHapus.setBackground(new java.awt.Color(192, 57, 43));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.setBorderPainted(false);
        btnHapus.setFocusPainted(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnHapusActionPerformed(evt); }
        });
        panelInput.add(btnHapus);
        btnHapus.setBounds(500, 103, 110, 33);

        btnReset.setBackground(new java.awt.Color(243, 156, 18));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.setBorderPainted(false);
        btnReset.setFocusPainted(false);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnResetActionPerformed(evt); }
        });
        panelInput.add(btnReset);
        btnReset.setBounds(615, 103, 110, 33);

        getContentPane().add(panelInput);
        panelInput.setBounds(0, 40, 1000, 240);

        tabelJadwal.setFont(new java.awt.Font("Segoe UI", 0, 12));
        tabelJadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID Jadwal", "Nama Member", "Kelas", "Trainer", "Hari", "Jam", "Tanggal"}
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }
        });
        scrollPane.setViewportView(tabelJadwal);

        getContentPane().add(scrollPane);
        scrollPane.setBounds(10, 285, 980, 250);

        setSize(new java.awt.Dimension(1000, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        simpan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        edit();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCariJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariJadwalActionPerformed
        cariJadwal();
    }//GEN-LAST:event_btnCariJadwalActionPerformed

    private void btnCariMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariMemberActionPerformed
        cariMember();
    }//GEN-LAST:event_btnCariMemberActionPerformed

    private void btnCariKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariKelasActionPerformed
        cariKelas();
    }//GEN-LAST:event_btnCariKelasActionPerformed

    private void btnCariTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariTrainerActionPerformed
        cariTrainer();
    }//GEN-LAST:event_btnCariTrainerActionPerformed

    private void cariJadwal() {
        Window owner = SwingUtilities.getWindowAncestor(this);
        String id = DialogCariId.pilihId(owner, "Jadwal Kelas", "/jadwal", "id_jadwal",
            new String[]{"ID Jadwal", "ID Member", "ID Kelas", "ID Trainer", "Hari", "Jam", "Tanggal"},
            new String[]{"id_jadwal", "id_member", "id_kelas", "id_trainer", "hari", "jam", "tanggal"});
        if (id != null && !id.isEmpty()) {
            txtIdJadwal.setText(id);
            ambilIdDariJadwal(id);
        }
    }

    private void cariMember() {
        Window owner = SwingUtilities.getWindowAncestor(this);
        String id = DialogCariId.pilihId(owner, "Member", "/member", "id_member",
            new String[]{"ID Member", "Nama", "Jenis Kelamin", "No HP", "Email"},
            new String[]{"id_member", "nama", "jenis_kelamin", "no_hp", "email"});
        if (id != null && !id.isEmpty()) txtIdMember.setText(id);
    }

    private void cariKelas() {
        Window owner = SwingUtilities.getWindowAncestor(this);
        String id = DialogCariId.pilihId(owner, "Kelas", "/kelas", "id_kelas",
            new String[]{"ID Kelas", "Nama Kelas", "Deskripsi", "Kapasitas"},
            new String[]{"id_kelas", "nama_kelas", "deskripsi", "kapasitas"});
        if (id != null && !id.isEmpty()) txtIdKelas.setText(id);
    }

    private void cariTrainer() {
        Window owner = SwingUtilities.getWindowAncestor(this);
        String id = DialogCariId.pilihId(owner, "Personal Trainer", "/trainer", "id_trainer",
            new String[]{"ID Trainer", "Nama", "Spesialisasi", "No HP", "Status"},
            new String[]{"id_trainer", "nama", "spesialisasi", "no_hp", "status"});
        if (id != null && !id.isEmpty()) txtIdTrainer.setText(id);
    }

    private void setupTabel() {
        model = (DefaultTableModel) tabelJadwal.getModel();
        styleTable(tabelJadwal);
        tabelJadwal.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int r = tabelJadwal.getSelectedRow();
                if (r < 0) return;
                txtIdJadwal.setText(model.getValueAt(r, 0).toString());
                ambilIdDariJadwal(model.getValueAt(r, 0).toString());
                txtHari.setText(model.getValueAt(r, 4).toString());
                txtJam.setText(model.getValueAt(r, 5).toString());
                txtTanggal.setText(model.getValueAt(r, 6).toString());
            }
        });
        gym.komponen.SwingUtil.makeOpaque(btnSimpan, btnEdit, btnHapus, btnReset,
            btnCariJadwal, btnCariMember, btnCariKelas, btnCariTrainer);
        gym.komponen.SwingUtil.styleTableHeader(tabelJadwal);
    }

    private void ambilIdDariJadwal(String idJadwal) {
        try {
            ApiClient.ApiResponse res = ApiClient.get("/jadwal/" + ApiClient.encodePath(idJadwal));
            if (res.ok()) {
                Map<String, String> obj = ApiClient.parseObject(res.body);
                txtIdMember.setText(obj.getOrDefault("id_member", ""));
                txtIdKelas.setText(obj.getOrDefault("id_kelas", ""));
                txtIdTrainer.setText(obj.getOrDefault("id_trainer", ""));
            }
        } catch (Exception e) { /* ignore */ }
    }

    private void styleTable(JTable t) {
        t.setRowHeight(28);
        t.setGridColor(new Color(240, 240, 240));
        t.setSelectionBackground(new Color(39, 174, 96, 40));
        t.setShowVerticalLines(false);
        t.setIntercellSpacing(new Dimension(0, 1));
        JTableHeader h = t.getTableHeader();
        h.setFont(new Font("Segoe UI", Font.BOLD, 12));
        h.setBackground(new Color(44, 62, 80));
        h.setForeground(Color.WHITE);
        h.setPreferredSize(new Dimension(0, 35));
        h.setBorder(BorderFactory.createEmptyBorder());
        t.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable tb, Object v, boolean s, boolean f, int r, int c) {
                Component comp = super.getTableCellRendererComponent(tb, v, s, f, r, c);
                if (!s) comp.setBackground(r % 2 == 0 ? Color.WHITE : new Color(248, 249, 250));
                setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
                return comp;
            }
        });
    }

    private void tampilData() {
        model.setRowCount(0);
        try {
            Map<String, String> namaMember = new HashMap<>();
            Map<String, String> namaKelas = new HashMap<>();
            Map<String, String> namaTrainer = new HashMap<>();
            ApiClient.ApiResponse mres = ApiClient.get("/member");
            if (mres.ok()) for (Map<String, String> r : ApiClient.parseDataArray(mres.body)) namaMember.put(r.get("id_member"), r.get("nama"));
            ApiClient.ApiResponse kres = ApiClient.get("/kelas");
            if (kres.ok()) for (Map<String, String> r : ApiClient.parseDataArray(kres.body)) namaKelas.put(r.get("id_kelas"), r.get("nama_kelas"));
            ApiClient.ApiResponse tres = ApiClient.get("/trainer");
            if (tres.ok()) for (Map<String, String> r : ApiClient.parseDataArray(tres.body)) namaTrainer.put(r.get("id_trainer"), r.get("nama"));

            ApiClient.ApiResponse res = ApiClient.get("/jadwal");
            if (!res.ok()) { JOptionPane.showMessageDialog(this, "Gagal memuat: " + ApiClient.errorMessage(res.body)); return; }
            for (Map<String, String> r : ApiClient.parseDataArray(res.body)) {
                String idM = r.get("id_member"), idK = r.get("id_kelas"), idT = r.get("id_trainer");
                model.addRow(new Object[]{r.get("id_jadwal"),
                    namaMember.getOrDefault(idM, idM),
                    namaKelas.getOrDefault(idK, idK),
                    namaTrainer.getOrDefault(idT, idT),
                    r.get("hari"), r.get("jam"), r.get("tanggal")});
            }
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private Map<String, Object> formToMap() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id_jadwal", txtIdJadwal.getText().trim());
        m.put("id_member", txtIdMember.getText().trim());
        m.put("id_kelas", txtIdKelas.getText().trim());
        m.put("id_trainer", txtIdTrainer.getText().trim());
        m.put("hari", txtHari.getText().trim());
        m.put("jam", txtJam.getText().trim());
        m.put("tanggal", txtTanggal.getText().trim());
        return m;
    }

    private void simpan() {
        if (txtIdJadwal.getText().trim().isEmpty() || txtIdMember.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Jadwal dan ID Member harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        try {
            ApiClient.ApiResponse res = ApiClient.post("/jadwal", ApiClient.buildJson(formToMap()));
            if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil disimpan!"); reset(); tampilData(); }
            else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private void edit() {
        if (txtIdJadwal.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        try {
            String id = ApiClient.encodePath(txtIdJadwal.getText().trim());
            ApiClient.ApiResponse res = ApiClient.put("/jadwal/" + id, ApiClient.buildJson(formToMap()));
            if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil diupdate!"); reset(); tampilData(); }
            else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private void hapus() {
        if (txtIdJadwal.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        int c = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (c == JOptionPane.YES_OPTION) {
            try {
                String id = ApiClient.encodePath(txtIdJadwal.getText().trim());
                ApiClient.ApiResponse res = ApiClient.delete("/jadwal/" + id);
                if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil dihapus!"); reset(); tampilData(); }
                else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
            } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
        }
    }

    private void reset() {
        txtIdJadwal.setText(""); txtIdMember.setText(""); txtIdKelas.setText("");
        txtIdTrainer.setText(""); txtHari.setText(""); txtJam.setText(""); txtTanggal.setText("");
        txtIdJadwal.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariJadwal;
    private javax.swing.JButton btnCariKelas;
    private javax.swing.JButton btnCariMember;
    private javax.swing.JButton btnCariTrainer;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel lblFmt1;
    private javax.swing.JLabel lblFmt2;
    private javax.swing.JLabel lblHari;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblIdJadwal;
    private javax.swing.JLabel lblIdKelas;
    private javax.swing.JLabel lblIdMember;
    private javax.swing.JLabel lblIdTrainer;
    private javax.swing.JLabel lblJam;
    private javax.swing.JLabel lblTanggal;
    private gym.komponen.PanelGradient panelHeader;
    private javax.swing.JPanel panelInput;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabelJadwal;
    private javax.swing.JTextField txtHari;
    private javax.swing.JTextField txtIdJadwal;
    private javax.swing.JTextField txtIdKelas;
    private javax.swing.JTextField txtIdMember;
    private javax.swing.JTextField txtIdTrainer;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
