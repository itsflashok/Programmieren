package programmieren.ui;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextfileViewer {

    public static void showWithLabels(File file) {
        List<String> lines = readLines(file);
        int count = Math.min(lines.size(), 10);

        JFrame frame = new JFrame("TextfileViewer (Labels) - " + file.getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(count, 1));

        for (int i = 0; i < count; i++) {
            frame.add(new JLabel(lines.get(i)));
        }

        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    public static void showWithTextArea(File file) {
        List<String> lines = readLines(file);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        for (String line : lines) {
            textArea.append(line + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);

        JFrame frame = new JFrame("TextfileViewer (TextArea) - " + file.getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private static List<String> readLines(File file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            showWithLabels(selectedFile);

            showWithTextArea(selectedFile);
        }
    }
}
