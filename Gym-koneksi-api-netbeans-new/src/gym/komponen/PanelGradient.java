package gym.komponen;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class PanelGradient extends JPanel {

    private Color colorStart = new Color(231, 76, 60);
    private Color colorEnd = new Color(44, 62, 80);
    private boolean vertical = false;

    public PanelGradient() {
        setOpaque(true);
    }

    public Color getColorStart() { return colorStart; }
    public void setColorStart(Color c) { this.colorStart = c; repaint(); }

    public Color getColorEnd() { return colorEnd; }
    public void setColorEnd(Color c) { this.colorEnd = c; repaint(); }

    public boolean isVertical() { return vertical; }
    public void setVertical(boolean v) { this.vertical = v; repaint(); }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = vertical
                ? new GradientPaint(0, 0, colorStart, 0, getHeight(), colorEnd)
                : new GradientPaint(0, 0, colorStart, getWidth(), 0, colorEnd);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
    }
}
