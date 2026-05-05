package programmieren.DartsCounter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    static final String path = "src/programmieren/DartsCounter/";
    private Board board;
    private Player[] players;

    public Game(Board board, Player[] players) {
        this.board = board;
        this.players = players;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            for (Player p : players) {
                if (p.getRemainingPoints() <= 0 ) {
                    System.out.println(p.getName() + " has won the game with " + p.getCountDartsThrown() + " darts.");
                    writeResultsToFile();
                    return;
                }

                System.out.println("Player " + p.getName() + " has " + p.getRemainingPoints() + " points remaining.");
                System.out.println("Enter visit: ");
                String input = sc.nextLine();
                String[] fieldLabels = input.split(" ");
                Field[] fields = new Field[fieldLabels.length];
                int remainingBefore = p.getRemainingPoints();
                for (int i = 0; i < fieldLabels.length; i++) {
                    fields[i] = board.parseField(fieldLabels[i]);
                    if (fields[i] == null) {
                        System.out.println("Invalid field: " + fieldLabels[i]);
                        return;
                    }
                }
                Visit visit = new Visit(fields);
                if (!p.addVisit(visit)) {
                    System.out.println("Invalid visit: " + input);
                    return;
                }
                int scoredReported = Math.min(visit.getValue(), remainingBefore);
                System.out.println("Scored: " + scoredReported + " (attempted: " + visit.getValue() + ") Remaining: "
                        + Math.max(0, p.getRemainingPoints()));
                if (p.getRemainingPoints() <= 0) {
                    System.out.println(p.getName() + " has won the game with " + p.getCountDartsThrown() + " darts.");
                    writeResultsToFile();
                    return;
                }
            }
            for (Player p : players) {
                if (p.getCountDartsThrown() >= 30) {
                    System.out.println("The player " + p.getName() + " have thrown 10 times. Game over.");
                    writeResultsToFile();
                    return;
                }
            }
        }

        // unreachable: returns inside loop handle game end and call
        // writeResultsToFile()
    }

    public static void createDirectory() {
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public void writeResultsToFile() {
        createDirectory();
        String fileName = "Game " + this.players[0].getName() + " vs " + this.players[1].getName() + ".txt";
        File out = new File(path, fileName);
        try (FileWriter writer = new FileWriter(out, true)) {
            String line = "Game result: " + "Player " + this.players[0].getName() + " scored "
                    + (Player.POINTS - this.players[0].getRemainingPoints())
                    + " points with " + this.players[0].getCountDartsThrown() + " darts. Player "
                    + this.players[1].getName() + " scored " + (Player.POINTS - this.players[1].getRemainingPoints())
                    + " points with " + this.players[1].getCountDartsThrown() + " darts.\n";
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}