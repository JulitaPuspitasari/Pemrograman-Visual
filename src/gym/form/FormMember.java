package gym.form;

import gym.koneksi.ApiClient;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class FormMember extends javax.swing.JInternalFrame {

    private DefaultTableModel model;

    public FormMember() {
        initComponents();
        setupTabel();
        tampilData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new gym.komponen.PanelGradient();
        lblHeader = new javax.swing.JLabel();
        panelInput = new javax.swing.JPanel();
        lblIdMember = new javax.swing.JLabel();
        txtIdMember = new javax.swing.JTextField();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblJk = new javax.swing.JLabel();
        cmbJenisKelamin = new javax.swing.JComboBox<>();
        lblTempatLahir = new javax.swing.JLabel();
        txtTempatLahir = new javax.swing.JTextField();
        lblTglLahir = new javax.swing.JLabel();
        txtTglLahir = new javax.swing.JTextField();
        lblFmt1 = new javax.swing.JLabel();
        lblAlamat = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        lblNoHp = new javax.swing.JLabel();
        txtNoHp = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblTglDaftar = new javax.swing.JLabel();
        txtTglDaftar = new javax.swing.JTextField();
        lblFmt2 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tabelMember = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Data Member");
        getContentPane().setLayout(null);

        panelHeader.setLayout(null);

        lblHeader.setFont(new java.awt.Font("Segoe UI", 1, 16));
        lblHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblHeader.setText("Kelola Data Member");
        panelHeader.add(lblHeader);
        lblHeader.setBounds(15, 8, 400, 25);

        getContentPane().add(panelHeader);
        panelHeader.setBounds(0, 0, 1000, 40);

        panelInput.setBackground(new java.awt.Color(255, 255, 255));
        panelInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(230, 230, 230)));
        panelInput.setLayout(null);

        lblIdMember.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblIdMember.setForeground(new java.awt.Color(44, 62, 80));
        lblIdMember.setText("ID Member");
        panelInput.add(lblIdMember);
        lblIdMember.setBounds(20, 25, 120, 25);

        txtIdMember.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtIdMember);
        txtIdMember.setBounds(140, 22, 180, 30);

        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblNama.setForeground(new java.awt.Color(44, 62, 80));
        lblNama.setText("Nama");
        panelInput.add(lblNama);
        lblNama.setBounds(20, 60, 120, 25);

        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtNama);
        txtNama.setBounds(140, 57, 300, 30);

        lblJk.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblJk.setForeground(new java.awt.Color(44, 62, 80));
        lblJk.setText("Jenis Kelamin");
        panelInput.add(lblJk);
        lblJk.setBounds(20, 95, 120, 25);

        cmbJenisKelamin.setFont(new java.awt.Font("Segoe UI", 0, 13));
        cmbJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));
        panelInput.add(cmbJenisKelamin);
        cmbJenisKelamin.setBounds(140, 92, 150, 30);

        lblTempatLahir.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblTempatLahir.setForeground(new java.awt.Color(44, 62, 80));
        lblTempatLahir.setText("Tempat Lahir");
        panelInput.add(lblTempatLahir);
        lblTempatLahir.setBounds(20, 130, 120, 25);

        txtTempatLahir.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtTempatLahir);
        txtTempatLahir.setBounds(140, 127, 200, 30);

        lblTglLahir.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblTglLahir.setForeground(new java.awt.Color(44, 62, 80));
        lblTglLahir.setText("Tanggal Lahir");
        panelInput.add(lblTglLahir);
        lblTglLahir.setBounds(20, 165, 120, 25);

        txtTglLahir.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtTglLahir);
        txtTglLahir.setBounds(140, 162, 150, 30);

        lblFmt1.setFont(new java.awt.Font("Segoe UI", 2, 11));
        lblFmt1.setForeground(new java.awt.Color(149, 165, 166));
        lblFmt1.setText("(yyyy-MM-dd)");
        panelInput.add(lblFmt1);
        lblFmt1.setBounds(295, 165, 100, 25);

        lblAlamat.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblAlamat.setForeground(new java.awt.Color(44, 62, 80));
        lblAlamat.setText("Alamat");
        panelInput.add(lblAlamat);
        lblAlamat.setBounds(20, 200, 120, 25);

        txtAlamat.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtAlamat);
        txtAlamat.setBounds(140, 197, 300, 30);

        lblNoHp.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblNoHp.setForeground(new java.awt.Color(44, 62, 80));
        lblNoHp.setText("No HP");
        panelInput.add(lblNoHp);
        lblNoHp.setBounds(500, 25, 120, 25);

        txtNoHp.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtNoHp);
        txtNoHp.setBounds(620, 22, 200, 30);

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblEmail.setForeground(new java.awt.Color(44, 62, 80));
        lblEmail.setText("Email");
        panelInput.add(lblEmail);
        lblEmail.setBounds(500, 60, 120, 25);

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtEmail);
        txtEmail.setBounds(620, 57, 250, 30);

        lblTglDaftar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblTglDaftar.setForeground(new java.awt.Color(44, 62, 80));
        lblTglDaftar.setText("Tgl Daftar");
        panelInput.add(lblTglDaftar);
        lblTglDaftar.setBounds(500, 95, 120, 25);

        txtTglDaftar.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtTglDaftar);
        txtTglDaftar.setBounds(620, 92, 150, 30);

        lblFmt2.setFont(new java.awt.Font("Segoe UI", 2, 11));
        lblFmt2.setForeground(new java.awt.Color(149, 165, 166));
        lblFmt2.setText("(yyyy-MM-dd)");
        panelInput.add(lblFmt2);
        lblFmt2.setBounds(775, 95, 100, 25);

        btnSimpan.setBackground(new java.awt.Color(46, 204, 113));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.setBorderPainted(false);
        btnSimpan.setFocusPainted(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        panelInput.add(btnSimpan);
        btnSimpan.setBounds(500, 140, 110, 33);

        btnEdit.setBackground(new java.awt.Color(41, 128, 185));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.setBorderPainted(false);
        btnEdit.setFocusPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        panelInput.add(btnEdit);
        btnEdit.setBounds(615, 140, 110, 33);

        btnHapus.setBackground(new java.awt.Color(192, 57, 43));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.setBorderPainted(false);
        btnHapus.setFocusPainted(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        panelInput.add(btnHapus);
        btnHapus.setBounds(500, 178, 110, 33);

        btnReset.setBackground(new java.awt.Color(243, 156, 18));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.setBorderPainted(false);
        btnReset.setFocusPainted(false);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        panelInput.add(btnReset);
        btnReset.setBounds(615, 178, 110, 33);

        getContentPane().add(panelInput);
        panelInput.setBounds(0, 40, 1000, 240);

        tabelMember.setFont(new java.awt.Font("Segoe UI", 0, 12));
        tabelMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID Member", "Nama", "JK", "Tempat Lahir", "Tgl Lahir", "Alamat", "No HP", "Email", "Tgl Daftar"}
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }
        });
        scrollPane.setViewportView(tabelMember);

        getContentPane().add(scrollPane);
        scrollPane.setBounds(10, 285, 980, 290);

        setSize(new java.awt.Dimension(1000, 620));
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

    private void setupTabel() {
        model = (DefaultTableModel) tabelMember.getModel();
        styleTable(tabelMember);
        tabelMember.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tabelMember.getSelectedRow();
                if (row < 0) return;
                txtIdMember.setText(model.getValueAt(row, 0).toString());
                txtNama.setText(model.getValueAt(row, 1).toString());
                cmbJenisKelamin.setSelectedItem(model.getValueAt(row, 2).toString());
                txtTempatLahir.setText(model.getValueAt(row, 3).toString());
                txtTglLahir.setText(model.getValueAt(row, 4).toString());
                txtAlamat.setText(model.getValueAt(row, 5).toString());
                txtNoHp.setText(model.getValueAt(row, 6).toString());
                txtEmail.setText(model.getValueAt(row, 7).toString());
                txtTglDaftar.setText(model.getValueAt(row, 8).toString());
            }
        });
        gym.komponen.SwingUtil.makeOpaque(btnSimpan, btnEdit, btnHapus, btnReset);
        gym.komponen.SwingUtil.styleTableHeader(tabelMember);
    }

    private void styleTable(JTable table) {
        table.setRowHeight(28);
        table.setGridColor(new Color(240, 240, 240));
        table.setSelectionBackground(new Color(231, 76, 60, 40));
        table.setSelectionForeground(new Color(44, 62, 80));
        table.setShowVerticalLines(false);
        table.setIntercellSpacing(new Dimension(0, 1));
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        header.setBackground(new Color(44, 62, 80));
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(0, 35));
        header.setBorder(BorderFactory.createEmptyBorder());
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable t, Object val, boolean sel, boolean foc, int row, int col) {
                Component c = super.getTableCellRendererComponent(t, val, sel, foc, row, col);
                if (!sel) c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(248, 249, 250));
                setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
                return c;
            }
        });
    }

    private void tampilData() {
        model.setRowCount(0);
        try {
            ApiClient.ApiResponse res = ApiClient.get("/member");
            if (!res.ok()) {
                JOptionPane.showMessageDialog(this, "Gagal memuat data: " + ApiClient.errorMessage(res.body));
                return;
            }
            List<Map<String, String>> rows = ApiClient.parseDataArray(res.body);
            for (Map<String, String> r : rows) {
                model.addRow(new Object[]{
                    r.get("id_member"), r.get("nama"), r.get("jenis_kelamin"),
                    r.get("tempat_lahir"), r.get("tanggal_lahir"), r.get("alamat"),
                    r.get("no_hp"), r.get("email"), r.get("tanggal_daftar")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private Map<String, Object> formToMap() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id_member", txtIdMember.getText().trim());
        m.put("nama", txtNama.getText().trim());
        m.put("jenis_kelamin", cmbJenisKelamin.getSelectedItem().toString());
        m.put("tempat_lahir", txtTempatLahir.getText().trim());
        m.put("tanggal_lahir", txtTglLahir.getText().trim());
        m.put("alamat", txtAlamat.getText().trim());
        m.put("no_hp", txtNoHp.getText().trim());
        m.put("email", txtEmail.getText().trim());
        m.put("tanggal_daftar", txtTglDaftar.getText().trim());
        return m;
    }

    private void simpan() {
        if (txtIdMember.getText().trim().isEmpty() || txtNama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Member dan Nama harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            ApiClient.ApiResponse res = ApiClient.post("/member", ApiClient.buildJson(formToMap()));
            if (res.ok()) {
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
                reset(); tampilData();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan: " + ApiClient.errorMessage(res.body));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void edit() {
        if (txtIdMember.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            String id = ApiClient.encodePath(txtIdMember.getText().trim());
            ApiClient.ApiResponse res = ApiClient.put("/member/" + id, ApiClient.buildJson(formToMap()));
            if (res.ok()) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
                reset(); tampilData();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal update: " + ApiClient.errorMessage(res.body));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void hapus() {
        if (txtIdMember.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String id = ApiClient.encodePath(txtIdMember.getText().trim());
                ApiClient.ApiResponse res = ApiClient.delete("/member/" + id);
                if (res.ok()) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                    reset(); tampilData();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal hapus: " + ApiClient.errorMessage(res.body));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    private void reset() {
        txtIdMember.setText(""); txtNama.setText(""); txtTempatLahir.setText("");
        txtTglLahir.setText(""); txtAlamat.setText(""); txtNoHp.setText("");
        txtEmail.setText(""); txtTglDaftar.setText("");
        cmbJenisKelamin.setSelectedIndex(0);
        txtIdMember.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbJenisKelamin;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFmt1;
    private javax.swing.JLabel lblFmt2;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblIdMember;
    private javax.swing.JLabel lblJk;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNoHp;
    private javax.swing.JLabel lblTempatLahir;
    private javax.swing.JLabel lblTglDaftar;
    private javax.swing.JLabel lblTglLahir;
    private gym.komponen.PanelGradient panelHeader;
    private javax.swing.JPanel panelInput;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabelMember;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdMember;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoHp;
    private javax.swing.JTextField txtTempatLahir;
    private javax.swing.JTextField txtTglDaftar;
    private javax.swing.JTextField txtTglLahir;
    // End of variables declaration//GEN-END:variables
}
