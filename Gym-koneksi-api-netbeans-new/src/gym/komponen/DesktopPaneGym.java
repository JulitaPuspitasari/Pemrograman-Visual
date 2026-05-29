package gym.komponen;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JDesktopPane;

public class DesktopPaneGym extends JDesktopPane {

    private String watermark = "GYM ME - FITNESS CENTER";
    private String subtitle = "Pilih menu di atas untuk memulai";

    public DesktopPaneGym() {
        setBackground(new Color(236, 240, 241));
    }

    public String getWatermark() { return watermark; }
    public void setWatermark(String s) { this.watermark = s; repaint(); }

    public String getSubtitle() { return subtitle; }
    public void setSubtitle(String s) { this.subtitle = s; repaint(); }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(236, 240, 241));
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(new Color(0, 0, 0, 15));
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 42));
        FontMetrics fm = g2d.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(watermark)) / 2;
        int y = getHeight() / 2 - 30;
        g2d.drawString(watermark, x, y);

        g2d.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        fm = g2d.getFontMetrics();
        x = (getWidth() - fm.stringWidth(subtitle)) / 2;
        g2d.drawString(subtitle, x, y + 40);
        g2d.dispose();
    }
}
