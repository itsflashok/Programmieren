package programmieren.arrays2;

import java.util.Scanner;

public class MatrixSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte Anzahl der Zeilen n eingeben: ");
        int n = scanner.nextInt();
        System.out.print("Bitte Anzahl der Spalten m eingeben: ");
        int m = scanner.nextInt();
        scanner.close();

        int[][] matrixA = new int[n][m];
        int[][] matrixB = new int[n][m];

        System.out.println("\nMatrix A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = (int) (Math.random() * 101);
                System.out.print(matrixA[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatrix B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixB[i][j] = (int) (Math.random() * 101);
                System.out.print(matrixB[i][j] + " ");
            }
            System.out.println();
        }

        int[][] subtraction = minusMatrix(matrixA, matrixB);

        System.out.println("\nMatrix A - B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(subtraction[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] minusMatrix(int[][] matrixA, int[][] matrixB) {
        int n = matrixA.length;
        int m = matrixA[0].length;
        int[][] subtraction = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                subtraction[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }

        return subtraction;
    }
}
