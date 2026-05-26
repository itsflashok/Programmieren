package programmieren.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ShellGame implements ActionListener {
    JButton button1 = new JButton("Shell 1");
    JButton button2 = new JButton("Shell 2");
    JButton button3 = new JButton("Shell 3");
    JButton buttonStart = new JButton("New Game");
    JButton buttonStatistics = new JButton("Statistics");
    JButton buttonExit = new JButton("Exit");
    JTextField textFieldOutput = new JTextField();

    int ballPosition;
    boolean gameActive = false;
    int wins = 0;
    int losses = 0;

    public ShellGame() {
        JFrame frame = new JFrame("Shell Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 220);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel shellPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        button1.setFont(new Font("Monospaced", Font.BOLD, 16));
        button2.setFont(new Font("Monospaced", Font.BOLD, 16));
        button3.setFont(new Font("Monospaced", Font.BOLD, 16));
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        shellPanel.add(button1);
        shellPanel.add(button2);
        shellPanel.add(button3);
        shellPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        textFieldOutput.setEditable(false);
        textFieldOutput.setHorizontalAlignment(JTextField.CENTER);
        textFieldOutput.setFont(new Font("Arial", Font.PLAIN, 14));
        textFieldOutput.setText("Click 'New Game' to start!");
        textFieldOutput.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));

        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.add(buttonStart);
        controlPanel.add(buttonStatistics);
        controlPanel.add(buttonExit);

        frame.add(textFieldOutput, BorderLayout.NORTH);
        frame.add(shellPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        buttonStart.addActionListener(this);
        buttonStatistics.addActionListener(this);
        buttonExit.addActionListener(this);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    void startNewGame() {
        ballPosition = (int) (Math.random() * 3) + 1;
        gameActive = false;
        buttonStart.setEnabled(false);
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);

        button1.setText(ballPosition == 1 ? "( O )" : "(   )");
        button2.setText(ballPosition == 2 ? "( O )" : "(   )");
        button3.setText(ballPosition == 3 ? "( O )" : "(   )");
        textFieldOutput.setText("Remember where the ball is...");

        Timer timer = new Timer(2000, e -> {
            button1.setText("Shell 1");
            button2.setText("Shell 2");
            button3.setText("Shell 3");
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            buttonStart.setEnabled(true);
            gameActive = true;
            textFieldOutput.setText("Which shell hides the ball?");
        });
        timer.setRepeats(false);
        timer.start();
    }

    void checkGuess(int guess) {
        if (!gameActive) return;
        gameActive = false;
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);

        button1.setText(ballPosition == 1 ? "( O )" : "(   )");
        button2.setText(ballPosition == 2 ? "( O )" : "(   )");
        button3.setText(ballPosition == 3 ? "( O )" : "(   )");

        if (guess == ballPosition) {
            wins++;
            textFieldOutput.setText("Correct! You found the ball!  |  Wins: " + wins + "  Losses: " + losses);
        } else {
            losses++;
            textFieldOutput.setText("Wrong! Ball was under Shell " + ballPosition + "  |  Wins: " + wins + "  Losses: " + losses);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == buttonStart) {
            startNewGame();
        } else if (src == button1) {
            checkGuess(1);
        } else if (src == button2) {
            checkGuess(2);
        } else if (src == button3) {
            checkGuess(3);
        } else if (src == buttonStatistics) {
            JOptionPane.showMessageDialog(null,
                    "Wins:   " + wins + "\nLosses: " + losses + "\nTotal:  " + (wins + losses),
                    "Statistics", JOptionPane.INFORMATION_MESSAGE);
        } else if (src == buttonExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShellGame());
    }
}
