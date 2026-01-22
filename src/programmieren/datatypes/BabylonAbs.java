package src.programmieren.datatypes;

import java.util.Scanner;

public class BabylonAbs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wurzel aus welcher Zahl ziehen? ");
        double input = scanner.nextDouble();
        scanner.close();
        double abs = babylonAbs(input);
        System.out.format("Die Wurzel aus %f ist %f", input, abs);
    }

    public static double babylonAbs(double number) {
        double xCurrent = 1.0;
        double xNext = 0.0;
        double diff = 0.0;
        do {
            xNext = 0.5 * (xCurrent + (number / xCurrent));
            System.out.println("xn: " + xCurrent);
            diff = Math.abs(xNext - xCurrent);
            xCurrent = xNext;
        } while (diff >= (1e-6));

        return xCurrent;
    }
}
