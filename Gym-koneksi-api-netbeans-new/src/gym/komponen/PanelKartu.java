package gym.komponen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelKartu extends JPanel {

    private int arc = 20;

    public PanelKartu() {
        setOpaque(false);
    }

    public int getArc() { return arc; }
    public void setArc(int arc) { this.arc = arc; repaint(); }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(0, 0, 0, 15));
        g2d.fill(new RoundRectangle2D.Float(3, 3, getWidth() - 3, getHeight() - 3, arc, arc));
        g2d.setColor(Color.WHITE);
        g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth() - 3, getHeight() - 3, arc, arc));
        g2d.dispose();
        super.paintComponent(g);
    }
}
