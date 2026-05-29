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

public class FormPersonalTrainer extends javax.swing.JInternalFrame {

    private DefaultTableModel model;

    public FormPersonalTrainer() {
        initComponents();
        panelHeader.setColorStart(new Color(243, 156, 18));
        setupTabel();
        tampilData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new gym.komponen.PanelGradient();
        lblHeader = new javax.swing.JLabel();
        panelInput = new javax.swing.JPanel();
        lblIdTrainer = new javax.swing.JLabel();
        txtIdTrainer = new javax.swing.JTextField();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblSpesialisasi = new javax.swing.JLabel();
        txtSpesialisasi = new javax.swing.JTextField();
        lblNoHp = new javax.swing.JLabel();
        txtNoHp = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tabelTrainer = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Data Personal Trainer");
        getContentPane().setLayout(null);

        panelHeader.setLayout(null);

        lblHeader.setFont(new java.awt.Font("Segoe UI", 1, 16));
        lblHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblHeader.setText("Kelola Data Personal Trainer");
        panelHeader.add(lblHeader);
        lblHeader.setBounds(15, 8, 400, 25);

        getContentPane().add(panelHeader);
        panelHeader.setBounds(0, 0, 900, 40);

        panelInput.setBackground(new java.awt.Color(255, 255, 255));
        panelInput.setLayout(null);

        lblIdTrainer.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblIdTrainer.setForeground(new java.awt.Color(44, 62, 80));
        lblIdTrainer.setText("ID Trainer");
        panelInput.add(lblIdTrainer);
        lblIdTrainer.setBounds(20, 25, 110, 25);

        txtIdTrainer.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtIdTrainer);
        txtIdTrainer.setBounds(140, 22, 180, 30);

        lblNama.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblNama.setForeground(new java.awt.Color(44, 62, 80));
        lblNama.setText("Nama");
        panelInput.add(lblNama);
        lblNama.setBounds(20, 60, 110, 25);

        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtNama);
        txtNama.setBounds(140, 57, 300, 30);

        lblSpesialisasi.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblSpesialisasi.setForeground(new java.awt.Color(44, 62, 80));
        lblSpesialisasi.setText("Spesialisasi");
        panelInput.add(lblSpesialisasi);
        lblSpesialisasi.setBounds(20, 95, 110, 25);

        txtSpesialisasi.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtSpesialisasi);
        txtSpesialisasi.setBounds(140, 92, 250, 30);

        lblNoHp.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblNoHp.setForeground(new java.awt.Color(44, 62, 80));
        lblNoHp.setText("No HP");
        panelInput.add(lblNoHp);
        lblNoHp.setBounds(20, 130, 110, 25);

        txtNoHp.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtNoHp);
        txtNoHp.setBounds(140, 127, 200, 30);

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblEmail.setForeground(new java.awt.Color(44, 62, 80));
        lblEmail.setText("Email");
        panelInput.add(lblEmail);
        lblEmail.setBounds(20, 165, 110, 25);

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtEmail);
        txtEmail.setBounds(140, 162, 250, 30);

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblStatus.setForeground(new java.awt.Color(44, 62, 80));
        lblStatus.setText("Status");
        panelInput.add(lblStatus);
        lblStatus.setBounds(500, 25, 110, 25);

        cmbStatus.setFont(new java.awt.Font("Segoe UI", 0, 13));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Tidak Aktif" }));
        panelInput.add(cmbStatus);
        cmbStatus.setBounds(590, 22, 150, 30);

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
        btnSimpan.setBounds(500, 65, 110, 33);

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
        btnEdit.setBounds(615, 65, 110, 33);

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
        btnHapus.setBounds(500, 103, 110, 33);

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
        btnReset.setBounds(615, 103, 110, 33);

        getContentPane().add(panelInput);
        panelInput.setBounds(0, 40, 900, 210);

        tabelTrainer.setFont(new java.awt.Font("Segoe UI", 0, 12));
        tabelTrainer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID Trainer", "Nama", "Spesialisasi", "No HP", "Email", "Status"}
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }
        });
        scrollPane.setViewportView(tabelTrainer);

        getContentPane().add(scrollPane);
        scrollPane.setBounds(10, 255, 880, 245);

        setSize(new java.awt.Dimension(900, 540));
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
        model = (DefaultTableModel) tabelTrainer.getModel();
        styleTable(tabelTrainer);
        tabelTrainer.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int r = tabelTrainer.getSelectedRow();
                if (r < 0) return;
                txtIdTrainer.setText(model.getValueAt(r, 0).toString());
                txtNama.setText(model.getValueAt(r, 1).toString());
                txtSpesialisasi.setText(model.getValueAt(r, 2).toString());
                txtNoHp.setText(model.getValueAt(r, 3).toString());
                txtEmail.setText(model.getValueAt(r, 4).toString());
                cmbStatus.setSelectedItem(model.getValueAt(r, 5).toString());
            }
        });
        gym.komponen.SwingUtil.makeOpaque(btnSimpan, btnEdit, btnHapus, btnReset);
        gym.komponen.SwingUtil.styleTableHeader(tabelTrainer);
    }

    private void styleTable(JTable t) {
        t.setRowHeight(28);
        t.setGridColor(new Color(240, 240, 240));
        t.setSelectionBackground(new Color(243, 156, 18, 40));
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
            ApiClient.ApiResponse res = ApiClient.get("/trainer");
            if (!res.ok()) {
                JOptionPane.showMessageDialog(this, "Gagal memuat: " + ApiClient.errorMessage(res.body));
                return;
            }
            List<Map<String, String>> rows = ApiClient.parseDataArray(res.body);
            for (Map<String, String> r : rows) {
                model.addRow(new Object[]{r.get("id_trainer"), r.get("nama"),
                    r.get("spesialisasi"), r.get("no_hp"), r.get("email"), r.get("status")});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private Map<String, Object> formToMap() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id_trainer", txtIdTrainer.getText().trim());
        m.put("nama", txtNama.getText().trim());
        m.put("spesialisasi", txtSpesialisasi.getText().trim());
        m.put("no_hp", txtNoHp.getText().trim());
        m.put("email", txtEmail.getText().trim());
        m.put("status", cmbStatus.getSelectedItem().toString());
        return m;
    }

    private void simpan() {
        if (txtIdTrainer.getText().trim().isEmpty() || txtNama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID dan Nama harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            ApiClient.ApiResponse res = ApiClient.post("/trainer", ApiClient.buildJson(formToMap()));
            if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil disimpan!"); reset(); tampilData(); }
            else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private void edit() {
        if (txtIdTrainer.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            String id = ApiClient.encodePath(txtIdTrainer.getText().trim());
            ApiClient.ApiResponse res = ApiClient.put("/trainer/" + id, ApiClient.buildJson(formToMap()));
            if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil diupdate!"); reset(); tampilData(); }
            else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private void hapus() {
        if (txtIdTrainer.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int c = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (c == JOptionPane.YES_OPTION) {
            try {
                String id = ApiClient.encodePath(txtIdTrainer.getText().trim());
                ApiClient.ApiResponse res = ApiClient.delete("/trainer/" + id);
                if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil dihapus!"); reset(); tampilData(); }
                else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
            } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
        }
    }

    private void reset() {
        txtIdTrainer.setText(""); txtNama.setText(""); txtSpesialisasi.setText("");
        txtNoHp.setText(""); txtEmail.setText(""); cmbStatus.setSelectedIndex(0);
        txtIdTrainer.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblIdTrainer;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNoHp;
    private javax.swing.JLabel lblSpesialisasi;
    private javax.swing.JLabel lblStatus;
    private gym.komponen.PanelGradient panelHeader;
    private javax.swing.JPanel panelInput;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabelTrainer;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdTrainer;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoHp;
    private javax.swing.JTextField txtSpesialisasi;
    // End of variables declaration//GEN-END:variables
}
