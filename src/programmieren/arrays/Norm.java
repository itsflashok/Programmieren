package programmieren.arrays;

import java.util.Scanner;

public class Norm {
    public static void main(String[] args) {
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.format("Bitte x_%d eingeben: ", i);
            numbers[i] = scanner.nextInt();
        }
        scanner.close();
        double norm = countNorm(numbers);
        System.out.format("Der Betrag von x ist: %f \n", norm);
    }

    public static double countNorm(int[] numbers) {
        double countedNorm = 0;
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i] * numbers[i];
        }
        countedNorm = Math.sqrt(sum);
        return countedNorm;

    }
}