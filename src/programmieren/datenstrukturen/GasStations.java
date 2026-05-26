package programmieren.datenstrukturen;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GasStations {

    private TreeMap<String, GasPrices> stations = new TreeMap<>();

    private JTextField tfName   = new JTextField();
    private JTextField tfDiesel = new JTextField();
    private JTextField tfE5     = new JTextField();
    private JTextField tfE10    = new JTextField();

    public GasStations() {
        JFrame frame = new JFrame("Gas Stations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5, 5));

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        inputPanel.add(new JLabel("Station Name"));
        inputPanel.add(tfName);
        inputPanel.add(new JLabel("Diesel"));
        inputPanel.add(tfDiesel);
        inputPanel.add(new JLabel("Super E5"));
        inputPanel.add(tfE5);
        inputPanel.add(new JLabel("Super E10"));
        inputPanel.add(tfE10);
        frame.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        JButton btnSave    = new JButton("Save");
        JButton btnShowAll = new JButton("Show all");
        btnSave.addActionListener(e -> save());
        btnShowAll.addActionListener(e -> showAll());
        buttonPanel.add(btnSave);
        buttonPanel.add(btnShowAll);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void save() {
        String name = tfName.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please provide a station name");
            return;
        }

        double diesel = parsePrice(tfDiesel.getText());
        double e5     = parsePrice(tfE5.getText());
        double e10    = parsePrice(tfE10.getText());

        GasPrices prices = new GasPrices(diesel, e5, e10);
        stations.put(name, prices);

        JOptionPane.showMessageDialog(null, "Saved: " + name + " (" + prices + ")");

        tfName.setText("");
        tfDiesel.setText("");
        tfE5.setText("");
        tfE10.setText("");
    }

    private void showAll() {
        if (stations.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No stations saved yet.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (var entry : stations.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString().trim());
    }

    private double parsePrice(String text) {
        try {
            return Double.parseDouble(text.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        new GasStations();
    }
}
