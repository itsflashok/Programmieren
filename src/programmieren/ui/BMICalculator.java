package programmieren.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class BMICalculator implements ActionListener {

    private JTextField weightField;
    private JTextField heightField;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JLabel resultLabel;
    private JButton calculateButton;
    private JButton resetButton;

    public BMICalculator() {
        weightField = new JTextField(10);
        heightField = new JTextField(10);
        maleButton = new JRadioButton("Male", true);
        femaleButton = new JRadioButton("Female");
        resultLabel = new JLabel("Enter your data and press Calculate.");
        calculateButton = new JButton("Calculate");
        resetButton = new JButton("Reset");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        calculateButton.addActionListener(this);
        resetButton.addActionListener(this);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        inputPanel.add(new JLabel("Weight (kg):"));
        inputPanel.add(weightField);
        inputPanel.add(new JLabel("Height (cm):"));
        inputPanel.add(heightField);
        inputPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new GridLayout(1, 2));
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        inputPanel.add(genderPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);
        buttonPanel.add(resetButton);

        JPanel resultPanel = new JPanel();
        resultPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        resultPanel.add(resultLabel);

        JFrame frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5, 5));
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resultPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            weightField.setText("");
            heightField.setText("");
            maleButton.setSelected(true);
            resultLabel.setText("Enter your data and press Calculate.");
            return;
        }
        try {
            double weight = Double.parseDouble(weightField.getText().trim());
            double heightCm = Double.parseDouble(heightField.getText().trim());

            if (weight <= 0 || heightCm <= 0) {
                resultLabel.setText("Error: weight and height must be positive.");
                return;
            }

            double height = heightCm / 100.0;
            double bmi = weight / (height * height);
            boolean isMale = maleButton.isSelected();
            String classification = classify(bmi, isMale);

            resultLabel.setText(String.format("BMI: %.2f  —  %s", bmi, classification));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Error: please enter valid numbers.");
        }
    }

    private String classify(double bmi, boolean isMale) {
        if (isMale) {
            if (bmi < 20)  return "Underweight (Short weight)";
            if (bmi <= 25) return "Normal weight";
            if (bmi <= 30) return "Overweight";
            if (bmi <= 40) return "Adiposity";
            return "Massive Adiposity";
        } else {
            if (bmi < 19)  return "Underweight (Short weight)";
            if (bmi <= 24) return "Normal weight";
            if (bmi <= 30) return "Overweight";
            if (bmi <= 40) return "Adiposity";
            return "Massive Adiposity";
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new BMICalculator();
    }
}
