package data.pasien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class FormDataPasien extends javax.swing.JFrame {

    private Connection conn;
    private DefaultTableModel model;

    public FormDataPasien() {
        initComponents();
        setSize(820, 620);
        setLocationRelativeTo(null);
        model = (DefaultTableModel) tabelPasien.getModel();
        try {
            conn = Koneksi.getConnection();
            if (conn != null) {
                tampilData();
            } else {
                JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgJenisKelamin = new javax.swing.ButtonGroup();
        lblJudul = new javax.swing.JLabel();
        lblNoIdentitas = new javax.swing.JLabel();
        lblNamaPasien = new javax.swing.JLabel();
        lblJenisKelamin = new javax.swing.JLabel();
        lblAlamat = new javax.swing.JLabel();
        lblGolDarah = new javax.swing.JLabel();
        txtNoIdentitas = new javax.swing.JTextField();
        txtNamaPasien = new javax.swing.JTextField();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        cmbGolDarah = new javax.swing.JComboBox();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPasien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Pasien");
        setResizable(false);
        getContentPane().setLayout(null);

        lblJudul.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(0, 0, 128));
        lblJudul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJudul.setText("~ DATA PASIEN ~");
        lblJudul.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblJudul);
        lblJudul.setBounds(30, 10, 350, 40);

        lblNoIdentitas.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblNoIdentitas.setForeground(new java.awt.Color(0, 0, 128));
        lblNoIdentitas.setText("No. Identitas");
        getContentPane().add(lblNoIdentitas);
        lblNoIdentitas.setBounds(30, 70, 120, 25);

        lblNamaPasien.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblNamaPasien.setForeground(new java.awt.Color(0, 0, 128));
        lblNamaPasien.setText("Nama Pasien");
        getContentPane().add(lblNamaPasien);
        lblNamaPasien.setBounds(30, 105, 120, 25);

        lblJenisKelamin.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblJenisKelamin.setForeground(new java.awt.Color(0, 0, 128));
        lblJenisKelamin.setText("Jenis Kelamin");
        getContentPane().add(lblJenisKelamin);
        lblJenisKelamin.setBounds(30, 140, 120, 25);

        lblAlamat.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblAlamat.setForeground(new java.awt.Color(0, 0, 128));
        lblAlamat.setText("Alamat - No. telp");
        getContentPane().add(lblAlamat);
        lblAlamat.setBounds(30, 175, 140, 25);

        lblGolDarah.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblGolDarah.setForeground(new java.awt.Color(0, 0, 128));
        lblGolDarah.setText("Golongan Darah");
        getContentPane().add(lblGolDarah);
        lblGolDarah.setBounds(30, 245, 140, 25);
        getContentPane().add(txtNoIdentitas);
        txtNoIdentitas.setBounds(180, 70, 300, 25);
        getContentPane().add(txtNamaPasien);
        txtNamaPasien.setBounds(180, 105, 600, 25);

        bgJenisKelamin.add(rbLaki);
        rbLaki.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        rbLaki.setText("Laki-laki");
        getContentPane().add(rbLaki);
        rbLaki.setBounds(180, 140, 100, 25);

        bgJenisKelamin.add(rbPerempuan);
        rbPerempuan.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        rbPerempuan.setText("Perempuan");
        getContentPane().add(rbPerempuan);
        rbPerempuan.setBounds(300, 140, 110, 25);

        txtAlamat.setLineWrap(true);
        txtAlamat.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtAlamat);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(180, 175, 600, 55);

        cmbGolDarah.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "AB", "O" }));
        getContentPane().add(cmbGolDarah);
        cmbGolDarah.setBounds(180, 245, 60, 25);

        btnSave.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave);
        btnSave.setBounds(80, 290, 110, 30);

        btnEdit.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit);
        btnEdit.setBounds(210, 290, 110, 30);

        btnDelete.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(340, 290, 110, 30);

        btnClear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear);
        btnClear.setBounds(470, 290, 110, 30);

        btnExit.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(600, 290, 110, 30);

        lblCari.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblCari.setForeground(new java.awt.Color(0, 0, 128));
        lblCari.setText("Kata kunci pencarian");
        getContentPane().add(lblCari);
        lblCari.setBounds(30, 340, 150, 25);
        getContentPane().add(txtCari);
        txtCari.setBounds(190, 340, 460, 25);

        btnCari.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        getContentPane().add(btnCari);
        btnCari.setBounds(660, 340, 70, 25);

        tabelPasien.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabelPasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Identitas", "Nama Pasien", "Jenis Kelamin", "Alamat", "Golongan Darah"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelPasien.setRowHeight(22);
        tabelPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPasienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelPasien);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 380, 750, 180);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtNoIdentitas.getText().isEmpty() || txtNamaPasien.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No. Identitas dan Nama Pasien harus diisi!");
            return;
        }
        String jk = rbLaki.isSelected() ? "Laki-laki" : rbPerempuan.isSelected() ? "Perempuan" : "";
        if (jk.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih Jenis Kelamin!");
            return;
        }
        try {
            String sql = "INSERT INTO pasien (no_identitas, nama_pasien, jenis_kelamin, alamat, golongan_darah) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtNoIdentitas.getText());
            ps.setString(2, txtNamaPasien.getText());
            ps.setString(3, jk);
            ps.setString(4, txtAlamat.getText());
            ps.setString(5, cmbGolDarah.getSelectedItem().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
            clearForm();
            tampilData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (txtNoIdentitas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diedit dari tabel!");
            return;
        }
        String jk = rbLaki.isSelected() ? "Laki-laki" : rbPerempuan.isSelected() ? "Perempuan" : "";
        try {
            String sql = "UPDATE pasien SET nama_pasien=?, jenis_kelamin=?, alamat=?, golongan_darah=? WHERE no_identitas=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtNamaPasien.getText());
            ps.setString(2, jk);
            ps.setString(3, txtAlamat.getText());
            ps.setString(4, cmbGolDarah.getSelectedItem().toString());
            ps.setString(5, txtNoIdentitas.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
            clearForm();
            tampilData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengupdate data: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtNoIdentitas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus dari tabel!");
            return;
        }
        int konfirmasi = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (konfirmasi == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM pasien WHERE no_identitas=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, txtNoIdentitas.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                clearForm();
                tampilData();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        model.setRowCount(0);
        try {
            String sql = "SELECT * FROM pasien WHERE no_identitas LIKE ? OR nama_pasien LIKE ? OR jenis_kelamin LIKE ? OR alamat LIKE ? OR golongan_darah LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            String keyword = "%" + txtCari.getText() + "%";
            for (int i = 1; i <= 5; i++) {
                ps.setString(i, keyword);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("no_identitas"),
                    rs.getString("nama_pasien"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("alamat"),
                    rs.getString("golongan_darah")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mencari data: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void tabelPasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPasienMouseClicked
        int baris = tabelPasien.getSelectedRow();
        txtNoIdentitas.setText(model.getValueAt(baris, 0).toString());
        txtNamaPasien.setText(model.getValueAt(baris, 1).toString());
        String jk = model.getValueAt(baris, 2).toString();
        if (jk.equals("Laki-laki")) {
            rbLaki.setSelected(true);
        } else {
            rbPerempuan.setSelected(true);
        }
        txtAlamat.setText(model.getValueAt(baris, 3).toString());
        cmbGolDarah.setSelectedItem(model.getValueAt(baris, 4).toString());
        txtNoIdentitas.setEditable(false);
    }//GEN-LAST:event_tabelPasienMouseClicked

    private void tampilData() {
        model = (DefaultTableModel) tabelPasien.getModel();
        model.setRowCount(0);
        try {
            String sql = "SELECT * FROM pasien";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("no_identitas"),
                    rs.getString("nama_pasien"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("alamat"),
                    rs.getString("golongan_darah")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.getMessage());
        }
    }

    private void clearForm() {
        txtNoIdentitas.setText("");
        txtNamaPasien.setText("");
        bgJenisKelamin.clearSelection();
        txtAlamat.setText("");
        cmbGolDarah.setSelectedIndex(0);
        txtNoIdentitas.setEditable(true);
        txtNoIdentitas.requestFocus();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDataPasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgJenisKelamin;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbGolDarah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblGolDarah;
    private javax.swing.JLabel lblJenisKelamin;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblNamaPasien;
    private javax.swing.JLabel lblNoIdentitas;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTable tabelPasien;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNamaPasien;
    private javax.swing.JTextField txtNoIdentitas;
    // End of variables declaration//GEN-END:variables
}
