package gym.form;

import gym.koneksi.ApiClient;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class DialogCariId extends JDialog {

    private String hasilId = null;
    private final String idKey;
    private final String[] dataKey;
    private final DefaultTableModel model;
    private final JTable tabel;
    private final TableRowSorter<DefaultTableModel> sorter;

    public DialogCariId(Window owner, String judul, String endpoint,
                        String idKey, String[] headerKolom, String[] dataKey) {
        super(owner, "Cari " + judul, ModalityType.APPLICATION_MODAL);
        this.idKey = idKey;
        this.dataKey = dataKey;

        setSize(720, 480);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());

        gym.komponen.PanelGradient header = new gym.komponen.PanelGradient();
        header.setPreferredSize(new Dimension(0, 45));
        header.setLayout(null);
        JLabel lblHeader = new JLabel("  Cari " + judul);
        lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblHeader.setForeground(Color.WHITE);
        lblHeader.setBounds(15, 10, 500, 25);
        header.add(lblHeader);
        add(header, BorderLayout.NORTH);

        JPanel panelTengah = new JPanel(new BorderLayout(0, 8));
        panelTengah.setBorder(BorderFactory.createEmptyBorder(12, 12, 8, 12));
        panelTengah.setBackground(Color.WHITE);

        JPanel panelSearch = new JPanel(new BorderLayout(8, 0));
        panelSearch.setBackground(Color.WHITE);
        JLabel lblSearch = new JLabel("Cari:");
        lblSearch.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblSearch.setForeground(new Color(44, 62, 80));
        final JTextField txtCari = new JTextField();
        txtCari.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtCari.setPreferredSize(new Dimension(0, 30));
        panelSearch.add(lblSearch, BorderLayout.WEST);
        panelSearch.add(txtCari, BorderLayout.CENTER);
        panelTengah.add(panelSearch, BorderLayout.NORTH);

        model = new DefaultTableModel(new Object[0][0], headerKolom) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };
        tabel = new JTable(model);
        sorter = new TableRowSorter<DefaultTableModel>(model);
        tabel.setRowSorter(sorter);
        styleTabel(tabel);

        JScrollPane scroll = new JScrollPane(tabel);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        panelTengah.add(scroll, BorderLayout.CENTER);

        add(panelTengah, BorderLayout.CENTER);

        JPanel panelBawah = new JPanel();
        panelBawah.setBackground(new Color(248, 249, 250));
        panelBawah.setBorder(BorderFactory.createEmptyBorder(8, 12, 12, 12));
        panelBawah.setLayout(null);
        panelBawah.setPreferredSize(new Dimension(0, 55));

        final JButton btnPilih = new JButton("Pilih");
        btnPilih.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnPilih.setBackground(new Color(46, 204, 113));
        btnPilih.setForeground(Color.WHITE);
        btnPilih.setBounds(490, 8, 100, 33);

        final JButton btnBatal = new JButton("Batal");
        btnBatal.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnBatal.setBackground(new Color(149, 165, 166));
        btnBatal.setForeground(Color.WHITE);
        btnBatal.setBounds(595, 8, 100, 33);

        gym.komponen.SwingUtil.makeOpaque(btnPilih, btnBatal);

        panelBawah.add(btnPilih);
        panelBawah.add(btnBatal);
        add(panelBawah, BorderLayout.SOUTH);

        txtCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { filterTabel(txtCari.getText()); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { filterTabel(txtCari.getText()); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { filterTabel(txtCari.getText()); }
        });

        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) pilih();
            }
        });

        tabel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) pilih();
            }
        });

        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { pilih(); }
        });

        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hasilId = null;
                dispose();
            }
        });

        muatData(endpoint);
    }

    private void filterTabel(String teks) {
        if (teks == null || teks.trim().isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + java.util.regex.Pattern.quote(teks.trim())));
        }
    }

    private void pilih() {
        int viewRow = tabel.getSelectedRow();
        if (viewRow < 0) {
            JOptionPane.showMessageDialog(this, "Pilih salah satu data!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int modelRow = tabel.convertRowIndexToModel(viewRow);
        Object v = model.getValueAt(modelRow, 0);
        hasilId = v == null ? "" : v.toString();
        dispose();
    }

    private void muatData(String endpoint) {
        try {
            ApiClient.ApiResponse res = ApiClient.get(endpoint);
            if (!res.ok()) {
                JOptionPane.showMessageDialog(this,
                    "Gagal memuat data: " + ApiClient.errorMessage(res.body),
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Map<String, String>> rows = ApiClient.parseDataArray(res.body);
            for (Map<String, String> r : rows) {
                Object[] baris = new Object[dataKey.length];
                for (int i = 0; i < dataKey.length; i++) {
                    String val = r.get(dataKey[i]);
                    baris[i] = val == null ? "" : val;
                }
                model.addRow(baris);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void styleTabel(JTable t) {
        t.setRowHeight(26);
        t.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        t.setGridColor(new Color(240, 240, 240));
        t.setSelectionBackground(new Color(52, 152, 219, 60));
        t.setSelectionForeground(new Color(44, 62, 80));
        t.setShowVerticalLines(false);
        t.setIntercellSpacing(new Dimension(0, 1));
        JTableHeader h = t.getTableHeader();
        h.setFont(new Font("Segoe UI", Font.BOLD, 12));
        h.setPreferredSize(new Dimension(0, 32));
        gym.komponen.SwingUtil.styleTableHeader(t);
        t.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tb, Object v, boolean s, boolean f, int r, int c) {
                Component comp = super.getTableCellRendererComponent(tb, v, s, f, r, c);
                if (!s) comp.setBackground(r % 2 == 0 ? Color.WHITE : new Color(248, 249, 250));
                setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
                return comp;
            }
        });
    }

    public String getHasilId() {
        return hasilId;
    }

    public static String pilihId(Window owner, String judul, String endpoint,
                                 String idKey, String[] headerKolom, String[] dataKey) {
        DialogCariId d = new DialogCariId(owner, judul, endpoint, idKey, headerKolom, dataKey);
        d.setVisible(true);
        return d.getHasilId();
    }
}
