package programmieren.classes_extra;

import java.util.List;
import java.util.Scanner;

public class Wechselspiel {
    private List<Player> players;
    private Player currentPlayer;
    private int size;
    private int amountOfColors;
    private Spielfeld spielfeld;
    private Zeitnahme zeitnahme;
    private int movesInCurrentRound;
    private int currentRound;
    private static final int MOVES_PER_ROUND = 10;

    public Wechselspiel(List<Player> players, int size, int amountOfColors) {
        this.players = players;
        this.currentPlayer = players.get(0);
        this.size = size;
        this.amountOfColors = amountOfColors;
        this.spielfeld = new Spielfeld(size, amountOfColors);
        this.zeitnahme = new Zeitnahme();
        this.movesInCurrentRound = 0;
        this.currentRound = 1;
    }

    private void switchPlayer() {
        this.currentPlayer = (this.currentPlayer.equals(this.players.get(0))) ? this.players.get(1)
                : this.players.get(0);
    }

    private boolean isGameOver() {
        // Game ends if time is up and player hasn't completed 10 moves
        if (this.zeitnahme.isTimeUp() && this.movesInCurrentRound < MOVES_PER_ROUND) {
            System.out.println("\n*** TIME'S UP! Game Over! ***");
            System.out.println("Round: " + this.currentRound);
            System.out.println("Moves completed: " + this.movesInCurrentRound + "/" + MOVES_PER_ROUND);
            System.out.println("Final Score: " + this.currentPlayer.getScore());
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        Wechselspiel game = new Wechselspiel(List.of(new Player(playerName)), 9, 7);

        System.out.println("\n=== WECHSELSPIEL START ===");
        System.out.println("Goal: Complete 10 moves per round before time runs out!");
        System.out.println("Round 1: 120 seconds");
        System.out.println("Each new round: remaining time + 45 seconds bonus\n");

        while (!game.isGameOver()) {
            System.out.println("\n=== Round " + game.currentRound + " ===");
            System.out.println(game.zeitnahme);
            System.out.println("Moves: " + game.movesInCurrentRound + "/" + MOVES_PER_ROUND);
            System.out.println(game.spielfeld);

            game.move(scanner);

            // Check if round is complete
            if (game.movesInCurrentRound >= MOVES_PER_ROUND) {
                System.out.println("\n*** ROUND " + game.currentRound + " COMPLETE! ***");
                System.out.println("Remaining time: " + game.zeitnahme.getRemainingTime() + " seconds");
                game.zeitnahme.resetForNewRound();
                game.currentRound++;
                game.movesInCurrentRound = 0;
                System.out.println("Starting Round " + game.currentRound + " with " + game.zeitnahme.getAllowedTime()
                        + " seconds!");
            }
        }

        scanner.close();
    }

    public void move(Scanner scanner) {
        String move = "";
        boolean validMove = false;

        while (!validMove) {
            System.out.println(this.zeitnahme);
            System.out.print("Enter your move (e.g., A1B1): ");
            move = scanner.nextLine().toUpperCase();

            // Check if time is up
            if (this.zeitnahme.isTimeUp()) {
                return;
            }

            if (!isValidMoveFormat(move)) {
                System.out.println("Invalid format! Use format like A1B1");
                continue;
            }

            if (!isValidMove(move)) {
                System.out.println("Invalid move! Cells must be adjacent and different colors.");
                continue;
            }

            validMove = true;
        }

        int col1 = move.charAt(0) - 'A';
        int row1 = Character.getNumericValue(move.charAt(1)) - 1;
        int col2 = move.charAt(2) - 'A';
        int row2 = Character.getNumericValue(move.charAt(3)) - 1;

        this.spielfeld.changeColors(row1, col1, row2, col2);

        int totalScore = processMatches();

        this.currentPlayer.addPoints(totalScore);
        this.movesInCurrentRound++;

        System.out.println("Points earned: " + totalScore);
        System.out.println(this.currentPlayer);
    }

    private int processMatches() {
        int totalScore = 0;

        while (true) {
            int markedCount = this.spielfeld.detectAndMarkMatches();

            if (markedCount == 0) {
                break;
            }

            int roundScore = this.spielfeld.calculateScore();
            totalScore += roundScore;

            this.spielfeld.dropAndRefill();

            System.out.println(this.spielfeld);
        }

        return totalScore;
    }

    private boolean isValidMoveFormat(String move) {
        if (move == null || move.length() != 4 || !move.matches("[A-Z][1-9][A-Z][1-9]")) {
            return false;
        }
        char maxCol = (char) ('A' + this.size - 1);
        return move.charAt(0) <= maxCol &&
                move.charAt(2) <= maxCol &&
                Character.getNumericValue(move.charAt(1)) <= this.size &&
                Character.getNumericValue(move.charAt(3)) <= this.size;
    }

    private boolean isValidMove(String move) {
        int col1 = move.charAt(0) - 'A';
        int row1 = Character.getNumericValue(move.charAt(1)) - 1;
        int col2 = move.charAt(2) - 'A';
        int row2 = Character.getNumericValue(move.charAt(3)) - 1;

        boolean adjacent = (Math.abs(row1 - row2) == 1 && col1 == col2) ||
                (Math.abs(col1 - col2) == 1 && row1 == row2);

        if (!adjacent || this.spielfeld.getColor(row1, col1) == this.spielfeld.getColor(row2, col2)) {
            return false;
        }

        int color1 = this.spielfeld.getColor(row1, col1);
        int color2 = this.spielfeld.getColor(row2, col2);

        // A move is VALID if it forms a triple (that's how Match-3 works!)
        if (this.spielfeld.formsTriple(row1, col1, color2) || this.spielfeld.formsTriple(row2, col2, color1)) {
            return true;
        }

        return false;

    }

}