package programmieren.ui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class EditorSimple {
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

    public EditorSimple() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
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

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EditorSimple();
    }

}
