package programmieren.ui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ComponentFrame extends JFrame {
    JPanel panel = new JPanel();

    JLabel label = new JLabel("JLabel: ");
    JTextField textField = new JTextField(8);
    JPasswordField passwordField = new JPasswordField(8);
    JButton button = new JButton("JButton: ");
    JToggleButton toggleButton = new JToggleButton("JToggleButton: ");
    JCheckBox checkBox = new JCheckBox("JCheckBox: ");
    JComboBox<String> comboBox = new JComboBox<>();
    ButtonGroup radioButtonGroup = new ButtonGroup();
    JRadioButton radioButton1 = new JRadioButton("JRadioButton 1: ");
    JRadioButton radioButton2 = new JRadioButton("JRadioButton 2: ");
    JRadioButton radioButton3 = new JRadioButton("JRadioButton 3: ");

    public ComponentFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        add(panel);

        panel.add(label);
        panel.add(textField);
        panel.add(passwordField);
        panel.add(button);
        panel.add(toggleButton);
        panel.add(checkBox);
        panel.add(comboBox);
        comboBox.addItem("Option 1");
        comboBox.addItem("Option 2");
        comboBox.addItem("Option 3");
        button.setToolTipText("Please click me");

        radioButtonGroup.add(radioButton1);
        radioButtonGroup.add(radioButton2);
        radioButtonGroup.add(radioButton3);

        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ComponentFrame();
    }

}
