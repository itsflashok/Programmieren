package programmieren.classes_extra;

public class Zeitnahme {
    private long startTime;
    private long allowedTimeMillis;
    private static final long INITIAL_TIME_SECONDS = 120;
    private static final long BONUS_TIME_SECONDS = 45;

    // Constructor - starts with initial time
    public Zeitnahme() {
        this.allowedTimeMillis = INITIAL_TIME_SECONDS * 1000;
        this.startTime = System.currentTimeMillis();
    }

    // Get elapsed time in seconds
    public long getElapsedTime() {
        long currentTime = System.currentTimeMillis();
        return (currentTime - this.startTime) / 1000;
    }

    // Get remaining time in seconds
    public long getRemainingTime() {
        long elapsed = getElapsedTime();
        long allowedSeconds = this.allowedTimeMillis / 1000;
        long remaining = allowedSeconds - elapsed;
        return remaining > 0 ? remaining : 0;
    }

    // Check if time is up
    public boolean isTimeUp() {
        return getRemainingTime() == 0;
    }

    // Reset for new round: add remaining time + bonus time
    public void resetForNewRound() {
        long remaining = getRemainingTime();
        this.allowedTimeMillis = (remaining + BONUS_TIME_SECONDS) * 1000;
        this.startTime = System.currentTimeMillis();
    }

    // Get allowed time in seconds (for display)
    public long getAllowedTime() {
        return this.allowedTimeMillis / 1000;
    }

    @Override
    public String toString() {
        long remaining = getRemainingTime();
        long minutes = remaining / 60;
        long seconds = remaining % 60;
        return String.format("Time remaining: %02d:%02d", minutes, seconds);
    }
}
