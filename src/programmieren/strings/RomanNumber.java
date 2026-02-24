package programmieren.strings;

import java.util.Scanner;

public class RomanNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben sie eine röm. Zahl ein: ");
        String romanNumber = scanner.nextLine();
        scanner.close();
        System.out.println("Der Wert der Zahl " + romanNumber + " ist: " + romanToDecimal(romanNumber));
    }

    public static int romanToDecimal(String roman) {
        int result = 0;
        int prevValue = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            int value = romanCharToInt(roman.charAt(i));
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }
        return result;
    }

    private static int romanCharToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Ungültiges römisches Zeichen: " + c);
        }
    }
}