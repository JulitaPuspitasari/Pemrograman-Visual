-- ================================================
-- DATABASE APLIKASI MANAJEMEN FITNESS CENTER
-- Nama Aplikasi: Gym Me
-- ================================================

CREATE DATABASE IF NOT EXISTS db_gym;
USE db_gym;

-- ================================================
-- TABEL ADMIN (untuk login)
-- ================================================
CREATE TABLE admin (
    id_admin VARCHAR(10) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- ================================================
-- TABEL MEMBER
-- ================================================
CREATE TABLE member (
    id_member VARCHAR(10) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    jenis_kelamin ENUM('Laki-laki', 'Perempuan') NOT NULL,
    tempat_lahir VARCHAR(100) NOT NULL,
    tanggal_lahir DATE NOT NULL,
    alamat VARCHAR(255) NOT NULL,
    no_hp VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    tanggal_daftar DATE NOT NULL
);

-- ================================================
-- TABEL PERSONAL TRAINER
-- ================================================
CREATE TABLE personal_trainer (
    id_trainer VARCHAR(10) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    spesialisasi VARCHAR(100) NOT NULL,
    no_hp VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    status ENUM('Aktif', 'Tidak Aktif') NOT NULL DEFAULT 'Aktif'
);

-- ================================================
-- TABEL PAKET MEMBERSHIP
-- ================================================
CREATE TABLE paket_membership (
    id_paket VARCHAR(10) PRIMARY KEY,
    nama_paket VARCHAR(100) NOT NULL,
    durasi_bulan INT NOT NULL,
    harga INT NOT NULL,
    fasilitas VARCHAR(255) NOT NULL
);

-- ================================================
-- TABEL KELAS
-- ================================================
CREATE TABLE kelas (
    id_kelas VARCHAR(10) PRIMARY KEY,
    nama_kelas VARCHAR(100) NOT NULL,
    deskripsi VARCHAR(255) NOT NULL,
    kapasitas INT NOT NULL DEFAULT 20
);

-- ================================================
-- TABEL PENDAFTARAN MEMBERSHIP
-- ================================================
CREATE TABLE pendaftaran_membership (
    id_pendaftaran VARCHAR(10) PRIMARY KEY,
    id_member VARCHAR(10) NOT NULL,
    id_paket VARCHAR(10) NOT NULL,
    tanggal_daftar DATE NOT NULL,
    tanggal_expired DATE NOT NULL,
    status ENUM('Aktif', 'Expired') NOT NULL DEFAULT 'Aktif',
    FOREIGN KEY (id_member) REFERENCES member(id_member),
    FOREIGN KEY (id_paket) REFERENCES paket_membership(id_paket)
);

-- ================================================
-- TABEL JADWAL KELAS & TRAINER
-- ================================================
CREATE TABLE jadwal_kelas (
    id_jadwal VARCHAR(10) PRIMARY KEY,
    id_member VARCHAR(10) NOT NULL,
    id_kelas VARCHAR(10) NOT NULL,
    id_trainer VARCHAR(10) NOT NULL,
    hari VARCHAR(20) NOT NULL,
    jam VARCHAR(20) NOT NULL,
    tanggal DATE NOT NULL,
    FOREIGN KEY (id_member) REFERENCES member(id_member),
    FOREIGN KEY (id_kelas) REFERENCES kelas(id_kelas),
    FOREIGN KEY (id_trainer) REFERENCES personal_trainer(id_trainer)
);

-- ================================================
-- TABEL BILLING / PEMBAYARAN
-- ================================================
CREATE TABLE billing (
    id_billing VARCHAR(10) PRIMARY KEY,
    id_member VARCHAR(10) NOT NULL,
    id_paket VARCHAR(10) NOT NULL,
    id_trainer VARCHAR(10),
    tanggal_bayar DATE NOT NULL,
    jumlah_bayar INT NOT NULL,
    metode_bayar ENUM('Cash', 'Transfer', 'E-Wallet') NOT NULL DEFAULT 'Cash',
    status_bayar ENUM('Lunas', 'Belum Lunas') NOT NULL DEFAULT 'Belum Lunas',
    FOREIGN KEY (id_member) REFERENCES member(id_member),
    FOREIGN KEY (id_paket) REFERENCES paket_membership(id_paket),
    FOREIGN KEY (id_trainer) REFERENCES personal_trainer(id_trainer)
);

-- ================================================
-- DATA ADMIN DEFAULT
-- ================================================
INSERT INTO admin VALUES ('ADM001', 'Administrator', 'admin', 'admin123');
INSERT INTO admin VALUES ('ADM002', 'Sri Wahyuni', 'sri', 'sri123');

-- ================================================
-- DATA PERSONAL TRAINER
-- ================================================
INSERT INTO personal_trainer VALUES ('TR001', 'Reza Firmansyah', 'Weight Training', '081300000001', 'reza@gymme.com', 'Aktif');
INSERT INTO personal_trainer VALUES ('TR002', 'Dinda Pratiwi', 'Yoga & Pilates', '081300000002', 'dinda@gymme.com', 'Aktif');
INSERT INTO personal_trainer VALUES ('TR003', 'Bagus Setiawan', 'Cardio & HIIT', '081300000003', 'bagus@gymme.com', 'Aktif');
INSERT INTO personal_trainer VALUES ('TR004', 'Sari Melati', 'Zumba & Aerobic', '081300000004', 'sari@gymme.com', 'Aktif');
INSERT INTO personal_trainer VALUES ('TR005', 'Andi Prasetyo', 'Muay Thai & Boxing', '081300000005', 'andi@gymme.com', 'Aktif');
INSERT INTO personal_trainer VALUES ('TR006', 'Rina Susanti', 'CrossFit', '081300000006', 'rina@gymme.com', 'Aktif');
INSERT INTO personal_trainer VALUES ('TR007', 'Fajar Nugroho', 'Bodybuilding', '081300000007', 'fajar@gymme.com', 'Tidak Aktif');

-- ================================================
-- DATA PAKET MEMBERSHIP
-- ================================================
INSERT INTO paket_membership VALUES ('PKT001', 'Basic Monthly', 1, 250000, 'Akses gym area, Locker');
INSERT INTO paket_membership VALUES ('PKT002', 'Silver 3 Bulan', 3, 650000, 'Akses gym area, Locker, Handuk');
INSERT INTO paket_membership VALUES ('PKT003', 'Gold 6 Bulan', 6, 1200000, 'Akses gym area, Locker, Handuk, 2x Kelas/minggu');
INSERT INTO paket_membership VALUES ('PKT004', 'Platinum 12 Bulan', 12, 2000000, 'Full akses, Personal Trainer 4x/bulan, Semua kelas');
INSERT INTO paket_membership VALUES ('PKT005', 'Student Monthly', 1, 150000, 'Akses gym area (khusus mahasiswa)');

-- ================================================
-- DATA KELAS
-- ================================================
INSERT INTO kelas VALUES ('KLS001', 'Zumba', 'Kelas dansa aerobik dengan musik latin', 25);
INSERT INTO kelas VALUES ('KLS002', 'Muay Thai', 'Kelas bela diri Thai Boxing', 15);
INSERT INTO kelas VALUES ('KLS003', 'Yoga', 'Kelas yoga untuk kelenturan dan relaksasi', 20);
INSERT INTO kelas VALUES ('KLS004', 'HIIT', 'High Intensity Interval Training', 20);
INSERT INTO kelas VALUES ('KLS005', 'Body Combat', 'Kelas kombinasi gerakan bela diri', 25);
INSERT INTO kelas VALUES ('KLS006', 'Pilates', 'Latihan kekuatan otot inti dan postur', 15);
INSERT INTO kelas VALUES ('KLS007', 'Spinning', 'Kelas sepeda statis intensitas tinggi', 20);
INSERT INTO kelas VALUES ('KLS008', 'CrossFit', 'Latihan fungsional intensitas tinggi', 15);

-- ================================================
-- DATA 20 MEMBER
-- ================================================
INSERT INTO member VALUES ('MBR001', 'Ahmad Fauzi', 'Laki-laki', 'Jakarta', '1998-05-10', 'Jl. Merpati No. 10, Jakarta Selatan', '081200000001', 'ahmad.fauzi@email.com', '2025-01-05');
INSERT INTO member VALUES ('MBR002', 'Bella Permata', 'Perempuan', 'Depok', '2000-08-22', 'Jl. Kenanga No. 5, Depok', '081200000002', 'bella.permata@email.com', '2025-01-10');
INSERT INTO member VALUES ('MBR003', 'Chandra Wijaya', 'Laki-laki', 'Bogor', '1997-03-15', 'Jl. Melati No. 8, Bogor', '081200000003', 'chandra.w@email.com', '2025-01-15');
INSERT INTO member VALUES ('MBR004', 'Dian Safitri', 'Perempuan', 'Tangerang', '2001-11-30', 'Jl. Mawar No. 12, Tangerang', '081200000004', 'dian.safitri@email.com', '2025-01-20');
INSERT INTO member VALUES ('MBR005', 'Eko Prasetyo', 'Laki-laki', 'Bekasi', '1999-07-18', 'Jl. Anggrek No. 3, Bekasi', '081200000005', 'eko.prasetyo@email.com', '2025-02-01');
INSERT INTO member VALUES ('MBR006', 'Fitri Handayani', 'Perempuan', 'Jakarta', '2000-02-14', 'Jl. Dahlia No. 7, Jakarta Timur', '081200000006', 'fitri.h@email.com', '2025-02-05');
INSERT INTO member VALUES ('MBR007', 'Gilang Ramadhan', 'Laki-laki', 'Depok', '1998-12-25', 'Jl. Flamboyan No. 15, Depok', '081200000007', 'gilang.r@email.com', '2025-02-10');
INSERT INTO member VALUES ('MBR008', 'Hana Aulia', 'Perempuan', 'Bogor', '2001-06-08', 'Jl. Cempaka No. 20, Bogor', '081200000008', 'hana.aulia@email.com', '2025-02-15');
INSERT INTO member VALUES ('MBR009', 'Irfan Hakim', 'Laki-laki', 'Jakarta', '1996-09-12', 'Jl. Teratai No. 9, Jakarta Barat', '081200000009', 'irfan.h@email.com', '2025-02-20');
INSERT INTO member VALUES ('MBR010', 'Jessica Tanujaya', 'Perempuan', 'Tangerang', '2000-04-03', 'Jl. Bougenville No. 11, Tangerang', '081200000010', 'jessica.t@email.com', '2025-03-01');
INSERT INTO member VALUES ('MBR011', 'Kevin Sanjaya', 'Laki-laki', 'Bekasi', '1997-01-28', 'Jl. Kamboja No. 6, Bekasi', '081200000011', 'kevin.s@email.com', '2025-03-05');
INSERT INTO member VALUES ('MBR012', 'Lina Marlina', 'Perempuan', 'Jakarta', '1999-10-17', 'Jl. Seroja No. 14, Jakarta Utara', '081200000012', 'lina.m@email.com', '2025-03-10');
INSERT INTO member VALUES ('MBR013', 'Muhammad Rizky', 'Laki-laki', 'Depok', '2001-05-22', 'Jl. Tulip No. 18, Depok', '081200000013', 'rizky.m@email.com', '2025-03-15');
INSERT INTO member VALUES ('MBR014', 'Nadia Putri', 'Perempuan', 'Bogor', '2000-07-09', 'Jl. Aster No. 4, Bogor', '081200000014', 'nadia.p@email.com', '2025-03-20');
INSERT INTO member VALUES ('MBR015', 'Oscar Lawalata', 'Laki-laki', 'Jakarta', '1998-08-14', 'Jl. Lavender No. 22, Jakarta Selatan', '081200000015', 'oscar.l@email.com', '2025-04-01');
INSERT INTO member VALUES ('MBR016', 'Putri Anggraini', 'Perempuan', 'Tangerang', '2001-12-01', 'Jl. Sakura No. 8, Tangerang Selatan', '081200000016', 'putri.a@email.com', '2025-04-05');
INSERT INTO member VALUES ('MBR017', 'Rafi Aditya', 'Laki-laki', 'Bekasi', '1999-03-27', 'Jl. Orchid No. 16, Bekasi', '081200000017', 'rafi.a@email.com', '2025-04-10');
INSERT INTO member VALUES ('MBR018', 'Sarah Amelia', 'Perempuan', 'Jakarta', '2000-09-05', 'Jl. Lotus No. 13, Jakarta Pusat', '081200000018', 'sarah.a@email.com', '2025-04-15');
INSERT INTO member VALUES ('MBR019', 'Taufik Hidayat', 'Laki-laki', 'Depok', '1997-06-20', 'Jl. Jasmine No. 10, Depok', '081200000019', 'taufik.h@email.com', '2025-04-20');
INSERT INTO member VALUES ('MBR020', 'Umi Kalsum', 'Perempuan', 'Bogor', '2001-02-11', 'Jl. Lily No. 5, Bogor', '081200000020', 'umi.k@email.com', '2025-05-01');

-- ================================================
-- DATA PENDAFTARAN MEMBERSHIP
-- ================================================
INSERT INTO pendaftaran_membership VALUES ('REG001', 'MBR001', 'PKT004', '2025-01-05', '2026-01-05', 'Aktif');
INSERT INTO pendaftaran_membership VALUES ('REG002', 'MBR002', 'PKT003', '2025-01-10', '2025-07-10', 'Aktif');
INSERT INTO pendaftaran_membership VALUES ('REG003', 'MBR003', 'PKT002', '2025-01-15', '2025-04-15', 'Expired');
INSERT INTO pendaftaran_membership VALUES ('REG004', 'MBR004', 'PKT005', '2025-01-20', '2025-02-20', 'Expired');
INSERT INTO pendaftaran_membership VALUES ('REG005', 'MBR005', 'PKT001', '2025-02-01', '2025-03-01', 'Expired');
INSERT INTO pendaftaran_membership VALUES ('REG006', 'MBR006', 'PKT004', '2025-02-05', '2026-02-05', 'Aktif');
INSERT INTO pendaftaran_membership VALUES ('REG007', 'MBR007', 'PKT003', '2025-02-10', '2025-08-10', 'Aktif');
INSERT INTO pendaftaran_membership VALUES ('REG008', 'MBR008', 'PKT002', '2025-02-15', '2025-05-15', 'Aktif');

-- ================================================
-- DATA JADWAL KELAS & TRAINER
-- ================================================
INSERT INTO jadwal_kelas VALUES ('JDW001', 'MBR001', 'KLS001', 'TR004', 'Senin', '08:00 - 09:00', '2025-09-01');
INSERT INTO jadwal_kelas VALUES ('JDW002', 'MBR002', 'KLS003', 'TR002', 'Selasa', '10:00 - 11:00', '2025-09-02');
INSERT INTO jadwal_kelas VALUES ('JDW003', 'MBR003', 'KLS002', 'TR005', 'Rabu', '16:00 - 17:00', '2025-09-03');
INSERT INTO jadwal_kelas VALUES ('JDW004', 'MBR006', 'KLS004', 'TR003', 'Kamis', '07:00 - 08:00', '2025-09-04');
INSERT INTO jadwal_kelas VALUES ('JDW005', 'MBR007', 'KLS008', 'TR006', 'Jumat', '17:00 - 18:00', '2025-09-05');
INSERT INTO jadwal_kelas VALUES ('JDW006', 'MBR001', 'KLS005', 'TR005', 'Sabtu', '09:00 - 10:00', '2025-09-06');

-- ================================================
-- DATA BILLING / PEMBAYARAN
-- ================================================
INSERT INTO billing VALUES ('BIL001', 'MBR001', 'PKT004', 'TR001', '2025-01-05', 2000000, 'Transfer', 'Lunas');
INSERT INTO billing VALUES ('BIL002', 'MBR002', 'PKT003', NULL, '2025-01-10', 1200000, 'Cash', 'Lunas');
INSERT INTO billing VALUES ('BIL003', 'MBR003', 'PKT002', NULL, '2025-01-15', 650000, 'E-Wallet', 'Lunas');
INSERT INTO billing VALUES ('BIL004', 'MBR004', 'PKT005', NULL, '2025-01-20', 150000, 'Cash', 'Lunas');
INSERT INTO billing VALUES ('BIL005', 'MBR005', 'PKT001', NULL, '2025-02-01', 250000, 'Transfer', 'Belum Lunas');
INSERT INTO billing VALUES ('BIL006', 'MBR006', 'PKT004', 'TR003', '2025-02-05', 2000000, 'E-Wallet', 'Lunas');
INSERT INTO billing VALUES ('BIL007', 'MBR007', 'PKT003', NULL, '2025-02-10', 1200000, 'Cash', 'Belum Lunas');
INSERT INTO billing VALUES ('BIL008', 'MBR008', 'PKT002', NULL, '2025-02-15', 650000, 'Transfer', 'Lunas');

-- ================================================
-- QUERY UNTUK LAPORAN
-- ================================================

-- Laporan Data Seluruh Member
-- SELECT id_member, nama, jenis_kelamin, tempat_lahir, tanggal_lahir, alamat, no_hp, email, tanggal_daftar FROM member ORDER BY id_member;

-- Laporan Data / Kinerja Trainer
-- SELECT t.id_trainer, t.nama, t.spesialisasi, t.no_hp, t.status, COUNT(j.id_jadwal) AS total_kelas
-- FROM personal_trainer t
-- LEFT JOIN jadwal_kelas j ON t.id_trainer = j.id_trainer
-- GROUP BY t.id_trainer ORDER BY t.id_trainer;

-- Laporan Transaksi Membership
-- SELECT pm.id_pendaftaran, m.nama AS nama_member, p.nama_paket, pm.tanggal_daftar, pm.tanggal_expired, pm.status
-- FROM pendaftaran_membership pm
-- JOIN member m ON pm.id_member = m.id_member
-- JOIN paket_membership p ON pm.id_paket = p.id_paket
-- ORDER BY pm.id_pendaftaran;

-- Laporan Rekap Jadwal Latihan Harian
-- SELECT j.id_jadwal, m.nama AS nama_member, k.nama_kelas, t.nama AS nama_trainer, j.hari, j.jam, j.tanggal
-- FROM jadwal_kelas j
-- JOIN member m ON j.id_member = m.id_member
-- JOIN kelas k ON j.id_kelas = k.id_kelas
-- JOIN personal_trainer t ON j.id_trainer = t.id_trainer
-- ORDER BY j.tanggal, j.jam;
