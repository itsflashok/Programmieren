package src.programmieren.datatypes;

import java.util.Scanner;

public class Quadratics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie a ein: ");
        double a = scanner.nextDouble();
        System.out.print("Geben Sie b ein: ");
        double b = scanner.nextDouble();
        System.out.print("Geben Sie c ein: ");
        double c = scanner.nextDouble();
        scanner.close();
        double[] answers = calculateQuadraticRoots(a, b, c);
        if ((answers.length) > 0) {
            for (int answer = 0; answer < answers.length; answer++) {
                System.out.println(answers[answer]);
            }
        }

    }

    public static double[] calculateQuadraticRoots(double a, double b, double c) {
        double[] roots = new double[2];
        if (a == 0) {
            if (b == 0) {
                System.out.println("Die Gleichung ist degeneriert.");
            } else {
                roots[0] = -c / b;
            }
        } else {
            double discriminant = Math.pow(b, 2) - (4 * a * c);
            if (discriminant >= 0) {
                roots[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
                roots[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
            } else {
                System.out.println("Die Gleichung ist konjugiert komplex.");
                return roots;
            }
        }
        return roots;
    }
}
