package src.programmieren.datatypes;

import java.util.Scanner;

public class Easter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie ein Jahr ein: ");
        int year = scanner.nextInt();
        scanner.close();
        System.out.println(calculateEaster(year));
    }

    public static String calculateEaster(int year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = year / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int m = (15 + k - p - q) % 30;
        int n = (4 + k - q) % 7;
        int d = (19 * a + m) % 30;
        int e = (2 * b + 4 * c + 6 * d + n) % 7;
        int ostern = (22 + d + e);
        if (ostern > 31) {
            return "Ostern im Jahr " + year + " ist am " + (ostern - 31) + ". April.";
        } else {
            return "Ostern im Jahr " + year + " ist am " + (int)ostern + ". März.";
        }
    }
}
