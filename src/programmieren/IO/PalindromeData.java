package programmieren.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PalindromeData {
    static String path = "src/programmieren/IO/";
    static String fileName = "PalindromeData/palindromes.txt";

    public static void main(String[] args) {
        createDirectory();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte Wort eingeben: ");
        String wort = scanner.nextLine();
        scanner.close();

        String umgekehrt = palindrome(wort);
        System.out.println("Umgekehrt: " + umgekehrt);

        if (wort.toLowerCase().equals(umgekehrt.toLowerCase())) {
            System.out.println(wort + " ist ein Palindrom.");
            writeToFile(wort);
        } else {
            System.out.println(wort + " ist kein Palindrom.");
        }

        printAllPalindromes();
    }

    public static void createDirectory() {
        File directory = new File(path + "PalindromeData");
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public static void writeToFile(String palindrome) {
        try {
            FileWriter writer = new FileWriter(path + fileName, true);
            writer.write(palindrome + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printAllPalindromes() {
        File file = new File(path + fileName);
        if (!file.exists()) {
            return;
        }

        System.out.println("Alle bisher gefundenen Palindrome:");
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String palindrome(String wort) {
        String umgekehrt = "";
        for (String i : wort.split("")) {
            umgekehrt = i + umgekehrt;
        }
        return umgekehrt;
    }
}
