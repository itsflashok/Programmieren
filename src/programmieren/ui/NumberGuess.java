package programmieren.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class NumberGuess implements ActionListener {
    JTextField textFieldName = new JTextField(10);
    JTextField textFieldNumber = new JTextField(10);
    JButton buttonStart = new JButton("New Game");
    JButton buttonGuess = new JButton("OK");
    JButton buttonBestPlayer = new JButton("Best Player");
    JButton buttonExit = new JButton("Exit");
    JTextField textFieldOutput = new JTextField();
    static String path = "src/programmieren/ui/";

    int randomValue = 0;
    int counter = 0;
    boolean gameActive = false;

    public NumberGuess() {
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5, 5));

        textFieldName.setToolTipText("Enter your name");
        textFieldNumber.setToolTipText("Enter number between 1 and 1000");

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(textFieldName);
        inputPanel.add(textFieldNumber);
        frame.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonGuess);
        buttonPanel.add(buttonBestPlayer);
        buttonPanel.add(buttonExit);
        buttonStart.addActionListener(this);
        buttonGuess.addActionListener(this);
        buttonBestPlayer.addActionListener(this);
        buttonExit.addActionListener(this);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(textFieldOutput, BorderLayout.SOUTH);

        frame.setSize(520, 130);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonExit) {
            System.exit(0);
        }
        if (e.getSource() == buttonStart) {
            randomValue = (int) (Math.random() * 1000) + 1;
            counter = 0;
            gameActive = true;
            textFieldNumber.setText("");
            textFieldOutput.setText("Game started! Guess a number between 1 and 1000.");
        }
        if (e.getSource() == buttonGuess) {
            if (!gameActive) {
                textFieldOutput.setText("Press 'New Game' to start!");
                return;
            }
            try {
                int value = Integer.parseInt(textFieldNumber.getText().trim());
                counter++;
                if (value < randomValue) {
                    textFieldOutput.setText("Attempt #" + counter + ": Too low! Try again.");
                } else if (value > randomValue) {
                    textFieldOutput.setText("Attempt #" + counter + ": Too high! Try again.");
                } else {
                    textFieldOutput.setText("Congratulations " + textFieldName.getText()
                            + "! You guessed it in " + counter + " attempts!");
                    writeInFile(textFieldName.getText(), counter, randomValue);
                    gameActive = false;
                }
                textFieldNumber.setText("");
            } catch (NumberFormatException ex) {
                textFieldOutput.setText("Error: please enter a valid number!");
            }
        }
        if (e.getSource() == buttonBestPlayer) {
            try {
                File file = new File(path + "NumberGuessData/results.txt");
                if (!file.exists()) {
                    textFieldOutput.setText("No games played yet.");
                    return;
                }
                Scanner scanner = new Scanner(file);
                String bestPlayer = "";
                int bestAttempts = Integer.MAX_VALUE;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    String playerName = parts[0].split(":")[1].trim();
                    int attempts = Integer.parseInt(parts[1].split(":")[1].trim());
                    if (attempts < bestAttempts) {
                        bestAttempts = attempts;
                        bestPlayer = playerName;
                    }
                }
                scanner.close();
                textFieldOutput.setText("Best Player: " + bestPlayer + " with " + bestAttempts + " attempts");
            } catch (IOException ex) {
                textFieldOutput.setText("Error reading results file.");
            }
        }
    }

    public static void createDirectory() {
        File directory = new File(path + "NumberGuessData");
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public static void writeInFile(String name, int attempts, int value) {
        createDirectory();
        try {
            FileWriter writer = new FileWriter(path + "NumberGuessData/results.txt", true);
            writer.write("Player: " + name + ", Attempts: " + attempts + ", Value: " + value + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new NumberGuess();
    }
}
