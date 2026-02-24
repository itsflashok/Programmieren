package programmieren.strings;

import java.util.Scanner;

public class CrossTotal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Zahl für Quersumme eingeben: ");
        String zahl = scanner.nextLine();
        int quersumme = berechneQuersumme(zahl);
        System.out.println("Die Quersumme von " + zahl + " ist: " + quersumme);
    }

    public static int berechneQuersumme(String number) {
        int quersumme = 0;
        for (String i : number.split("")) {
            quersumme += (i.charAt(0) - '0');
        }
        return quersumme;
    }
}
