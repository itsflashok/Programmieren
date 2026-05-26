package programmieren.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class CurrencyCalculator implements ActionListener {
    private static final double FACTOR = 1.09;
    private JTextField textField;
    private JButton button1, button2, button3;

    public CurrencyCalculator() {
        textField = new JTextField();
        textField.setToolTipText("Enter the amount to convert");
        JFrame frame = new JFrame("Currency Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5, 5));
        frame.add(textField, BorderLayout.NORTH);
        ButtonGroup buttonGroup = new ButtonGroup();
        button1 = new JButton("USD to EUR");
        button2 = new JButton("EUR to USD");
        button3 = new JButton("Cancel");
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button3) {
            System.exit(0);
        }
        try {
            double value = Double.parseDouble(textField.getText());
            if (e.getSource() == button2) {
                value *= FACTOR;
            } else if (e.getSource() == button1) {
                value /= FACTOR;
            }
            textField.setText(String.valueOf(value));
        } catch (NumberFormatException ex) {
            textField.setText("Error: please enter a valid number!");
        }
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
