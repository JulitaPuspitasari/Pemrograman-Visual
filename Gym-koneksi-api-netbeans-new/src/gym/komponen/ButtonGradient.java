package gym.komponen;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

public class ButtonGradient extends JButton {

    private Color colorStart = new Color(231, 76, 60);
    private Color colorEnd = new Color(243, 156, 18);
    private Color colorHover = new Color(236, 100, 86);
    private Color colorPressed = new Color(192, 57, 43);
    private int arc = 10;

    public ButtonGradient() {
        setForeground(Color.WHITE);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public Color getColorStart() { return colorStart; }
    public void setColorStart(Color c) { this.colorStart = c; repaint(); }

    public Color getColorEnd() { return colorEnd; }
    public void setColorEnd(Color c) { this.colorEnd = c; repaint(); }

    public Color getColorHover() { return colorHover; }
    public void setColorHover(Color c) { this.colorHover = c; repaint(); }

    public Color getColorPressed() { return colorPressed; }
    public void setColorPressed(Color c) { this.colorPressed = c; repaint(); }

    public int getArc() { return arc; }
    public void setArc(int a) { this.arc = a; repaint(); }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isPressed()) {
            g2d.setColor(colorPressed);
        } else if (getModel().isRollover()) {
            g2d.setColor(colorHover);
        } else {
            g2d.setPaint(new GradientPaint(0, 0, colorStart, getWidth(), 0, colorEnd));
        }
        g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arc, arc));
        g2d.setColor(getForeground());
        g2d.setFont(getFont());
        FontMetrics fm = g2d.getFontMetrics();
        String text = getText();
        int x = (getWidth() - fm.stringWidth(text)) / 2;
        int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
        g2d.drawString(text, x, y);
        g2d.dispose();
    }
}
