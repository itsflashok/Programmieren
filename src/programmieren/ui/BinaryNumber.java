package programmieren.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

public class BinaryNumber extends JFrame implements ActionListener {
    private JToggleButton[] toggleButtons = new JToggleButton[8];
    private JLabel resultLabel = new JLabel("Decimal: 0", JLabel.CENTER);
    ImageIcon onIcon = new ImageIcon(
            new ImageIcon("src/programmieren/ui/on.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    ImageIcon offIcon = new ImageIcon(
            new ImageIcon("src/programmieren/ui/off.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

    public BinaryNumber() {
        setTitle("Binary Number");
        setSize(600, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 8, 10, 10));

        String[] labels = { "2^7", "2^6", "2^5", "2^4", "2^3", "2^2", "2^1", "2^0" };

        for (int i = 0; i < 8; i++) {
            toggleButtons[i] = new JToggleButton();
            toggleButtons[i].addActionListener(this);
            panel.add(toggleButtons[i]);
            toggleButtons[i].setIcon(offIcon);
            toggleButtons[i].setFocusPainted(false);
        }

        for (int i = 0; i < 8; i++) {
            panel.add(new JLabel(labels[i], JLabel.CENTER));
        }

        add(panel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new BinaryNumber();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int value = 0;
        for (int i = 0; i < 8; i++) {
            if (toggleButtons[i].isSelected()) {
                value += (int) Math.pow(2, 7 - i);
                toggleButtons[i].setIcon(onIcon);
            } else {
                toggleButtons[i].setIcon(offIcon);
            }
        }
        resultLabel.setText("Decimal: " + value);
    }
}
