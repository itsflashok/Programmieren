package programmieren.classes3;

import java.util.Scanner;

public class MasterMind {
    private String secretCode;
    private int tryCounter;
    private int maxTries;
    private String[] tipps;
    private int[] correctPositions;
    private int[] correctLetters;

    public MasterMind(int maxTries) {
        this.secretCode = generateSecretCode();
        this.tryCounter = 0;
        this.maxTries = maxTries;
        this.tipps = new String[maxTries];
        this.correctPositions = new int[maxTries];
        this.correctLetters = new int[maxTries];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.tryCounter).append(" bisherige Versuche:\n");
        for (int i = 0; i < this.tryCounter; i++) {
            sb.append(this.tipps[i]).append(" ")
              .append(this.correctPositions[i]).append(" ")
              .append(this.correctLetters[i]).append("\n");
        }
        return sb.toString();
    }

    private String generateSecretCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append((char) (Math.random() * 8 + 'A')); // A bis H
        }
        return sb.toString();
    }

    private int[] evaluateGuess(String guess) {
        int correctPos = 0;
        int correctLetter = 0;
        
        boolean[] secretUsed = new boolean[5];
        boolean[] guessUsed = new boolean[5];

        for (int i = 0; i < 5; i++) {
            if (guess.charAt(i) == secretCode.charAt(i)) {
                correctPos++;
                secretUsed[i] = true;
                guessUsed[i] = true;
            }
        }
        
        for (int i = 0; i < 5; i++) {
            if (!guessUsed[i]) {
                for (int j = 0; j < 5; j++) {
                    if (!secretUsed[j] && guess.charAt(i) == secretCode.charAt(j)) {
                        correctLetter++;
                        secretUsed[j] = true;
                        break;
                    }
                }
            }
        }
        
        return new int[]{correctPos, correctLetter};
    }

    public boolean isGameOver(int i) {
        return (this.tipps[i].equals(this.secretCode));
    }

    public void masterMind() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Willkommen bei MasterMind!");
            System.out.println("Errate die 5-Buchstaben Kombination (A-H).");
            System.out.println("Du hast " + maxTries + " Versuche.\n");
            
            while (tryCounter < maxTries) {
                System.out.print("Geben Sie Ihren Tipp ein (5 Zeichen A-H): ");
                String guess = scanner.nextLine().toUpperCase();
                
                // Validierung
                if (guess.length() != 5) {
                    System.out.println("Bitte genau 5 Zeichen eingeben!");
                    continue;
                }
                
                this.tipps[tryCounter] = guess;
 
                int[] result = evaluateGuess(guess);
                this.correctPositions[tryCounter] = result[0];
                this.correctLetters[tryCounter] = result[1];
                
                tryCounter++;

                if (guess.equals(secretCode)) {
                    System.out.println("\nGlückwunsch! Du hast gewonnen!");
                    System.out.println("Die richtige Kombination war: " + secretCode);
                    System.out.format("Mit %d Versuchen gewonnen!\n", this.tryCounter);
                    return;
                }

                System.out.println("Richtige Buchstaben auf richtigen Stellen: " + result[0]);
                System.out.println("Richtige Buchstaben auf falschen Stellen: " + result[1]);
                System.out.println();
                
                // Zeige Historie aller Versuche
                System.out.println("Bisherige Versuche:");
                for (int i = 0; i < tryCounter; i++) {
                    System.out.println(this.tipps[i] + " " + this.correctPositions[i] + " " + this.correctLetters[i]);
                }
                System.out.println();
            }

            System.out.println("\nLeider verloren! Du hast die maximale Anzahl an Versuchen erreicht.");
            System.out.println("Die richtige Kombination war: " + secretCode);
        }
    }

    public static void main(String[] args) {
        MasterMind game = new MasterMind(20);
        game.masterMind();
    }
}

