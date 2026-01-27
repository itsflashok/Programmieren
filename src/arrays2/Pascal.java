package src.arrays2;

import java.util.Scanner;

public class Pascal {
    public static void main(String[] args) {
        System.out.print("Bitte die Tiefe n eingeben: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int[][] triangle = new int[n][];

        // Pascalsches Dreieck aufbauen
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    // Randwerte sind immer 1
                    triangle[i][j] = 1;
                } else {
                    // Innere Werte: Summe der beiden darüberliegenden
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }

        // Ausgabe mit Einrückung für Dreiecksform
        for (int i = 0; i < n; i++) {
            // Einrückung für Zentrierung
            for (int k = 0; k < n - i - 1; k++) {
                System.out.print("  ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", triangle[i][j]);
            }
            System.out.println();
        }
    }
}
