package programmieren.classes_extra;

public class Player {
    private String name;
    private int score;
    private int numberOfMoves;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.numberOfMoves = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public int addPoints(int points) {
        this.score += points;
        return this.score;
    }

    public int addMove() {
        this.numberOfMoves++;
        return this.numberOfMoves;
    }

    public String toString() {
        return this.name + " (Score: " + this.score + ", Moves: " + this.numberOfMoves + ")";
    }

}