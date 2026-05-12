package programmieren.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextFrame extends JFrame {
    private String text;
    private int width;
    private int height;

    public TextFrame(int height, int width, String titleString) {
        JTextArea textArea = new JTextArea();
        add(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.width = width;
        this.height = height;
        this.text = titleString;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setTitle(titleString);
        setVisible(true);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width, height;
        String title;
        System.out.print("Enter the width of the frame: ");
        try {
            width = scanner.nextInt();
            System.out.print("Enter the height of the frame: ");
            height = scanner.nextInt();
            System.out.print("Enter the title of the frame: ");
            title = scanner.next();
            scanner.close();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid integers for width and height.");
            scanner.close();
            return;
        }
        try {
            new TextFrame(height, width, title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
