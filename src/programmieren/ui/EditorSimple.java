package programmieren.ui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class EditorSimple implements ActionListener {
    JFrame frame = new JFrame("Editor");
    JMenu menuDatei = new JMenu("Datei");
    JMenu menuBearbeiten = new JMenu("Bearbeiten");

    // Datei-Menü
    JMenuItem menuItemNeu = new JMenuItem("Neu");
    JMenuItem menuItemOeffnen = new JMenuItem("Öffnen");
    JMenuItem menuItemSchliessen = new JMenuItem("Schließen");
    JMenuItem menuItemSpeichern = new JMenuItem("Speichern");
    JMenuItem menuItemSpeichernUnter = new JMenuItem("Speichern unter...");
    JMenuItem menuItemAlsWebseiteSpeichern = new JMenuItem("Als Webseite speichern");
    JMenuItem menuItemSuchen = new JMenuItem("Suchen");
    JMenuItem menuItemVersionen = new JMenuItem("Versionen");
    JMenuItem menuItemWebseitenvorschau = new JMenuItem("Webseitenvorschau");
    JMenuItem menuItemSeiteEinrichten = new JMenuItem("Seite einrichten...");
    JMenuItem menuItemSeitenansicht = new JMenuItem("Seitenansicht");
    JMenuItem menuItemDrucken = new JMenuItem("Drucken");
    JMenu menuSendenAn = new JMenu("Senden an");
    JMenuItem menuItemEmailEmpfaenger = new JMenuItem("E-Mail-Empfänger");
    JMenuItem menuItemEmailEmpfaengerUeberarbeitung = new JMenuItem("E-Mail-Empfänger (zur Überarbeitung)");
    JMenuItem menuItemEmailEmpfaengerAnlage = new JMenuItem("E-Mail-Empfänger (als Anlage)");
    JMenuItem menuItemVerteilerempfaenger = new JMenuItem("Verteilerempfänger...");
    JMenuItem menuItemOnlinebesprechungsteilnehmer = new JMenuItem("Onlinebesprechungsteilnehmer");
    JMenuItem menuItemExchangeOrdner = new JMenuItem("Exchange-Ordner...");
    JMenuItem menuItemFaxEmpfaenger = new JMenuItem("Fax-Empfänger...");
    JMenuItem menuItemMicrosoftPowerPoint = new JMenuItem("Microsoft PowerPoint");
    JMenuItem menuItemEigenschaften = new JMenuItem("Eigenschaften");
    JMenuItem menuItemBilanz = new JMenuItem("bilanz_2017.doc");
    JMenuItem menuItemBericht = new JMenuItem("bericht_2018_01.doc");
    JMenuItem menuItemZiele = new JMenuItem("ziele.doc");
    JMenuItem menuItemBeenden = new JMenuItem("Beenden");

    // Bearbeiten-Menü
    JMenuItem menuItemRueckgaengig = new JMenuItem("Rückgängig");
    JMenuItem menuItemWiederholen = new JMenuItem("Wiederholen");
    JMenuItem menuItemAusschneiden = new JMenuItem("Ausschneiden");
    JMenuItem menuItemKopieren = new JMenuItem("Kopieren");
    JMenuItem menuItemOfficeZwischenablage = new JMenuItem("Office-Zwischenablage");
    JMenuItem menuItemEinfuegen = new JMenuItem("Einfügen");
    JMenuItem menuItemInhalteEinfuegen = new JMenuItem("Inhalte einfügen");
    JMenuItem menuItemAlsHyperlinkEinfuegen = new JMenuItem("Als Hyperlink einfügen");
    JMenuItem menuItemLoeschen = new JMenuItem("Löschen");
    JMenuItem menuItemAllesMarkieren = new JMenuItem("Alles markieren");
    JMenuItem menuItemSuchenBearbeiten = new JMenuItem("Suchen...");
    JMenuItem menuItemErsetzen = new JMenuItem("Ersetzen...");
    JMenuItem menuItemGeheZu = new JMenuItem("Gehe zu...");
    JMenuItem menuItemVerknuepfungen = new JMenuItem("Verknüpfungen...");
    JMenuItem menuItemObjekt = new JMenuItem("Objekt");

    JTextPane editPane = new JTextPane();
    JScrollPane scrollPane = new JScrollPane(editPane);
    File currentFile = null;

    public EditorSimple() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setLayout(new BorderLayout());

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menuDatei);
        menuBar.add(menuBearbeiten);
        frame.setJMenuBar(menuBar);

        // Datei-Menü aufbauen
        menuDatei.add(menuItemNeu);
        menuDatei.add(menuItemOeffnen);
        menuDatei.addSeparator();
        menuDatei.add(menuItemSchliessen);
        menuDatei.addSeparator();
        menuDatei.add(menuItemSpeichern);
        menuDatei.addSeparator();
        menuDatei.add(menuItemSpeichernUnter);
        menuDatei.add(menuItemAlsWebseiteSpeichern);
        menuDatei.add(menuItemSuchen);
        menuDatei.addSeparator();
        menuDatei.add(menuItemVersionen);
        menuDatei.addSeparator();
        menuDatei.add(menuItemWebseitenvorschau);
        menuDatei.addSeparator();
        menuDatei.add(menuItemSeiteEinrichten);
        menuDatei.add(menuItemSeitenansicht);
        menuDatei.add(menuItemDrucken);
        menuDatei.addSeparator();
        menuDatei.add(menuSendenAn);
        menuSendenAn.add(menuItemEmailEmpfaenger);
        menuSendenAn.add(menuItemEmailEmpfaengerUeberarbeitung);
        menuSendenAn.add(menuItemEmailEmpfaengerAnlage);
        menuSendenAn.add(menuItemVerteilerempfaenger);
        menuSendenAn.add(menuItemOnlinebesprechungsteilnehmer);
        menuSendenAn.add(menuItemExchangeOrdner);
        menuSendenAn.add(menuItemFaxEmpfaenger);
        menuSendenAn.add(menuItemMicrosoftPowerPoint);
        menuDatei.add(menuItemEigenschaften);
        menuDatei.addSeparator();
        menuDatei.add(menuItemBilanz);
        menuDatei.add(menuItemBericht);
        menuDatei.add(menuItemZiele);
        menuDatei.addSeparator();
        menuDatei.add(menuItemBeenden);

        // Bearbeiten-Menü aufbauen
        menuBearbeiten.add(menuItemRueckgaengig);
        menuBearbeiten.add(menuItemWiederholen);
        menuBearbeiten.addSeparator();
        menuBearbeiten.add(menuItemAusschneiden);
        menuBearbeiten.add(menuItemKopieren);
        menuBearbeiten.add(menuItemOfficeZwischenablage);
        menuBearbeiten.add(menuItemEinfuegen);
        menuBearbeiten.add(menuItemInhalteEinfuegen);
        menuBearbeiten.add(menuItemAlsHyperlinkEinfuegen);
        menuBearbeiten.addSeparator();
        menuBearbeiten.add(menuItemLoeschen);
        menuBearbeiten.add(menuItemAllesMarkieren);
        menuBearbeiten.addSeparator();
        menuBearbeiten.add(menuItemSuchenBearbeiten);
        menuBearbeiten.add(menuItemErsetzen);
        menuBearbeiten.add(menuItemGeheZu);
        menuBearbeiten.addSeparator();
        menuBearbeiten.add(menuItemVerknuepfungen);
        menuBearbeiten.add(menuItemObjekt);

        menuItemSpeichern.setEnabled(false);

        menuItemNeu.addActionListener(this);
        menuItemOeffnen.addActionListener(this);
        menuItemSpeichern.addActionListener(this);
        menuItemSpeichernUnter.addActionListener(this);
        menuItemBeenden.addActionListener(this);
        menuItemKopieren.addActionListener(this);
        menuItemAusschneiden.addActionListener(this);
        menuItemEinfuegen.addActionListener(this);
        menuItemAllesMarkieren.addActionListener(this);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EditorSimple();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == menuItemNeu) {
            if (!editPane.getText().isEmpty()) {
                int answer = JOptionPane.showConfirmDialog(frame,
                        "Möchten Sie die aktuelle Datei speichern?", "Neu",
                        JOptionPane.YES_NO_CANCEL_OPTION);
                if (answer == JOptionPane.CANCEL_OPTION) return;
                if (answer == JOptionPane.YES_OPTION && !saveToFile(false)) return;
            }
            editPane.setText("");
            currentFile = null;
            menuItemSpeichern.setEnabled(false);
            frame.setTitle("Editor");
        }

        if (src == menuItemOeffnen) {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                currentFile = chooser.getSelectedFile();
                try (FileReader reader = new FileReader(currentFile)) {
                    StringBuilder sb = new StringBuilder();
                    int c;
                    while ((c = reader.read()) != -1) {
                        sb.append((char) c);
                    }
                    editPane.setText(sb.toString());
                    menuItemSpeichern.setEnabled(true);
                    frame.setTitle("Editor – " + currentFile.getName());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Fehler beim Öffnen: " + ex.getMessage());
                }
            }
        }

        if (src == menuItemSpeichern) {
            saveToFile(false);
        }

        if (src == menuItemSpeichernUnter) {
            saveToFile(true);
        }

        if (src == menuItemBeenden) {
            int answer = JOptionPane.showConfirmDialog(frame,
                    "Programm wirklich beenden?", "Beenden", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

        if (src == menuItemKopieren) {
            copySelectionToClipboard();
        }

        if (src == menuItemAusschneiden) {
            copySelectionToClipboard();
            editPane.replaceSelection("");
        }

        if (src == menuItemEinfuegen) {
            doPaste();
        }

        if (src == menuItemAllesMarkieren) {
            editPane.selectAll();
        }
    }

    /**
     * Copy content to clipboard
     *
     * @param content content to copy
     */
    private boolean saveToFile(boolean saveAs) {
        if (saveAs || currentFile == null) {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(frame) != JFileChooser.APPROVE_OPTION) return false;
            currentFile = chooser.getSelectedFile();
        }
        try (FileWriter writer = new FileWriter(currentFile)) {
            writer.write(editPane.getText());
            menuItemSpeichern.setEnabled(true);
            frame.setTitle("Editor – " + currentFile.getName());
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Fehler beim Speichern: " + ex.getMessage());
            return false;
        }
    }

    public void copySelectionToClipboard() {
        String content = this.editPane.getSelectedText();
        if (content != null) {
            StringSelection selection = new StringSelection(content);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
        }
    }

    /**
     * Paste clipboard content, just inserts at current caret position and ignores
     * selection (text editors usually replace selected text with clipboard content)
     */
    public void doPaste() {
        try {
            String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            if (data != null) {
                this.editPane.getDocument().insertString(this.editPane.getCaretPosition(), data, null);
            }
        } catch (Exception e) {

        }
    }
}
