package programmieren.classes3;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto {
    private int numbersNeeded;
    private int numbersMax;
    private int[] tippedNumbers;
    private int[] winningNumbers;

    public Lotto(int numbersNeeded, int numbersMax) {
        this.numbersNeeded = numbersNeeded;
        this.numbersMax = numbersMax;
        this.tippedNumbers = new int[numbersNeeded];
        this.winningNumbers = new int[numbersNeeded];
    }

    public static void main(String[] args) {
        Lotto deutschesLotto = new Lotto(6, 49);

        // Testen mit vorgegebenen Zahlen
        // deutschesLotto.tippen(new int[]{7, 14, 21, 28, 35, 42});

        // Oder interaktiv tippen
        deutschesLotto.tippen();

        System.out.println(deutschesLotto);

        deutschesLotto.ziehen();
        System.out.println(deutschesLotto);

        deutschesLotto.richtige();
    }

    public void tippen() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < this.numbersNeeded; i++) {
            System.out.format("Bitte geben Sie Ihren Tipp für die %d. Zahl ein (1-%d): ",
                    i + 1, this.numbersMax);
            int guess = scanner.nextInt();

            if (guess < 1 || guess > this.numbersMax) {
                System.out.println("Ungültige Zahl, bitte geben Sie eine Zahl zwischen 1 und "
                        + this.numbersMax + " ein.");
                i--;
            } else if (contains(this.tippedNumbers, guess, i)) {
                System.out.println("Diese Zahl haben Sie bereits getippt!");
                i--;
            } else {
                this.tippedNumbers[i] = guess;
            }
        }
        scanner.close();
    }

    public void tippen(int[] tipp) {
        if (tipp.length != this.numbersNeeded) {
            System.out.println("Fehler: Sie müssen genau " + this.numbersNeeded + " Zahlen tippen!");
            return;
        }

        for (int i = 0; i < tipp.length; i++) {
            if (tipp[i] < 1 || tipp[i] > this.numbersMax) {
                System.out.println("Ungültige Zahl: " + tipp[i] +
                        ". Zahlen müssen zwischen 1 und " + this.numbersMax + " sein.");
                return;
            }
        }

        this.tippedNumbers = tipp.clone();
    }

    public void ziehen() {
        for (int i = 0; i < this.numbersNeeded; i++) {
            int randomNumber = (int) (Math.random() * this.numbersMax) + 1;

            // Prüfen ob Zahl schon gezogen wurde
            if (contains(this.winningNumbers, randomNumber, i)) {
                i--; // Nochmal versuchen
            } else {
                this.winningNumbers[i] = randomNumber;
            }
        }
    }

    public int richtige() {
        int counter = 0;
        for (int i = 0; i < this.numbersNeeded; i++) {
            if (contains(this.tippedNumbers, this.winningNumbers[i], this.tippedNumbers.length)) {
                counter++;
            }
        }
        System.out.println("Sie haben " + counter + " Richtige!");
        return counter;
    }

    private boolean contains(int[] array, int value, int upToIndex) {
        for (int i = 0; i < upToIndex; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Lotto " + this.numbersNeeded + " aus " + this.numbersMax + " ===\n");

        if (this.tippedNumbers[0] != 0) {
            int[] sortedTipp = this.tippedNumbers.clone();
            Arrays.sort(sortedTipp);
            sb.append("Ihr Tipp: ");
            for (int num : sortedTipp) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }

        if (this.winningNumbers[0] != 0) {
            int[] sortedWinning = this.winningNumbers.clone();
            Arrays.sort(sortedWinning);
            sb.append("Gezogene Zahlen: ");
            for (int num : sortedWinning) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}