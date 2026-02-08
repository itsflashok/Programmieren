package programmieren.arrays;
import java.util.Scanner;

public class DotProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int n = scanner.nextInt();

        int[] numbersX = new int[n];
        int[] numbersY = new int[n];

        // Kombinierte Eingabeschleife spart einen Schleifendurchlauf
        for (int i = 0; i < n; i++) {
            System.out.format("Bitte x_%d eingeben: ", i);
            numbersX[i] = scanner.nextInt();
            System.out.format("Bitte y_%d eingeben: ", i);
            numbersY[i] = scanner.nextInt();
        }

        scanner.close();

        int product = dotProduct(numbersX, numbersY);
        System.out.format("Das Skalarprodukt von x und y ist: %d\n", product);
    }

    public static int dotProduct(int[] numbersX, int[] numbersY) {
        int sum = 0;
        int length = numbersX.length;

        // length wird nur einmal ausgelesen statt bei jedem Schleifendurchlauf
        for (int i = 0; i < length; i++) {
            sum += numbersX[i] * numbersY[i];
        }

        return sum;
    }
}
