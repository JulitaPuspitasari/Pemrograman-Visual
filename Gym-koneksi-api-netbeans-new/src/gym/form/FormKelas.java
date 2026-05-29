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

public class FormKelas extends javax.swing.JInternalFrame {

    private DefaultTableModel model;

    public FormKelas() {
        initComponents();
        panelHeader.setColorStart(new Color(46, 204, 113));
        setupTabel();
        tampilData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new gym.komponen.PanelGradient();
        lblHeader = new javax.swing.JLabel();
        panelInput = new javax.swing.JPanel();
        lblIdKelas = new javax.swing.JLabel();
        txtIdKelas = new javax.swing.JTextField();
        lblNamaKelas = new javax.swing.JLabel();
        txtNamaKelas = new javax.swing.JTextField();
        lblDeskripsi = new javax.swing.JLabel();
        txtDeskripsi = new javax.swing.JTextField();
        lblKapasitas = new javax.swing.JLabel();
        txtKapasitas = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tabelKelas = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Data Kelas");
        getContentPane().setLayout(null);

        panelHeader.setLayout(null);

        lblHeader.setFont(new java.awt.Font("Segoe UI", 1, 16));
        lblHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblHeader.setText("Kelola Data Kelas");
        panelHeader.add(lblHeader);
        lblHeader.setBounds(15, 8, 400, 25);

        getContentPane().add(panelHeader);
        panelHeader.setBounds(0, 0, 850, 40);

        panelInput.setBackground(new java.awt.Color(255, 255, 255));
        panelInput.setLayout(null);

        lblIdKelas.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblIdKelas.setForeground(new java.awt.Color(44, 62, 80));
        lblIdKelas.setText("ID Kelas");
        panelInput.add(lblIdKelas);
        lblIdKelas.setBounds(20, 25, 110, 25);

        txtIdKelas.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtIdKelas);
        txtIdKelas.setBounds(140, 22, 180, 30);

        lblNamaKelas.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblNamaKelas.setForeground(new java.awt.Color(44, 62, 80));
        lblNamaKelas.setText("Nama Kelas");
        panelInput.add(lblNamaKelas);
        lblNamaKelas.setBounds(20, 60, 110, 25);

        txtNamaKelas.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtNamaKelas);
        txtNamaKelas.setBounds(140, 57, 250, 30);

        lblDeskripsi.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblDeskripsi.setForeground(new java.awt.Color(44, 62, 80));
        lblDeskripsi.setText("Deskripsi");
        panelInput.add(lblDeskripsi);
        lblDeskripsi.setBounds(20, 95, 110, 25);

        txtDeskripsi.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtDeskripsi);
        txtDeskripsi.setBounds(140, 92, 300, 30);

        lblKapasitas.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblKapasitas.setForeground(new java.awt.Color(44, 62, 80));
        lblKapasitas.setText("Kapasitas");
        panelInput.add(lblKapasitas);
        lblKapasitas.setBounds(20, 130, 110, 25);

        txtKapasitas.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtKapasitas);
        txtKapasitas.setBounds(140, 127, 100, 30);

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
        btnSimpan.setBounds(500, 25, 110, 33);

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
        btnEdit.setBounds(615, 25, 110, 33);

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
        btnHapus.setBounds(500, 63, 110, 33);

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
        btnReset.setBounds(615, 63, 110, 33);

        getContentPane().add(panelInput);
        panelInput.setBounds(0, 40, 850, 180);

        tabelKelas.setFont(new java.awt.Font("Segoe UI", 0, 12));
        tabelKelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID Kelas", "Nama Kelas", "Deskripsi", "Kapasitas"}
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }
        });
        scrollPane.setViewportView(tabelKelas);

        getContentPane().add(scrollPane);
        scrollPane.setBounds(10, 225, 830, 210);

        setSize(new java.awt.Dimension(850, 480));
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
        model = (DefaultTableModel) tabelKelas.getModel();
        styleTable(tabelKelas);
        tabelKelas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int r = tabelKelas.getSelectedRow();
                if (r < 0) return;
                txtIdKelas.setText(model.getValueAt(r, 0).toString());
                txtNamaKelas.setText(model.getValueAt(r, 1).toString());
                txtDeskripsi.setText(model.getValueAt(r, 2).toString());
                txtKapasitas.setText(model.getValueAt(r, 3).toString());
            }
        });
        gym.komponen.SwingUtil.makeOpaque(btnSimpan, btnEdit, btnHapus, btnReset);
        gym.komponen.SwingUtil.styleTableHeader(tabelKelas);
    }

    private void styleTable(JTable t) {
        t.setRowHeight(28);
        t.setGridColor(new Color(240, 240, 240));
        t.setSelectionBackground(new Color(46, 204, 113, 40));
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
            ApiClient.ApiResponse res = ApiClient.get("/kelas");
            if (!res.ok()) { JOptionPane.showMessageDialog(this, "Gagal memuat: " + ApiClient.errorMessage(res.body)); return; }
            List<Map<String, String>> rows = ApiClient.parseDataArray(res.body);
            for (Map<String, String> r : rows) {
                model.addRow(new Object[]{r.get("id_kelas"), r.get("nama_kelas"),
                    r.get("deskripsi"), r.get("kapasitas")});
            }
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private Map<String, Object> formToMap() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id_kelas", txtIdKelas.getText().trim());
        m.put("nama_kelas", txtNamaKelas.getText().trim());
        m.put("deskripsi", txtDeskripsi.getText().trim());
        m.put("kapasitas", Integer.parseInt(txtKapasitas.getText().trim()));
        return m;
    }

    private void simpan() {
        if (txtIdKelas.getText().trim().isEmpty() || txtNamaKelas.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID dan Nama Kelas harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        try {
            ApiClient.ApiResponse res = ApiClient.post("/kelas", ApiClient.buildJson(formToMap()));
            if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil disimpan!"); reset(); tampilData(); }
            else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private void edit() {
        if (txtIdKelas.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        try {
            String id = ApiClient.encodePath(txtIdKelas.getText().trim());
            ApiClient.ApiResponse res = ApiClient.put("/kelas/" + id, ApiClient.buildJson(formToMap()));
            if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil diupdate!"); reset(); tampilData(); }
            else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private void hapus() {
        if (txtIdKelas.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        int c = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (c == JOptionPane.YES_OPTION) {
            try {
                String id = ApiClient.encodePath(txtIdKelas.getText().trim());
                ApiClient.ApiResponse res = ApiClient.delete("/kelas/" + id);
                if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil dihapus!"); reset(); tampilData(); }
                else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
            } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
        }
    }

    private void reset() {
        txtIdKelas.setText(""); txtNamaKelas.setText(""); txtDeskripsi.setText("");
        txtKapasitas.setText(""); txtIdKelas.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel lblDeskripsi;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblIdKelas;
    private javax.swing.JLabel lblKapasitas;
    private javax.swing.JLabel lblNamaKelas;
    private gym.komponen.PanelGradient panelHeader;
    private javax.swing.JPanel panelInput;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabelKelas;
    private javax.swing.JTextField txtDeskripsi;
    private javax.swing.JTextField txtIdKelas;
    private javax.swing.JTextField txtKapasitas;
    private javax.swing.JTextField txtNamaKelas;
    // End of variables declaration//GEN-END:variables
}
