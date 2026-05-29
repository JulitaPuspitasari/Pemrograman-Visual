package gym.report;

import gym.koneksi.ApiClient;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
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

public class LaporanRekapJadwal extends javax.swing.JFrame {

    private DefaultTableModel model;
    private List<Map<String, ?>> dataLaporan = new ArrayList<>();

    public LaporanRekapJadwal() {
        initComponents();
        panelHeader.setColorStart(new Color(39, 174, 96));
        setLocationRelativeTo(null);
        setupTabel();
        muatData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new gym.komponen.PanelGradient();
        lblTitle = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        panelFooter = new javax.swing.JPanel();
        btnCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Laporan Rekap Jadwal Latihan Harian");
        getContentPane().setLayout(new java.awt.BorderLayout());

        panelHeader.setPreferredSize(new java.awt.Dimension(0, 50));
        panelHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 12));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("LAPORAN REKAP JADWAL LATIHAN HARIAN - GYM ME");
        panelHeader.add(lblTitle);

        getContentPane().add(panelHeader, java.awt.BorderLayout.NORTH);

        tabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"No", "ID Jadwal", "Nama Member", "Kelas", "Trainer", "Hari", "Jam", "Tanggal"}
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }
        });
        scrollPane.setViewportView(tabel);

        getContentPane().add(scrollPane, java.awt.BorderLayout.CENTER);

        panelFooter.setBackground(new java.awt.Color(248, 249, 250));

        btnCetak.setBackground(new java.awt.Color(39, 174, 96));
        btnCetak.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnCetak.setForeground(new java.awt.Color(255, 255, 255));
        btnCetak.setText("Cetak Laporan");
        btnCetak.setBorderPainted(false);
        btnCetak.setFocusPainted(false);
        btnCetak.setPreferredSize(new java.awt.Dimension(150, 35));
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { btnCetakActionPerformed(evt); }
        });
        panelFooter.add(btnCetak);

        getContentPane().add(panelFooter, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(1000, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        if (dataLaporan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada data untuk dicetak!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JasperHelper.tampilkanLaporan(this, "/gym/report/laporan_rekap_jadwal.jrxml",
            "LAPORAN REKAP JADWAL LATIHAN HARIAN", dataLaporan);
    }//GEN-LAST:event_btnCetakActionPerformed

    private void setupTabel() {
        model = (DefaultTableModel) tabel.getModel();
        styleTable(tabel);
        gym.komponen.SwingUtil.makeOpaque(btnCetak);
        gym.komponen.SwingUtil.styleTableHeader(tabel);
    }

    private void styleTable(JTable t) {
        t.setRowHeight(28);
        t.setGridColor(new Color(240, 240, 240));
        t.setSelectionBackground(new Color(39, 174, 96, 40));
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

    private void muatData() {
        try {
            Map<String, String> namaMember = new HashMap<>();
            Map<String, String> namaKelas = new HashMap<>();
            Map<String, String> namaTrainer = new HashMap<>();
            ApiClient.ApiResponse mres = ApiClient.get("/member");
            if (mres.ok()) for (Map<String, String> r : ApiClient.parseDataArray(mres.body)) namaMember.put(r.get("id_member"), r.get("nama"));
            ApiClient.ApiResponse kres = ApiClient.get("/kelas");
            if (kres.ok()) for (Map<String, String> r : ApiClient.parseDataArray(kres.body)) namaKelas.put(r.get("id_kelas"), r.get("nama_kelas"));
            ApiClient.ApiResponse tres = ApiClient.get("/trainer");
            if (tres.ok()) for (Map<String, String> r : ApiClient.parseDataArray(tres.body)) namaTrainer.put(r.get("id_trainer"), r.get("nama"));

            ApiClient.ApiResponse res = ApiClient.get("/jadwal");
            if (res.ok()) {
                int no = 1;
                dataLaporan.clear();
                for (Map<String, String> r : ApiClient.parseDataArray(res.body)) {
                    String idM = r.get("id_member"), idK = r.get("id_kelas"), idT = r.get("id_trainer");
                    String nMember = namaMember.getOrDefault(idM, idM);
                    String nKelas = namaKelas.getOrDefault(idK, idK);
                    String nTrainer = namaTrainer.getOrDefault(idT, idT);
                    model.addRow(new Object[]{no, r.get("id_jadwal"), nMember, nKelas, nTrainer,
                        r.get("hari"), r.get("jam"), r.get("tanggal")});
                    Map<String, Object> row = new LinkedHashMap<>();
                    row.put("no", no);
                    row.put("id_jadwal", safe(r.get("id_jadwal")));
                    row.put("nama_member", safe(nMember));
                    row.put("nama_kelas", safe(nKelas));
                    row.put("nama_trainer", safe(nTrainer));
                    row.put("hari", safe(r.get("hari")));
                    row.put("jam", safe(r.get("jam")));
                    row.put("tanggal", safe(r.get("tanggal")));
                    dataLaporan.add(row);
                    no++;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Gagal memuat: " + ApiClient.errorMessage(res.body));
            }
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private static String safe(String s) { return s == null ? "" : s; }

    public static void tampilLaporan() {
        new LaporanRekapJadwal().setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { new LaporanRekapJadwal().setVisible(true); }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JLabel lblTitle;
    private gym.komponen.PanelGradient panelHeader;
    private javax.swing.JPanel panelFooter;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
