package gym.komponen;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class SwingUtil {

    private static final Color DARK = new Color(44, 62, 80);

    public static void makeOpaque(JButton... buttons) {
        for (JButton b : buttons) {
            b.setOpaque(true);
            b.setContentAreaFilled(true);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            // Paksa pakai BasicButtonUI biar Windows L&F gak override warna
            b.setUI(new javax.swing.plaf.basic.BasicButtonUI());
            b.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        }
    }

    public static void styleTableHeader(JTable table) {
        table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
                JLabel lbl = (JLabel) super.getTableCellRendererComponent(t, v, s, f, r, c);
                lbl.setBackground(DARK);
                lbl.setForeground(Color.WHITE);
                lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
                lbl.setOpaque(true);
                lbl.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
                lbl.setHorizontalAlignment(SwingConstants.LEFT);
                return lbl;
            }
        });
    }
}
