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

public class FormBilling extends javax.swing.JInternalFrame {

    private DefaultTableModel model;

    public FormBilling() {
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
        lblIdBilling = new javax.swing.JLabel();
        txtIdBilling = new javax.swing.JTextField();
        lblIdMember = new javax.swing.JLabel();
        txtIdMember = new javax.swing.JTextField();
        lblIdPaket = new javax.swing.JLabel();
        txtIdPaket = new javax.swing.JTextField();
        lblIdTrainer = new javax.swing.JLabel();
        txtIdTrainer = new javax.swing.JTextField();
        lblOpsional = new javax.swing.JLabel();
        lblTglBayar = new javax.swing.JLabel();
        txtTglBayar = new javax.swing.JTextField();
        lblFmt1 = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        lblMetode = new javax.swing.JLabel();
        cmbMetode = new javax.swing.JComboBox<>();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tabelBilling = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Billing / Pembayaran");
        getContentPane().setLayout(null);

        panelHeader.setLayout(null);

        lblHeader.setFont(new java.awt.Font("Segoe UI", 1, 16));
        lblHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblHeader.setText("Billing / Pembayaran");
        panelHeader.add(lblHeader);
        lblHeader.setBounds(15, 8, 400, 25);

        getContentPane().add(panelHeader);
        panelHeader.setBounds(0, 0, 1050, 40);

        panelInput.setBackground(new java.awt.Color(255, 255, 255));
        panelInput.setLayout(null);

        lblIdBilling.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblIdBilling.setForeground(new java.awt.Color(44, 62, 80));
        lblIdBilling.setText("ID Billing");
        panelInput.add(lblIdBilling);
        lblIdBilling.setBounds(20, 25, 130, 25);

        txtIdBilling.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtIdBilling);
        txtIdBilling.setBounds(155, 22, 180, 30);

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

        lblIdTrainer.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblIdTrainer.setForeground(new java.awt.Color(44, 62, 80));
        lblIdTrainer.setText("ID Trainer");
        panelInput.add(lblIdTrainer);
        lblIdTrainer.setBounds(20, 130, 130, 25);

        txtIdTrainer.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtIdTrainer);
        txtIdTrainer.setBounds(155, 127, 180, 30);

        lblOpsional.setFont(new java.awt.Font("Segoe UI", 2, 11));
        lblOpsional.setForeground(new java.awt.Color(149, 165, 166));
        lblOpsional.setText("(opsional)");
        panelInput.add(lblOpsional);
        lblOpsional.setBounds(340, 130, 80, 25);

        lblTglBayar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblTglBayar.setForeground(new java.awt.Color(44, 62, 80));
        lblTglBayar.setText("Tgl Bayar");
        panelInput.add(lblTglBayar);
        lblTglBayar.setBounds(20, 165, 130, 25);

        txtTglBayar.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtTglBayar);
        txtTglBayar.setBounds(155, 162, 150, 30);

        lblFmt1.setFont(new java.awt.Font("Segoe UI", 2, 11));
        lblFmt1.setForeground(new java.awt.Color(149, 165, 166));
        lblFmt1.setText("(yyyy-MM-dd)");
        panelInput.add(lblFmt1);
        lblFmt1.setBounds(310, 165, 100, 25);

        lblJumlah.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblJumlah.setForeground(new java.awt.Color(44, 62, 80));
        lblJumlah.setText("Jumlah Bayar");
        panelInput.add(lblJumlah);
        lblJumlah.setBounds(20, 200, 130, 25);

        txtJumlah.setFont(new java.awt.Font("Segoe UI", 0, 13));
        panelInput.add(txtJumlah);
        txtJumlah.setBounds(155, 197, 150, 30);

        lblMetode.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblMetode.setForeground(new java.awt.Color(44, 62, 80));
        lblMetode.setText("Metode Bayar");
        panelInput.add(lblMetode);
        lblMetode.setBounds(500, 25, 130, 25);

        cmbMetode.setFont(new java.awt.Font("Segoe UI", 0, 13));
        cmbMetode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Transfer", "E-Wallet" }));
        panelInput.add(cmbMetode);
        cmbMetode.setBounds(635, 22, 150, 30);

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblStatus.setForeground(new java.awt.Color(44, 62, 80));
        lblStatus.setText("Status Bayar");
        panelInput.add(lblStatus);
        lblStatus.setBounds(500, 60, 130, 25);

        cmbStatus.setFont(new java.awt.Font("Segoe UI", 0, 13));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunas", "Belum Lunas" }));
        panelInput.add(cmbStatus);
        cmbStatus.setBounds(635, 57, 150, 30);

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
        btnSimpan.setBounds(500, 105, 110, 33);

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
        btnEdit.setBounds(615, 105, 110, 33);

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
        btnHapus.setBounds(500, 143, 110, 33);

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
        btnReset.setBounds(615, 143, 110, 33);

        getContentPane().add(panelInput);
        panelInput.setBounds(0, 40, 1050, 250);

        tabelBilling.setFont(new java.awt.Font("Segoe UI", 0, 12));
        tabelBilling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID Billing", "Nama Member", "Paket", "Trainer", "Tgl Bayar", "Jumlah (Rp)", "Metode", "Status"}
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }
        });
        scrollPane.setViewportView(tabelBilling);

        getContentPane().add(scrollPane);
        scrollPane.setBounds(10, 295, 1030, 245);

        setSize(new java.awt.Dimension(1050, 580));
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
        model = (DefaultTableModel) tabelBilling.getModel();
        styleTable(tabelBilling);
        tabelBilling.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int r = tabelBilling.getSelectedRow();
                if (r < 0) return;
                txtIdBilling.setText(model.getValueAt(r, 0).toString());
                ambilIdDariBilling(model.getValueAt(r, 0).toString());
                txtTglBayar.setText(model.getValueAt(r, 4).toString());
                txtJumlah.setText(model.getValueAt(r, 5).toString());
                cmbMetode.setSelectedItem(model.getValueAt(r, 6).toString());
                cmbStatus.setSelectedItem(model.getValueAt(r, 7).toString());
            }
        });
        gym.komponen.SwingUtil.makeOpaque(btnSimpan, btnEdit, btnHapus, btnReset);
        gym.komponen.SwingUtil.styleTableHeader(tabelBilling);
    }

    private void ambilIdDariBilling(String idBilling) {
        try {
            ApiClient.ApiResponse res = ApiClient.get("/billing/" + ApiClient.encodePath(idBilling));
            if (res.ok()) {
                Map<String, String> obj = ApiClient.parseObject(res.body);
                txtIdMember.setText(obj.getOrDefault("id_member", ""));
                txtIdPaket.setText(obj.getOrDefault("id_paket", ""));
                txtIdTrainer.setText(obj.getOrDefault("id_trainer", ""));
            }
        } catch (Exception e) { /* ignore */ }
    }

    private void styleTable(JTable t) {
        t.setRowHeight(28);
        t.setGridColor(new Color(240, 240, 240));
        t.setSelectionBackground(new Color(231, 76, 60, 40));
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
            Map<String, String> namaTrainer = new HashMap<>();
            ApiClient.ApiResponse mres = ApiClient.get("/member");
            if (mres.ok()) for (Map<String, String> r : ApiClient.parseDataArray(mres.body)) namaMember.put(r.get("id_member"), r.get("nama"));
            ApiClient.ApiResponse pres = ApiClient.get("/paket");
            if (pres.ok()) for (Map<String, String> r : ApiClient.parseDataArray(pres.body)) namaPaket.put(r.get("id_paket"), r.get("nama_paket"));
            ApiClient.ApiResponse tres = ApiClient.get("/trainer");
            if (tres.ok()) for (Map<String, String> r : ApiClient.parseDataArray(tres.body)) namaTrainer.put(r.get("id_trainer"), r.get("nama"));

            ApiClient.ApiResponse res = ApiClient.get("/billing");
            if (!res.ok()) { JOptionPane.showMessageDialog(this, "Gagal memuat: " + ApiClient.errorMessage(res.body)); return; }
            for (Map<String, String> r : ApiClient.parseDataArray(res.body)) {
                String idM = r.get("id_member"), idP = r.get("id_paket"), idT = r.get("id_trainer");
                String trainerNama = (idT == null || idT.isEmpty()) ? "-" : namaTrainer.getOrDefault(idT, idT);
                model.addRow(new Object[]{r.get("id_billing"),
                    namaMember.getOrDefault(idM, idM),
                    namaPaket.getOrDefault(idP, idP),
                    trainerNama,
                    r.get("tanggal_bayar"), r.get("jumlah_bayar"),
                    r.get("metode_bayar"), r.get("status_bayar")});
            }
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private Map<String, Object> formToMap() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("id_billing", txtIdBilling.getText().trim());
        m.put("id_member", txtIdMember.getText().trim());
        m.put("id_paket", txtIdPaket.getText().trim());
        String trainer = txtIdTrainer.getText().trim();
        m.put("id_trainer", trainer.isEmpty() ? null : trainer);
        m.put("tanggal_bayar", txtTglBayar.getText().trim());
        m.put("jumlah_bayar", Integer.parseInt(txtJumlah.getText().trim()));
        m.put("metode_bayar", cmbMetode.getSelectedItem().toString());
        m.put("status_bayar", cmbStatus.getSelectedItem().toString());
        return m;
    }

    private void simpan() {
        if (txtIdBilling.getText().trim().isEmpty() || txtIdMember.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Billing dan ID Member harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        try {
            ApiClient.ApiResponse res = ApiClient.post("/billing", ApiClient.buildJson(formToMap()));
            if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil disimpan!"); reset(); tampilData(); }
            else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private void edit() {
        if (txtIdBilling.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        try {
            String id = ApiClient.encodePath(txtIdBilling.getText().trim());
            ApiClient.ApiResponse res = ApiClient.put("/billing/" + id, ApiClient.buildJson(formToMap()));
            if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil diupdate!"); reset(); tampilData(); }
            else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private void hapus() {
        if (txtIdBilling.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE); return;
        }
        int c = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (c == JOptionPane.YES_OPTION) {
            try {
                String id = ApiClient.encodePath(txtIdBilling.getText().trim());
                ApiClient.ApiResponse res = ApiClient.delete("/billing/" + id);
                if (res.ok()) { JOptionPane.showMessageDialog(this, "Data berhasil dihapus!"); reset(); tampilData(); }
                else JOptionPane.showMessageDialog(this, "Gagal: " + ApiClient.errorMessage(res.body));
            } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
        }
    }

    private void reset() {
        txtIdBilling.setText(""); txtIdMember.setText(""); txtIdPaket.setText("");
        txtIdTrainer.setText(""); txtTglBayar.setText(""); txtJumlah.setText("");
        cmbMetode.setSelectedIndex(0); cmbStatus.setSelectedIndex(0);
        txtIdBilling.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbMetode;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel lblFmt1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblIdBilling;
    private javax.swing.JLabel lblIdMember;
    private javax.swing.JLabel lblIdPaket;
    private javax.swing.JLabel lblIdTrainer;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblMetode;
    private javax.swing.JLabel lblOpsional;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTglBayar;
    private gym.komponen.PanelGradient panelHeader;
    private javax.swing.JPanel panelInput;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabelBilling;
    private javax.swing.JTextField txtIdBilling;
    private javax.swing.JTextField txtIdMember;
    private javax.swing.JTextField txtIdPaket;
    private javax.swing.JTextField txtIdTrainer;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtTglBayar;
    // End of variables declaration//GEN-END:variables
}
