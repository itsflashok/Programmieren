package programmieren.DartsCounter;

/**
 * Darts counter application
 */
public class DartsCounter {

    /**
     * Application entry point
     *
     * @param args
     *             command line arguments
     */
    public static void main(String[] args) {

        final Board b = new Board();

        final Player[] players = new Player[] {
                new Player("Alice", 0, new Visit[0]),
                new Player("Bob", 0, new Visit[0])
        };
        final Game g = new Game(b, players);
        g.start();

    }

}
