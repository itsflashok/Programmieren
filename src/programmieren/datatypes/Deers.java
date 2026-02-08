package programmieren.datatypes;

public class Deers {
    public static void main(String[] args) {
        int bestand = 200;
        int jahr = 0;

        System.out.println("Jahr " + jahr + ": " + bestand + " Hirsche");

        while (bestand < 300) {
            jahr++;
            // 10% Vermehrung
            bestand = (int) (bestand * 1.1);
            // 15 Hirsche zum Abschuss
            bestand -= 15;

            System.out.println("Jahr " + jahr + ": " + bestand + " Hirsche");
        }
    }
}
