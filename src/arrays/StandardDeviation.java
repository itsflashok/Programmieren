package src.arrays;

import java.util.Scanner;

public class StandardDeviation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        double[] randomArray = new double[n];
        for (int i = 0; i < n; i++) {
            randomArray[i] = Math.random() * 10;
        }
        double average = countAverage(randomArray);
        double deviation = countDeviation(randomArray, average);
        System.out.format("Mittelwert: %.2f \n", average);
        System.out.println("Standardabweichung: " + deviation);
    }

    public static double countAverage(double[] array) {
        int n = array.length;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
        }
        double average = sum / n;
        return average;
    }

    public static double countDeviation(double[] array, double average) {
        int n = array.length;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.pow((array[i] - average), 2);
        }
        double deviation = Math.sqrt(sum / (n - 1));
        return deviation;
    }
}
