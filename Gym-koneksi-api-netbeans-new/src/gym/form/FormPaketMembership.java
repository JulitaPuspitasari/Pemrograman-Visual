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

public class FormPaketMembership extends javax.swing.JInternalFrame {

    private DefaultTableModel model;

    public FormPaketMembership() {
        initComponents();
        panelHeader.setColorStart(new Color(155, 89, 182));
        setupTabel();
        tampilData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new gym.komponen.PanelGradient();
        lblHeader = new javax.swing.JLabel();
        panelInput = new javax.swing.JPanel();
        lblIdPaket = new javax.swing.JLabel();
        txtIdPaket = new javax.swing.JTextField();
        lblNamaPaket = new javax.swing.JLabel();
        txtNamaPaket = new javax.swing.JTextField();
        lblDurasi = new javax.swing.JLabel();
        txtDurasi = new javax.swing.JTextField();
        lblHarga = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        lblFasilitas = new javax.swing.JLabel();
        txtFasilitas = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tabelPaket = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Paket Membership");
        getContentPane().setLayout(null);

        panelHeader.setLayout(null);

        lblHeader.setFont(new java.awt.Font("Segoe UI", 1, 16));
        lblHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblHeader.setText("Kelola Paket Membership");
        panelHeader.add(lblHeader);
        lblHeader.setBounds(15, 8, 400, 25);

        getContentPane().add(panelHeader);
        panelHeader.setBounds(0, 0, 900, 40);

        panelInput.setBackground(new java.awt.Color(255, 255, 255));
        panelInput.setLayout(null);

        lblIdPaket.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblIdPaket.setForeground(new java.awt.Color(44, 62, 80));
        lblIdPaket.setText("ID Paket");
        panelInput.add(lblIdPaket);
        lblIdPaket.setBounds(20, 25, 130, 25);

        txtIdPaket.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtIdPaket);
        txtIdPaket.setBounds(155, 22, 180, 30);

        lblNamaPaket.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblNamaPaket.setForeground(new java.awt.Color(44, 62, 80));
        lblNamaPaket.setText("Nama Paket");
        panelInput.add(lblNamaPaket);
        lblNamaPaket.setBounds(20, 60, 130, 25);

        txtNamaPaket.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtNamaPaket);
        txtNamaPaket.setBounds(155, 57, 250, 30);

        lblDurasi.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblDurasi.setForeground(new java.awt.Color(44, 62, 80));
        lblDurasi.setText("Durasi (Bulan)");
        panelInput.add(lblDurasi);
        lblDurasi.setBounds(20, 95, 130, 25);

        txtDurasi.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtDurasi);
        txtDurasi.setBounds(155, 92, 100, 30);

        lblHarga.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblHarga.setForeground(new java.awt.Color(44, 62, 80));
        lblHarga.setText("Harga (Rp)");
        panelInput.add(lblHarga);
        lblHarga.setBounds(20, 130, 130, 25);

        txtHarga.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtHarga);
        txtHarga.setBounds(155, 127, 150, 30);

        lblFasilitas.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblFasilitas.setForeground(new java.awt.Color(44, 62, 80));
        lblFasilitas.setText("Fasilitas");
        panelInput.add(lblFasilitas);
        lblFasilitas.setBounds(20, 165, 130, 25);

        txtFasilitas.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtFasilitas);
        txtFasilitas.setBounds(155, 162, 300, 30);

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
        panelInput.setBounds(0, 40, 900, 210);

        tabelPaket.setFont(new java.awt.Font("Segoe UI", 0, 12));
        tabelPaket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID Paket", "Nama Paket", "Durasi (Bln)", "Harga (Rp)", "Fasilitas"}
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }
        });
        scrollPane.setViewportView(tabelPaket);

        getContentPane().add(scrollPane);
        scrollPane.setBounds(10, 255, 880, 230);

        setSize(new java.awt.Dimension(900, 520));
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
        model = (DefaultTableModel) tabelPaket.getModel();
        styleTable(tabelPaket);
        tabelPaket.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int r = tabelPaket.getSelectedRow();
                if (r < 0) return;
                txtIdPaket.setText(model.getValueAt(r, 0).toString());
                txtNamaPaket.setText(model.getValueAt(r, 1).toString());
                txtDurasi.setText(model.getValueAt(r, 2).toString());
                txtHarga.setText(model.getValueAt(r, 3).toString());
                txtFasilitas.setText(model.getValueAt(r, 4).toString());
            }
        });
        gym.komponen.SwingUtil.makeOpaque(btnSimpan, btnEdit, btnHapus, btnReset);
        gym.komponen.SwingUtil.styleTableHeader(tabelPaket);
    }

    private void styleTable(JTable t) {
        t.setRowHeight(28);
        t.setGridColor(new Color(240, 240, 240));
        t.setSelectionBackground(new Color(155, 89, 182, 40));
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
            ApiClient.ApiResponse res = ApiClient.get("/paket");
            if (!res.ok()) { JOptionPane.showMessageDialog(this, "Gagal memuat: " + ApiClient.errorMessage(res.body)); return; }
            List<Map<String, String>> rows = ApiClient.parseDataArray(res.body);
            for (Map<String, String> r : rows) {
                model.addRow(new Object[]{r.get("id_paket"), r.get("nama_paket"),
                    r.get("durasi_bulan"), r.get("harga"), r.get("fasilitas")});
            }
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private Map<String, Object> formToMap() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id_paket", txtIdPaket.getText().trim());
        m.put("nama_paket", txtNamaPaket.getText().trim());
        m.put("durasi_bulan", Integer.parseInt(txtDurasi.getText().trim()));
        m.put("harga", Integer.parseInt(txtHarga.getText().trim()));
        m.put("fasilitas", txtFasilitas.getText().trim());
        return m;
    }

    private void simpan() {
        if (txtIdPaket.getText().trim().isEmpty() || txtNamaPaket.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID dan Nama Paket harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        try {
            ApiClient.ApiResponse res = ApiClient.post("/paket", ApiClient.buildJson(formToMap()));
            if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil disimpan!"); reset(); tampilData(); }
            else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private void edit() {
        if (txtIdPaket.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        try {
            String id = ApiClient.encodePath(txtIdPaket.getText().trim());
            ApiClient.ApiResponse res = ApiClient.put("/paket/" + id, ApiClient.buildJson(formToMap()));
            if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil diupdate!"); reset(); tampilData(); }
            else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private void hapus() {
        if (txtIdPaket.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        int c = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (c == JOptionPane.YES_OPTION) {
            try {
                String id = ApiClient.encodePath(txtIdPaket.getText().trim());
                ApiClient.ApiResponse res = ApiClient.delete("/paket/" + id);
                if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil dihapus!"); reset(); tampilData(); }
                else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
            } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
        }
    }

    private void reset() {
        txtIdPaket.setText(""); txtNamaPaket.setText(""); txtDurasi.setText("");
        txtHarga.setText(""); txtFasilitas.setText("");
        txtIdPaket.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel lblDurasi;
    private javax.swing.JLabel lblFasilitas;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblIdPaket;
    private javax.swing.JLabel lblNamaPaket;
    private gym.komponen.PanelGradient panelHeader;
    private javax.swing.JPanel panelInput;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabelPaket;
    private javax.swing.JTextField txtDurasi;
    private javax.swing.JTextField txtFasilitas;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtIdPaket;
    private javax.swing.JTextField txtNamaPaket;
    // End of variables declaration//GEN-END:variables
}
