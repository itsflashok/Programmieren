package programmieren.DartsCounter;

public class Player {
    public final static int POINTS = 501;
    private String name;
    private int countDartsThrown;
    private Visit[] visits;

    public Player(String name, int countDartsThrown, Visit[] visits) {
        this.name = name;
        this.countDartsThrown = countDartsThrown;
        this.visits = visits;
    }

    public int getRemainingPoints() {
        int total = 0;
        for (Visit visit : this.visits) {
            total += visit.getValue();
        }
        return POINTS - total;
    }

    public boolean addVisit(Visit visit) {
        Visit[] newVisits = new Visit[this.visits.length + 1];
        for (int i = 0; i < this.visits.length; i++) {
            newVisits[i] = this.visits[i];
        }
        newVisits[newVisits.length - 1] = visit;
        this.visits = newVisits;
        this.countDartsThrown += visit.getFields().length;
        return true;
    }

    public String getName() {
        return this.name;
    }

    public int getCountDartsThrown() {
        return this.countDartsThrown;
    }

}
