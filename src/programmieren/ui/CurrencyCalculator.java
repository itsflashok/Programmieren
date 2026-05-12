package programmieren.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class CurrencyCalculator {
    public CurrencyCalculator() {
        JTextField textField = new JTextField("Please enter amount to convert");
        JFrame frame = new JFrame("Currency Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5, 5));
        frame.add(textField, BorderLayout.NORTH);
        ButtonGroup buttonGroup = new ButtonGroup();
        JButton button1 = new JButton("USD to EUR");
        JButton button2 = new JButton("EUR to USD");
        JButton button3 = new JButton("Cancel");
        buttonGroup.add(button1);
        buttonGroup.add(button2);
        buttonGroup.add(button3);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setSize(400, 100);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new CurrencyCalculator();
    }

}
