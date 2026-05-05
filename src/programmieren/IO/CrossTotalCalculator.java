package programmieren.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CrossTotalCalculator {
    static String path = "src/programmieren/IO/";

    public static void main(String[] args) {
        createDirectory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Zahl für Quersumme eingeben: ");
        String zahl = scanner.nextLine();
        int quersumme = berechneQuersumme(zahl);
        writeInFile(zahl, quersumme);
        System.out.println("Die Quersumme von " + zahl + " ist: " + quersumme);
    }

    public static void createDirectory() {
        File directory = new File(path + "CrossTotalData");
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public static void writeInFile(String zahl, int quersumme) {
        File file = new File(String.format("%s/CrossTotalData/crosstotals.txt", path));

        try {
            file.createNewFile();
            System.out.println("Created file: " + file.getName());
        } catch (Exception e) {
            System.out.println("Error creating file: " + e.getMessage());
        }

        try {
            FileWriter writer = new FileWriter(String.format("%s/CrossTotalData/crosstotals.txt", path), true);
            writer.write("Die Quersumme von " + zahl + " ist: " + quersumme + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int berechneQuersumme(String number) {
        int quersumme = 0;
        for (String i : number.split("")) {
            quersumme += (i.charAt(0) - '0');
        }
        return quersumme;
    }
}
