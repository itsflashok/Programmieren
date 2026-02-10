package programmieren.classes3;

public class Nimmspiel {
    private String player1;
    private String player2;
    private int haufen1;
    private int haufen2;
    private String currentPlayer;

    // Konstruktor erhält Namen der beiden Spieler
    public Nimmspiel(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1; // Spieler 1 beginnt

        // Anzahl der Kugeln wird zufällig erzeugt (zwischen 1 und 10)
        this.haufen1 = (int) (Math.random() * 10) + 1;
        this.haufen2 = (int) (Math.random() * 10) + 1;
    }

    // toString für Ausgabe des Spielstands
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== Aktueller Spielstand ===\n");
        sb.append(String.format("Haufen 1: %d Kugeln\n", this.haufen1));
        sb.append(String.format("Haufen 2: %d Kugeln\n", this.haufen2));
        sb.append(String.format("Nächster Spieler: %s\n", this.currentPlayer));
        return sb.toString();
    }

    // Überprüfen ob alle Kugeln entfernt sind
    public boolean istSpielZuEnde() {
        return (this.haufen1 == 0 && this.haufen2 == 0);
    }

    // Methode für einen Spielzug
    public boolean spielzug(int haufenNummer, int anzahlKugeln) {
        // Validierung der Eingabe
        if (haufenNummer != 1 && haufenNummer != 2) {
            System.out.println("Fehler: Bitte Haufen 1 oder 2 wählen!");
            return false;
        }

        int aktuellerHaufen = (haufenNummer == 1) ? this.haufen1 : this.haufen2;

        if (aktuellerHaufen == 0) {
            System.out.println("Fehler: Dieser Haufen ist leer!");
            return false;
        }

        if (anzahlKugeln <= 0) {
            System.out.println("Fehler: Du musst mindestens 1 Kugel nehmen!");
            return false;
        }

        if (anzahlKugeln > aktuellerHaufen) {
            System.out.println("Fehler: Nicht genug Kugeln auf diesem Haufen!");
            return false;
        }

        // Spielzug ausführen
        if (haufenNummer == 1) {
            this.haufen1 -= anzahlKugeln;
        } else {
            this.haufen2 -= anzahlKugeln;
        }

        System.out.printf("%s nimmt von Haufen %d %d Kugel(n).\n",
                this.currentPlayer, haufenNummer, anzahlKugeln);

        // Prüfen ob Spiel zu Ende ist
        if (istSpielZuEnde()) {
            System.out.println("\n*** " + this.currentPlayer + " hat gewonnen! ***");
            return true;
        }

        // Nächster Spieler ist dran
        wechselSpieler();
        return true;
    }

    // Hilfsmethode zum Wechseln des Spielers
    private void wechselSpieler() {
        if (this.currentPlayer.equals(this.player1)) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = this.player1;
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Namen der beiden Spieler eingeben
        System.out.print("Name von Spieler 1: ");
        String spieler1 = scanner.nextLine();
        System.out.print("Name von Spieler 2: ");
        String spieler2 = scanner.nextLine();

        // Spiel erstellen
        Nimmspiel game = new Nimmspiel(spieler1, spieler2);
        System.out.println(game);

        // Spielschleife
        while (!game.istSpielZuEnde()) {
            System.out.print(game.currentPlayer + ", von welchem Haufen möchtest du Kugeln nehmen? (1 oder 2): ");
            int haufenNummer = scanner.nextInt();

            System.out.print(game.currentPlayer + ", wie viele Kugeln möchtest du nehmen? ");
            int anzahlKugeln = scanner.nextInt();
            scanner.nextLine(); // consume newline

            // Spielzug ausführen (bei Fehler wiederholen)
            boolean erfolgreich = game.spielzug(haufenNummer, anzahlKugeln);

            if (erfolgreich && !game.istSpielZuEnde()) {
                System.out.println(game);
            }
        }

        scanner.close();
    }
}
