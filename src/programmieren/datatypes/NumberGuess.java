package programmieren.datatypes;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        System.out.print("Wie ist dein Name? ");
        String name = scanner.nextLine();
        playGame(name);
        scanner.close();
    }

    private static void playGame(String name) {
        boolean keepPlaying = true;

        while (keepPlaying) {
            guessNumber(name);
            keepPlaying = askPlayAgain();
        }

        System.out.println("Danke fürs Spielen, " + name + "!");
    }

    private static void guessNumber(String name) {
        int targetNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        int attempts = 0;
        int guess;

        System.out.println("\nNeues Spiel! Rate eine Zahl zwischen " + MIN_NUMBER + " und " + MAX_NUMBER);

        do {
            System.out.format("%s, rate eine Zahl [%d-%d]: ", name, MIN_NUMBER, MAX_NUMBER);

            while (!scanner.hasNextInt()) {
                System.out.println("Bitte eine gültige Zahl eingeben!");
                scanner.next();
                System.out.format("%s, rate eine Zahl [%d-%d]: ", name, MIN_NUMBER, MAX_NUMBER);
            }

            guess = scanner.nextInt();
            attempts++;

            if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
                System.out.format("Die Zahl muss zwischen %d und %d liegen!\n", MIN_NUMBER, MAX_NUMBER);
                attempts--;
            } else if (guess < targetNumber) {
                System.out.format("Versuch %d: %d ist zu niedrig\n", attempts, guess);
            } else if (guess > targetNumber) {
                System.out.format("Versuch %d: %d ist zu hoch\n", attempts, guess);
            } else {
                System.out.format("Versuch %d: %d ist korrekt! 🎉\n", attempts, guess);
                System.out.format("Du hast die Zahl in %d Versuch%s erraten!\n",
                        attempts, attempts == 1 ? "" : "en");
            }
        } while (guess != targetNumber);
    }

    private static boolean askPlayAgain() {
        System.out.println("\nWas möchtest du tun?");
        System.out.println("0 - Das Spiel beenden");
        System.out.println("1 - Noch eine Runde spielen");
        System.out.print("Deine Wahl: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Bitte 0 oder 1 eingeben!");
            scanner.next();
            System.out.print("Deine Wahl: ");
        }

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        return choice == 1;
    }
}
