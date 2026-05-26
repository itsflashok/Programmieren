package programmieren.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Election extends JPanel {

    static final String[] PARTIES  = { "SPD",  "Union", "Grüne", "FDP",   "AfD",  "Linke", "SSW", "Andere" };
    static final double[] RESULTS  = { 16.4,   28.6,    11.6,    4.3,     20.8,   8.8,     0.2,   9.4     };
    static final Color[]  COLORS   = {
        Color.RED,
        Color.BLACK,
        new Color(0, 200, 0),
        Color.YELLOW,
        Color.BLUE,
        new Color(220, 0, 220),
        new Color(0, 180, 220),
        Color.GRAY
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Header bar
        int headerH = 36;
        g2.setColor(new Color(30, 100, 200));
        g2.fillRect(0, 0, w, headerH);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 18));
        g2.drawString("BUNDESTAGSWAHL 2025", 10, headerH - 10);
        g2.setFont(new Font("Arial", Font.PLAIN, 14));
        g2.drawString("in %", w - 40, headerH - 10);

        // Chart area
        int labelH   = 40;  // space at bottom for party name + value
        int marginTop    = headerH + 20;
        int marginLeft   = 40;
        int marginRight  = 20;
        int chartBottom  = h - labelH;
        int chartH       = chartBottom - marginTop;
        int chartW       = w - marginLeft - marginRight;

        // Background
        g2.setColor(new Color(220, 230, 245));
        g2.fillRect(marginLeft, marginTop, chartW, chartH);

        // Scale lines
        double maxVal = 30.0;
        int scaleSteps = 6;
        g2.setFont(new Font("Arial", Font.PLAIN, 10));
        for (int i = 0; i <= scaleSteps; i++) {
            double val = maxVal * i / scaleSteps;
            int y = chartBottom - (int) (chartH * val / maxVal);
            g2.setColor(new Color(180, 195, 215));
            g2.drawLine(marginLeft, y, marginLeft + chartW, y);
            g2.setColor(Color.DARK_GRAY);
            g2.drawString(String.format("%.0f", val), 2, y + 4);
        }

        // Bars
        int n = PARTIES.length;
        int barAreaW = chartW / n;
        int barW     = (int) (barAreaW * 0.55);
        int barGap   = (barAreaW - barW) / 2;

        Font labelFont = new Font("Arial", Font.BOLD, 12);
        Font valueFont = new Font("Arial", Font.PLAIN, 12);
        g2.setFont(labelFont);
        FontMetrics fmLabel = g2.getFontMetrics(labelFont);
        FontMetrics fmValue = g2.getFontMetrics(valueFont);

        for (int i = 0; i < n; i++) {
            int barH   = (int) (chartH * RESULTS[i] / maxVal);
            int x      = marginLeft + i * barAreaW + barGap;
            int y      = chartBottom - barH;

            // Bar
            g2.setColor(COLORS[i]);
            g2.fillRect(x, y, barW, barH);
            g2.setColor(Color.DARK_GRAY);
            g2.drawRect(x, y, barW, barH);

            // Party name
            g2.setFont(labelFont);
            int nameW = fmLabel.stringWidth(PARTIES[i]);
            int cx    = x + barW / 2;
            g2.setColor(Color.BLACK);
            g2.drawString(PARTIES[i], cx - nameW / 2, chartBottom + 16);

            // Percent value
            g2.setFont(valueFont);
            String valStr = String.valueOf(RESULTS[i]);
            int valW = fmValue.stringWidth(valStr);
            g2.setColor(new Color(50, 50, 50));
            g2.drawString(valStr, cx - valW / 2, chartBottom + 32);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Wahl");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 500);
            frame.add(new Election());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
