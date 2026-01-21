package src.programmieren.datatypes;

import java.util.Scanner;

public class AddUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mode = "";
        while (!(mode.equalsIgnoreCase("While") || mode.equalsIgnoreCase("DoWhile"))) {
            System.out.print("While or DoWhile? ");
            mode = scanner.nextLine();
        }
        if (mode.equalsIgnoreCase("While")) {
            System.out.println("Summe: " + whileAddUp());
        } else if (mode.equalsIgnoreCase("DoWhile")) {
            System.out.println("Summe: " + doWhileAddUp());
        }
        scanner.close();
    }

    public static int whileAddUp() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        int sum = 0;
        while (number >= 0) {
            System.out.print("Zahl eingeben (<0 für Abbruch): ");
            number = scanner.nextInt();
            if (number >= 0) {
                sum += number;
            }
        }
        scanner.close();
        return sum;
    }

    public static int doWhileAddUp() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        int sum = 0;
        do {
            System.out.print("Zahl eingeben (<0 für Abbruch): ");
            number = scanner.nextInt();
            if (number >= 0) {
                sum += number;
            }
        } while (number >= 0);
        scanner.close();
        return sum;
    }
}
