package rekam.medis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormRekamMedis extends javax.swing.JFrame {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public FormRekamMedis() {
        initComponents();
        setSize(840, 740);
        setLocationRelativeTo(null);
        txtTglPeriksa.setText(sdf.format(new Date()));
        loadRiwayat("");
    }

    private boolean cekKoneksi() {
        Connection c = Koneksi.getConnection();
        if (c == null) {
            JOptionPane.showMessageDialog(this,
                    "Koneksi ke database gagal. Periksa server / kredensial.",
                    "Error Koneksi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void loadRiwayat(String keyword) {
        DefaultTableModel model = (DefaultTableModel) tabelRiwayat.getModel();
        model.setRowCount(0);
        if (!cekKoneksi()) return;

        String sql =
            "SELECT r.no_daftar, r.tgl, d.nama AS nama_dokter, r.diagnosa " +
            "FROM rekam r " +
            "JOIN dokter d ON r.id_dok = d.id_dok " +
            "JOIN pasien p ON r.id_pas = p.id_pas " +
            "WHERE r.no_daftar LIKE ? OR p.id_pas LIKE ? OR p.nama LIKE ? OR r.diagnosa LIKE ? " +
            "ORDER BY r.tgl DESC, r.no_daftar DESC";

        try (PreparedStatement ps = Koneksi.getConnection().prepareStatement(sql)) {
            String like = "%" + keyword + "%";
            ps.setString(1, like);
            ps.setString(2, like);
            ps.setString(3, like);
            ps.setString(4, like);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("no_daftar"),
                        rs.getString("tgl"),
                        rs.getString("nama_dokter"),
                        rs.getString("diagnosa")
                    });
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Gagal memuat riwayat: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        txtNoDaftar.setText("");
        txtTglPeriksa.setText(sdf.format(new Date()));
        txtIdDokter.setText("");
        txtNamaDokter.setText("");
        txtIdPasien.setText("");
        txtNamaPasien.setText("");
        txtGolDarah.setText("");
        txtTinggi.setText("");
        txtBerat.setText("");
        txtDiagnosa.setText("");
        txtCariRiwayat.setText("");
        txtNoDaftar.requestFocus();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        lblNoDaftar = new javax.swing.JLabel();
        txtNoDaftar = new javax.swing.JTextField();
        lblTglPeriksa = new javax.swing.JLabel();
        txtTglPeriksa = new javax.swing.JTextField();
        sep1 = new javax.swing.JSeparator();
        lblIdDokter = new javax.swing.JLabel();
        txtIdDokter = new javax.swing.JTextField();
        btnCariDokter = new javax.swing.JButton();
        lblNamaDokter = new javax.swing.JLabel();
        txtNamaDokter = new javax.swing.JTextField();
        sep2 = new javax.swing.JSeparator();
        lblIdPasien = new javax.swing.JLabel();
        txtIdPasien = new javax.swing.JTextField();
        btnCariPasien = new javax.swing.JButton();
        lblNamaPasien = new javax.swing.JLabel();
        txtNamaPasien = new javax.swing.JTextField();
        lblGolDarah = new javax.swing.JLabel();
        txtGolDarah = new javax.swing.JTextField();
        lblTinggi = new javax.swing.JLabel();
        txtTinggi = new javax.swing.JTextField();
        lblBerat = new javax.swing.JLabel();
        txtBerat = new javax.swing.JTextField();
        lblDiagnosa = new javax.swing.JLabel();
        jScrollDiagnosa = new javax.swing.JScrollPane();
        txtDiagnosa = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        sep3 = new javax.swing.JSeparator();
        lblCariRiwayat = new javax.swing.JLabel();
        txtCariRiwayat = new javax.swing.JTextField();
        btnCariRiwayat = new javax.swing.JButton();
        jScrollTabel = new javax.swing.JScrollPane();
        tabelRiwayat = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rekam Medis");
        setResizable(false);
        getContentPane().setLayout(null);

        lblJudul.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(0, 0, 128));
        lblJudul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJudul.setText("~ Rekam Medis ~");
        lblJudul.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(lblJudul);
        lblJudul.setBounds(20, 10, 790, 55);

        lblNoDaftar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblNoDaftar.setForeground(new java.awt.Color(0, 0, 128));
        lblNoDaftar.setText("No. Pendaftaran");
        getContentPane().add(lblNoDaftar);
        lblNoDaftar.setBounds(20, 80, 130, 25);
        getContentPane().add(txtNoDaftar);
        txtNoDaftar.setBounds(160, 80, 220, 25);

        lblTglPeriksa.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblTglPeriksa.setForeground(new java.awt.Color(0, 0, 128));
        lblTglPeriksa.setText("Tanggal Pemeriksaan");
        getContentPane().add(lblTglPeriksa);
        lblTglPeriksa.setBounds(430, 80, 170, 25);

        txtTglPeriksa.setToolTipText("Format: yyyy-MM-dd");
        getContentPane().add(txtTglPeriksa);
        txtTglPeriksa.setBounds(610, 80, 200, 25);
        getContentPane().add(sep1);
        sep1.setBounds(10, 120, 810, 2);

        lblIdDokter.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblIdDokter.setForeground(new java.awt.Color(0, 0, 128));
        lblIdDokter.setText("ID Dokter");
        getContentPane().add(lblIdDokter);
        lblIdDokter.setBounds(20, 140, 120, 25);
        getContentPane().add(txtIdDokter);
        txtIdDokter.setBounds(160, 140, 180, 25);

        btnCariDokter.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCariDokter.setText("Cari");
        btnCariDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariDokterActionPerformed(evt);
            }
        });
        getContentPane().add(btnCariDokter);
        btnCariDokter.setBounds(350, 140, 80, 25);

        lblNamaDokter.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblNamaDokter.setForeground(new java.awt.Color(0, 0, 128));
        lblNamaDokter.setText("Nama Dokter");
        getContentPane().add(lblNamaDokter);
        lblNamaDokter.setBounds(20, 175, 120, 25);

        txtNamaDokter.setEditable(false);
        getContentPane().add(txtNamaDokter);
        txtNamaDokter.setBounds(160, 175, 650, 25);
        getContentPane().add(sep2);
        sep2.setBounds(10, 215, 810, 2);

        lblIdPasien.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblIdPasien.setForeground(new java.awt.Color(0, 0, 128));
        lblIdPasien.setText("No. Identitas Pasien");
        getContentPane().add(lblIdPasien);
        lblIdPasien.setBounds(20, 235, 160, 25);
        getContentPane().add(txtIdPasien);
        txtIdPasien.setBounds(190, 235, 180, 25);

        btnCariPasien.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCariPasien.setText("Cari");
        btnCariPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPasienActionPerformed(evt);
            }
        });
        getContentPane().add(btnCariPasien);
        btnCariPasien.setBounds(380, 235, 80, 25);

        lblNamaPasien.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblNamaPasien.setForeground(new java.awt.Color(0, 0, 128));
        lblNamaPasien.setText("Nama Pasien");
        getContentPane().add(lblNamaPasien);
        lblNamaPasien.setBounds(20, 270, 160, 25);

        txtNamaPasien.setEditable(false);
        getContentPane().add(txtNamaPasien);
        txtNamaPasien.setBounds(190, 270, 620, 25);

        lblGolDarah.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblGolDarah.setForeground(new java.awt.Color(0, 0, 128));
        lblGolDarah.setText("Golongan Darah");
        getContentPane().add(lblGolDarah);
        lblGolDarah.setBounds(20, 305, 160, 25);

        txtGolDarah.setEditable(false);
        txtGolDarah.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtGolDarah);
        txtGolDarah.setBounds(190, 305, 55, 25);

        lblTinggi.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblTinggi.setForeground(new java.awt.Color(0, 0, 128));
        lblTinggi.setText("Tinggi Badan");
        getContentPane().add(lblTinggi);
        lblTinggi.setBounds(20, 340, 160, 25);
        getContentPane().add(txtTinggi);
        txtTinggi.setBounds(190, 340, 80, 25);

        lblBerat.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblBerat.setForeground(new java.awt.Color(0, 0, 128));
        lblBerat.setText("Berat Badan");
        getContentPane().add(lblBerat);
        lblBerat.setBounds(20, 375, 160, 25);
        getContentPane().add(txtBerat);
        txtBerat.setBounds(190, 375, 80, 25);

        lblDiagnosa.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblDiagnosa.setForeground(new java.awt.Color(0, 0, 128));
        lblDiagnosa.setText("Diagnosa Dokter");
        getContentPane().add(lblDiagnosa);
        lblDiagnosa.setBounds(20, 410, 160, 25);

        txtDiagnosa.setColumns(20);
        txtDiagnosa.setLineWrap(true);
        txtDiagnosa.setRows(5);
        txtDiagnosa.setWrapStyleWord(true);
        jScrollDiagnosa.setViewportView(txtDiagnosa);

        getContentPane().add(jScrollDiagnosa);
        jScrollDiagnosa.setBounds(190, 410, 620, 80);

        btnSave.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave);
        btnSave.setBounds(490, 500, 100, 30);

        btnClear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear);
        btnClear.setBounds(600, 500, 100, 30);

        btnExit.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(710, 500, 100, 30);
        getContentPane().add(sep3);
        sep3.setBounds(10, 545, 810, 2);

        lblCariRiwayat.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblCariRiwayat.setForeground(new java.awt.Color(0, 0, 128));
        lblCariRiwayat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCariRiwayat.setText("Cari Data Riwayat Pasien");
        getContentPane().add(lblCariRiwayat);
        lblCariRiwayat.setBounds(20, 560, 200, 25);

        txtCariRiwayat.setToolTipText("Cari berdasarkan No. Pendaftaran / ID Pasien / Nama Pasien");
        getContentPane().add(txtCariRiwayat);
        txtCariRiwayat.setBounds(230, 560, 500, 25);

        btnCariRiwayat.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCariRiwayat.setText("Cari");
        btnCariRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariRiwayatActionPerformed(evt);
            }
        });
        getContentPane().add(btnCariRiwayat);
        btnCariRiwayat.setBounds(740, 560, 70, 25);

        tabelRiwayat.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabelRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Pendaftaran", "Tanggal", "Dokter", "Diagnosa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelRiwayat.setRowHeight(22);
        tabelRiwayat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelRiwayatMouseClicked(evt);
            }
        });
        jScrollTabel.setViewportView(tabelRiwayat);

        getContentPane().add(jScrollTabel);
        jScrollTabel.setBounds(20, 595, 790, 105);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariDokterActionPerformed
        if (!cekKoneksi()) return;
        DialogCariDokter dlg = new DialogCariDokter(this, true);
        dlg.setVisible(true);
        if (dlg.getSelectedId() != null) {
            txtIdDokter.setText(dlg.getSelectedId());
            txtNamaDokter.setText(dlg.getSelectedNama());
        }
    }//GEN-LAST:event_btnCariDokterActionPerformed

    private void btnCariPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPasienActionPerformed
        if (!cekKoneksi()) return;
        DialogCariPasien dlg = new DialogCariPasien(this, true);
        dlg.setVisible(true);
        if (dlg.getSelectedId() != null) {
            txtIdPasien.setText(dlg.getSelectedId());
            txtNamaPasien.setText(dlg.getSelectedNama());
            String gol = dlg.getSelectedGolDarah();
            txtGolDarah.setText(gol == null ? "" : gol);
        }
    }//GEN-LAST:event_btnCariPasienActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String noDaftar = txtNoDaftar.getText().trim();
        String tglStr   = txtTglPeriksa.getText().trim();
        String idDok    = txtIdDokter.getText().trim();
        String idPas    = txtIdPasien.getText().trim();
        String tbStr    = txtTinggi.getText().trim();
        String bbStr    = txtBerat.getText().trim();
        String diagnosa = txtDiagnosa.getText().trim();

        if (noDaftar.isEmpty() || tglStr.isEmpty() || idDok.isEmpty() || idPas.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No. Pendaftaran, Tanggal, ID Dokter, dan ID Pasien wajib diisi.",
                    "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtNamaDokter.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Klik 'Cari' pada ID Dokter dulu untuk memastikan dokter valid.",
                    "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtNamaPasien.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Klik 'Cari' pada No. Identitas Pasien dulu untuk memastikan pasien valid.",
                    "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            sdf.setLenient(false);
            sdf.parse(tglStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Format Tanggal Pemeriksaan tidak valid. Gunakan yyyy-MM-dd.",
                    "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Integer tb = null, bb = null;
        try {
            if (!tbStr.isEmpty()) tb = Integer.parseInt(tbStr);
            if (!bbStr.isEmpty()) bb = Integer.parseInt(bbStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Tinggi Badan dan Berat Badan harus berupa angka.",
                    "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!cekKoneksi()) return;

        String sql = "INSERT INTO rekam (no_daftar, tgl, id_dok, id_pas, tb, bb, diagnosa) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = Koneksi.getConnection().prepareStatement(sql)) {
            ps.setString(1, noDaftar);
            ps.setString(2, tglStr);
            ps.setString(3, idDok);
            ps.setString(4, idPas);
            if (tb == null) ps.setNull(5, java.sql.Types.INTEGER); else ps.setInt(5, tb);
            if (bb == null) ps.setNull(6, java.sql.Types.INTEGER); else ps.setInt(6, bb);
            ps.setString(7, diagnosa);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data rekam medis berhasil disimpan.",
                    "Sukses", JOptionPane.INFORMATION_MESSAGE);
            loadRiwayat("");
            clearForm();
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            if (msg != null && msg.toLowerCase().contains("duplicate")) {
                JOptionPane.showMessageDialog(this,
                        "No. Pendaftaran '" + noDaftar + "' sudah dipakai.",
                        "Duplikat", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan: " + msg,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int pilih = JOptionPane.showConfirmDialog(this,
                "Yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (pilih == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCariRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariRiwayatActionPerformed
        loadRiwayat(txtCariRiwayat.getText().trim());
    }//GEN-LAST:event_btnCariRiwayatActionPerformed

    private void tabelRiwayatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelRiwayatMouseClicked
        int row = tabelRiwayat.getSelectedRow();
        if (row < 0) return;
        String noDaftar = String.valueOf(tabelRiwayat.getValueAt(row, 0));
        if (!cekKoneksi()) return;

        String sql =
            "SELECT r.no_daftar, r.tgl, r.id_dok, d.nama AS nama_dokter, " +
            "       r.id_pas, p.nama AS nama_pasien, p.gol_darah, " +
            "       r.tb, r.bb, r.diagnosa " +
            "FROM rekam r " +
            "JOIN dokter d ON r.id_dok = d.id_dok " +
            "JOIN pasien p ON r.id_pas = p.id_pas " +
            "WHERE r.no_daftar = ?";
        try (PreparedStatement ps = Koneksi.getConnection().prepareStatement(sql)) {
            ps.setString(1, noDaftar);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    txtNoDaftar.setText(rs.getString("no_daftar"));
                    txtTglPeriksa.setText(rs.getString("tgl"));
                    txtIdDokter.setText(rs.getString("id_dok"));
                    txtNamaDokter.setText(rs.getString("nama_dokter"));
                    txtIdPasien.setText(rs.getString("id_pas"));
                    txtNamaPasien.setText(rs.getString("nama_pasien"));
                    String gol = rs.getString("gol_darah");
                    txtGolDarah.setText(gol == null ? "" : gol);
                    int tb = rs.getInt("tb");
                    txtTinggi.setText(rs.wasNull() ? "" : String.valueOf(tb));
                    int bb = rs.getInt("bb");
                    txtBerat.setText(rs.wasNull() ? "" : String.valueOf(bb));
                    txtDiagnosa.setText(rs.getString("diagnosa"));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tabelRiwayatMouseClicked

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // pakai L&F default
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRekamMedis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariDokter;
    private javax.swing.JButton btnCariPasien;
    private javax.swing.JButton btnCariRiwayat;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollDiagnosa;
    private javax.swing.JScrollPane jScrollTabel;
    private javax.swing.JLabel lblBerat;
    private javax.swing.JLabel lblCariRiwayat;
    private javax.swing.JLabel lblDiagnosa;
    private javax.swing.JLabel lblGolDarah;
    private javax.swing.JLabel lblIdDokter;
    private javax.swing.JLabel lblIdPasien;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblNamaDokter;
    private javax.swing.JLabel lblNamaPasien;
    private javax.swing.JLabel lblNoDaftar;
    private javax.swing.JLabel lblTglPeriksa;
    private javax.swing.JLabel lblTinggi;
    private javax.swing.JSeparator sep1;
    private javax.swing.JSeparator sep2;
    private javax.swing.JSeparator sep3;
    private javax.swing.JTable tabelRiwayat;
    private javax.swing.JTextField txtBerat;
    private javax.swing.JTextField txtCariRiwayat;
    private javax.swing.JTextArea txtDiagnosa;
    private javax.swing.JTextField txtGolDarah;
    private javax.swing.JTextField txtIdDokter;
    private javax.swing.JTextField txtIdPasien;
    private javax.swing.JTextField txtNamaDokter;
    private javax.swing.JTextField txtNamaPasien;
    private javax.swing.JTextField txtNoDaftar;
    private javax.swing.JTextField txtTglPeriksa;
    private javax.swing.JTextField txtTinggi;
    // End of variables declaration//GEN-END:variables
}
