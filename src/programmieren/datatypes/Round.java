package src.programmieren.datatypes;

import java.util.Scanner;

public class Round {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Geben Sie eine Kommazahl ein: ");
            double userInput = scanner.nextDouble();
            scanner.close();
            System.out.println("Pi gerundet: " + roundIt(userInput));

    }

    public static int roundIt(double value) {
        int plusMinus = value >= 0 ? +1 : -1;
        int intValue = Math.abs((int) value);
        double fractionalPart = value - intValue;
        if (Math.abs(fractionalPart) > 0.5) {
            return plusMinus * (intValue + 1);
        } else {
            return plusMinus * intValue;
        }

    }
}
