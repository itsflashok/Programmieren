package programmieren.classes;

/**
 * Represents a radio device with basic control functions.
 * This class manages the radio's state including power, volume, and frequency.
 *
 * @author itsflashok
 * @version 1.0
 */
public class Radio {
    /** Indicates whether the radio is turned on or off */
    public static boolean on = false;

    /** The current volume level of the radio (0-100) */
    public static int volume = 100;

    /** The current frequency of the radio in MHz */
    public static double frequency = 85.0;

    /**
     * Constructs a new Radio with specified settings.
     *
     * @param on        the initial power state (true = on, false = off)
     * @param volume    the initial volume level
     * @param frequency the initial frequency in MHz
     */
    public Radio(boolean on, int volume, double frequency) {
        Radio.on = on;
        Radio.volume = volume;
        Radio.frequency = frequency;

    }

    /**
     * Main method to demonstrate the Radio class functionality.
     * Creates a radio instance and performs various operations.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Radio myRadio = new Radio(on, volume, frequency);
        System.out.println(myRadio);
        myRadio.turnOn();
        System.out.println(myRadio);
        myRadio.incVolume();
        myRadio.incVolume();
        System.out.println(myRadio);

    }

    /**
     * Increases the volume by 1 if the radio is turned on.
     * Does nothing if the radio is off.
     */
    public void incVolume() {
        if (Radio.on) {
            Radio.volume += 1;
        }
    }

    /**
     * Turns the radio on.
     */
    public void turnOn() {
        Radio.on = true;
    }

    /**
     * Turns the radio off.
     */
    public void turnOff() {
        Radio.on = false;
    }

    /**
     * Sets the radio frequency to the specified value.
     *
     * @param frequency the new frequency in MHz
     */
    public void setFrequency(double frequency) {
        Radio.frequency = frequency;
    }

    /**
     * Returns a string representation of the radio's current state.
     *
     * @return a formatted string showing power state, frequency, and volume
     */
    public String toString() {
        return String.format("Radio %b: Freq=%f, Laut=%d", Radio.on, Radio.frequency, Radio.volume);
    }
}
