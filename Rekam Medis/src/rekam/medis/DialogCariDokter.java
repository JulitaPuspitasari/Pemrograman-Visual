package rekam.medis;

import java.awt.Frame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DialogCariDokter extends javax.swing.JDialog {

    private String selectedId;
    private String selectedNama;

    public DialogCariDokter(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(525, 425);
        setLocationRelativeTo(parent);
        loadData("");
    }

    public String getSelectedId()    { return selectedId; }
    public String getSelectedNama()  { return selectedNama; }

    private void loadData(String keyword) {
        DefaultTableModel model = (DefaultTableModel) tabelDokter.getModel();
        model.setRowCount(0);

        if (Koneksi.getConnection() == null) {
            JOptionPane.showMessageDialog(this,
                    "Koneksi ke database gagal.",
                    "Error Koneksi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "SELECT id_dok, nama FROM dokter " +
                     "WHERE id_dok LIKE ? OR nama LIKE ? " +
                     "ORDER BY id_dok";
        try (PreparedStatement ps = Koneksi.getConnection().prepareStatement(sql)) {
            String like = "%" + keyword + "%";
            ps.setString(1, like);
            ps.setString(2, like);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("id_dok"),
                        rs.getString("nama")
                    });
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Gagal memuat data dokter: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void pilihRow() {
        int row = tabelDokter.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this,
                    "Pilih salah satu baris dokter terlebih dahulu.",
                    "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        selectedId   = String.valueOf(tabelDokter.getValueAt(row, 0));
        selectedNama = String.valueOf(tabelDokter.getValueAt(row, 1));
        dispose();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollTabel = new javax.swing.JScrollPane();
        tabelDokter = new javax.swing.JTable();
        btnPilih = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cari Dokter");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(null);

        lblJudul.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(0, 0, 128));
        lblJudul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJudul.setText("~ Daftar Dokter ~");
        lblJudul.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(lblJudul);
        lblJudul.setBounds(15, 10, 490, 40);

        lblCari.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCari.setForeground(new java.awt.Color(0, 0, 128));
        lblCari.setText("Cari (ID / Nama)");
        getContentPane().add(lblCari);
        lblCari.setBounds(15, 65, 130, 25);

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        getContentPane().add(txtCari);
        txtCari.setBounds(150, 65, 270, 25);

        btnCari.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        getContentPane().add(btnCari);
        btnCari.setBounds(430, 65, 75, 25);

        tabelDokter.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabelDokter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Dokter", "Nama Dokter"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelDokter.setRowHeight(22);
        tabelDokter.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelDokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDokterMouseClicked(evt);
            }
        });
        jScrollTabel.setViewportView(tabelDokter);

        getContentPane().add(jScrollTabel);
        jScrollTabel.setBounds(15, 100, 490, 240);

        btnPilih.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnPilih.setText("PILIH");
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });
        getContentPane().add(btnPilih);
        btnPilih.setBounds(305, 350, 95, 30);

        btnBatal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        getContentPane().add(btnBatal);
        btnBatal.setBounds(410, 350, 95, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        loadData(txtCari.getText().trim());
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        loadData(txtCari.getText().trim());
    }//GEN-LAST:event_txtCariActionPerformed

    private void tabelDokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDokterMouseClicked
        if (evt.getClickCount() == 2) {
            pilihRow();
        }
    }//GEN-LAST:event_tabelDokterMouseClicked

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        pilihRow();
    }//GEN-LAST:event_btnPilihActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        selectedId = null;
        selectedNama = null;
        dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnPilih;
    private javax.swing.JScrollPane jScrollTabel;
    private javax.swing.JLabel lblCari;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JTable tabelDokter;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
