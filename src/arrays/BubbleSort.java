package src.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
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
        int[] sorted = bubbleSort(numbers);
        System.out.println("Sortiert: " + Arrays.toString(sorted));
    }

    public static int[] bubbleSort(int[] numbers) {
        int n = numbers.length;

        for (int j = 0; j < n - 1; j++) {
            // Optimierung: Nach jedem Durchlauf ist das größte Element am Ende
            for (int i = 0; i < n - 1 - j; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    // Swap nur wenn nötig
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
        }

        return numbers;
    }

}
