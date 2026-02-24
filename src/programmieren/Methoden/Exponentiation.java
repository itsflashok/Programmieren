package programmieren.Methoden;

import java.util.Scanner;

public class Exponentiation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte Basis eingeben: ");
        double x = scanner.nextDouble();
        System.out.print("Bitte Exponent eingeben: ");
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(x + " hoch " + n + " ist: " + xPowerN(x, n));
    }

    public static double xPowerN(double x, int n) {
        return (n == 0) ? 1 : x * Math.pow(x, n - 1);
    }
}
