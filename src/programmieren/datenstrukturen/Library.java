package programmieren.datenstrukturen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Library {
    private static final String FILE_PATH = "src/programmieren/datenstrukturen/library.txt";
    private Set<Book> books = new LinkedHashSet<>();

    private JTextField authorField;
    private JTextField titleField;
    private JTextField yearField;
    private JTextField publisherField;

    public Library() {
        loadBooks();

        JFrame frame = new JFrame("Bibliothek");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Neues Buch"));

        inputPanel.add(new JLabel("Autor:"));
        authorField = new JTextField();
        inputPanel.add(authorField);

        inputPanel.add(new JLabel("Titel:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Erscheinungsjahr:"));
        yearField = new JTextField();
        inputPanel.add(yearField);

        inputPanel.add(new JLabel("Verlag:"));
        publisherField = new JTextField();
        inputPanel.add(publisherField);

        frame.add(inputPanel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JButton saveButton = new JButton("Speichern");
        saveButton.addActionListener(e -> saveBook());
        buttonPanel.add(saveButton);

        JButton sortAuthorButton = new JButton("Sortiert nach Autor");
        sortAuthorButton
                .addActionListener(e -> showSorted(Comparator.comparing(Book::getAuthor), "Sortiert nach Autor"));
        buttonPanel.add(sortAuthorButton);

        JButton sortTitleButton = new JButton("Sortiert nach Titel");
        sortTitleButton.addActionListener(e -> showSorted(Comparator.comparing(Book::getTitle), "Sortiert nach Titel"));
        buttonPanel.add(sortTitleButton);

        JButton sortYearButton = new JButton("Sortiert nach Jahr");
        sortYearButton.addActionListener(
                e -> showSorted(Comparator.comparingInt(Book::getYear), "Sortiert nach Erscheinungsjahr"));
        buttonPanel.add(sortYearButton);

        JButton sortPublisherButton = new JButton("Sortiert nach Verlag");
        sortPublisherButton
                .addActionListener(e -> showSorted(Comparator.comparing(Book::getPublisher), "Sortiert nach Verlag"));
        buttonPanel.add(sortPublisherButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void loadBooks() {
        File file = new File(FILE_PATH);
        if (!file.exists())
            return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    String author = parts[0].trim();
                    String title = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());
                    String publisher = parts[3].trim();
                    books.add(new Book(author, title, year, publisher));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }

    private void saveBook() {
        String author = authorField.getText().trim();
        String title = titleField.getText().trim();
        String yearText = yearField.getText().trim();
        String publisher = publisherField.getText().trim();

        if (author.isEmpty() || title.isEmpty() || yearText.isEmpty() || publisher.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bitte alle Felder ausfuellen!");
            return;
        }

        int year;
        try {
            year = Integer.parseInt(yearText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erscheinungsjahr muss eine Zahl sein!");
            return;
        }

        Book book = new Book(author, title, year, publisher);

        if (books.contains(book)) {
            JOptionPane.showMessageDialog(null, "Dieses Buch existiert bereits!");
            return;
        }

        books.add(book);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(book.toFileString());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Schreiben der Datei: " + e.getMessage());
        }

        authorField.setText("");
        titleField.setText("");
        yearField.setText("");
        publisherField.setText("");

        JOptionPane.showMessageDialog(null, "Buch gespeichert!");
    }

    private void showSorted(Comparator<Book> comparator, String windowTitle) {
        List<Book> sorted = new ArrayList<>(books);
        sorted.sort(comparator);

        StringBuilder sb = new StringBuilder();
        for (Book b : sorted) {
            sb.append(b.toString()).append("\n");
        }

        JFrame popup = new JFrame(windowTitle);
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        popup.add(new JScrollPane(textArea));
        popup.setSize(500, 400);
        popup.setLocationRelativeTo(null);
        popup.setVisible(true);
    }

    public static void main(String[] args) {
        new Library();
    }
}
