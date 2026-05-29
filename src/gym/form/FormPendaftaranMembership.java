package gym.form;

import gym.koneksi.ApiClient;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class FormPendaftaranMembership extends javax.swing.JInternalFrame {

    private DefaultTableModel model;

    public FormPendaftaranMembership() {
        initComponents();
        panelHeader.setColorStart(new Color(52, 152, 219));
        setupTabel();
        tampilData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new gym.komponen.PanelGradient();
        lblHeader = new javax.swing.JLabel();
        panelInput = new javax.swing.JPanel();
        lblIdPendaftaran = new javax.swing.JLabel();
        txtIdPendaftaran = new javax.swing.JTextField();
        lblIdMember = new javax.swing.JLabel();
        txtIdMember = new javax.swing.JTextField();
        lblIdPaket = new javax.swing.JLabel();
        txtIdPaket = new javax.swing.JTextField();
        lblTglDaftar = new javax.swing.JLabel();
        txtTglDaftar = new javax.swing.JTextField();
        lblFmt1 = new javax.swing.JLabel();
        lblTglExpired = new javax.swing.JLabel();
        txtTglExpired = new javax.swing.JTextField();
        lblFmt2 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tabelPendaftaran = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pendaftaran Membership");
        getContentPane().setLayout(null);

        panelHeader.setLayout(null);

        lblHeader.setFont(new java.awt.Font("Segoe UI", 1, 16));
        lblHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblHeader.setText("Transaksi Pendaftaran Membership");
        panelHeader.add(lblHeader);
        lblHeader.setBounds(15, 8, 400, 25);

        getContentPane().add(panelHeader);
        panelHeader.setBounds(0, 0, 950, 40);

        panelInput.setBackground(new java.awt.Color(255, 255, 255));
        panelInput.setLayout(null);

        lblIdPendaftaran.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblIdPendaftaran.setForeground(new java.awt.Color(44, 62, 80));
        lblIdPendaftaran.setText("ID Pendaftaran");
        panelInput.add(lblIdPendaftaran);
        lblIdPendaftaran.setBounds(20, 25, 130, 25);

        txtIdPendaftaran.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtIdPendaftaran);
        txtIdPendaftaran.setBounds(155, 22, 180, 30);

        lblIdMember.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblIdMember.setForeground(new java.awt.Color(44, 62, 80));
        lblIdMember.setText("ID Member");
        panelInput.add(lblIdMember);
        lblIdMember.setBounds(20, 60, 130, 25);

        txtIdMember.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtIdMember);
        txtIdMember.setBounds(155, 57, 180, 30);

        lblIdPaket.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblIdPaket.setForeground(new java.awt.Color(44, 62, 80));
        lblIdPaket.setText("ID Paket");
        panelInput.add(lblIdPaket);
        lblIdPaket.setBounds(20, 95, 130, 25);

        txtIdPaket.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtIdPaket);
        txtIdPaket.setBounds(155, 92, 180, 30);

        lblTglDaftar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblTglDaftar.setForeground(new java.awt.Color(44, 62, 80));
        lblTglDaftar.setText("Tgl Daftar");
        panelInput.add(lblTglDaftar);
        lblTglDaftar.setBounds(20, 130, 130, 25);

        txtTglDaftar.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtTglDaftar);
        txtTglDaftar.setBounds(155, 127, 150, 30);

        lblFmt1.setFont(new java.awt.Font("Segoe UI", 2, 11));
        lblFmt1.setForeground(new java.awt.Color(149, 165, 166));
        lblFmt1.setText("(yyyy-MM-dd)");
        panelInput.add(lblFmt1);
        lblFmt1.setBounds(310, 130, 100, 25);

        lblTglExpired.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblTglExpired.setForeground(new java.awt.Color(44, 62, 80));
        lblTglExpired.setText("Tgl Expired");
        panelInput.add(lblTglExpired);
        lblTglExpired.setBounds(20, 165, 130, 25);

        txtTglExpired.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtTglExpired);
        txtTglExpired.setBounds(155, 162, 150, 30);

        lblFmt2.setFont(new java.awt.Font("Segoe UI", 2, 11));
        lblFmt2.setForeground(new java.awt.Color(149, 165, 166));
        lblFmt2.setText("(yyyy-MM-dd)");
        panelInput.add(lblFmt2);
        lblFmt2.setBounds(310, 165, 100, 25);

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblStatus.setForeground(new java.awt.Color(44, 62, 80));
        lblStatus.setText("Status");
        panelInput.add(lblStatus);
        lblStatus.setBounds(500, 25, 130, 25);

        cmbStatus.setFont(new java.awt.Font("Segoe UI", 0, 13));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Expired" }));
        panelInput.add(cmbStatus);
        cmbStatus.setBounds(620, 22, 150, 30);

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
        panelInput.setBounds(0, 40, 950, 210);

        tabelPendaftaran.setFont(new java.awt.Font("Segoe UI", 0, 12));
        tabelPendaftaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID Daftar", "Nama Member", "Paket", "Tgl Daftar", "Tgl Expired", "Status"}
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }
        });
        scrollPane.setViewportView(tabelPendaftaran);

        getContentPane().add(scrollPane);
        scrollPane.setBounds(10, 255, 930, 270);

        setSize(new java.awt.Dimension(950, 560));
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
        model = (DefaultTableModel) tabelPendaftaran.getModel();
        styleTable(tabelPendaftaran);
        tabelPendaftaran.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int r = tabelPendaftaran.getSelectedRow();
                if (r < 0) return;
                txtIdPendaftaran.setText(model.getValueAt(r, 0).toString());
                ambilIdDariPendaftaran(model.getValueAt(r, 0).toString());
                txtTglDaftar.setText(model.getValueAt(r, 3).toString());
                txtTglExpired.setText(model.getValueAt(r, 4).toString());
                cmbStatus.setSelectedItem(model.getValueAt(r, 5).toString());
            }
        });
        gym.komponen.SwingUtil.makeOpaque(btnSimpan, btnEdit, btnHapus, btnReset);
        gym.komponen.SwingUtil.styleTableHeader(tabelPendaftaran);
    }

    private void ambilIdDariPendaftaran(String idPendaftaran) {
        try {
            ApiClient.ApiResponse res = ApiClient.get("/pendaftaran/" + ApiClient.encodePath(idPendaftaran));
            if (res.ok()) {
                Map<String, String> obj = ApiClient.parseObject(res.body);
                txtIdMember.setText(obj.getOrDefault("id_member", ""));
                txtIdPaket.setText(obj.getOrDefault("id_paket", ""));
            }
        } catch (Exception e) { /* ignore */ }
    }

    private void styleTable(JTable t) {
        t.setRowHeight(28);
        t.setGridColor(new Color(240, 240, 240));
        t.setSelectionBackground(new Color(52, 152, 219, 40));
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
            Map<String, String> namaPaket = new HashMap<>();
            ApiClient.ApiResponse mres = ApiClient.get("/member");
            if (mres.ok()) for (Map<String, String> r : ApiClient.parseDataArray(mres.body)) namaMember.put(r.get("id_member"), r.get("nama"));
            ApiClient.ApiResponse pres = ApiClient.get("/paket");
            if (pres.ok()) for (Map<String, String> r : ApiClient.parseDataArray(pres.body)) namaPaket.put(r.get("id_paket"), r.get("nama_paket"));
            ApiClient.ApiResponse res = ApiClient.get("/pendaftaran");
            if (!res.ok()) { JOptionPane.showMessageDialog(this, "Gagal memuat: " + ApiClient.errorMessage(res.body)); return; }
            for (Map<String, String> r : ApiClient.parseDataArray(res.body)) {
                String idM = r.get("id_member");
                String idP = r.get("id_paket");
                model.addRow(new Object[]{r.get("id_pendaftaran"),
                    namaMember.getOrDefault(idM, idM),
                    namaPaket.getOrDefault(idP, idP),
                    r.get("tanggal_daftar"), r.get("tanggal_expired"), r.get("status")});
            }
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private Map<String, Object> formToMap() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id_pendaftaran", txtIdPendaftaran.getText().trim());
        m.put("id_member", txtIdMember.getText().trim());
        m.put("id_paket", txtIdPaket.getText().trim());
        m.put("tanggal_daftar", txtTglDaftar.getText().trim());
        m.put("tanggal_expired", txtTglExpired.getText().trim());
        m.put("status", cmbStatus.getSelectedItem().toString());
        return m;
    }

    private void simpan() {
        if (txtIdPendaftaran.getText().trim().isEmpty() || txtIdMember.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Pendaftaran dan ID Member harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        try {
            ApiClient.ApiResponse res = ApiClient.post("/pendaftaran", ApiClient.buildJson(formToMap()));
            if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil disimpan!"); reset(); tampilData(); }
            else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private void edit() {
        if (txtIdPendaftaran.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        try {
            String id = ApiClient.encodePath(txtIdPendaftaran.getText().trim());
            ApiClient.ApiResponse res = ApiClient.put("/pendaftaran/" + id, ApiClient.buildJson(formToMap()));
            if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil diupdate!"); reset(); tampilData(); }
            else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private void hapus() {
        if (txtIdPendaftaran.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        int c = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (c == JOptionPane.YES_OPTION) {
            try {
                String id = ApiClient.encodePath(txtIdPendaftaran.getText().trim());
                ApiClient.ApiResponse res = ApiClient.delete("/pendaftaran/" + id);
                if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil dihapus!"); reset(); tampilData(); }
                else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
            } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
        }
    }

    private void reset() {
        txtIdPendaftaran.setText(""); txtIdMember.setText(""); txtIdPaket.setText("");
        txtTglDaftar.setText(""); txtTglExpired.setText("");
        cmbStatus.setSelectedIndex(0);
        txtIdPendaftaran.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel lblFmt1;
    private javax.swing.JLabel lblFmt2;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblIdMember;
    private javax.swing.JLabel lblIdPaket;
    private javax.swing.JLabel lblIdPendaftaran;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTglDaftar;
    private javax.swing.JLabel lblTglExpired;
    private gym.komponen.PanelGradient panelHeader;
    private javax.swing.JPanel panelInput;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabelPendaftaran;
    private javax.swing.JTextField txtIdMember;
    private javax.swing.JTextField txtIdPaket;
    private javax.swing.JTextField txtIdPendaftaran;
    private javax.swing.JTextField txtTglDaftar;
    private javax.swing.JTextField txtTglExpired;
    // End of variables declaration//GEN-END:variables
}
