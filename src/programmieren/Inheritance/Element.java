package programmieren.Inheritance;

public class Element {
    // Constants for phase
    public static final int SOLID = 1;
    public static final int LIQUID = 2;
    public static final int GAS = 3;

    // Constants for main/side group
    public static final boolean MAIN = true;
    public static final boolean SIDE = false;

    // Attributes
    private String name;
    private String symbol;
    private int ordinal;
    private char shell;
    private int phase;
    private boolean mainGroup;

    // Constructor
    public Element(String name, String symbol, int ordinal, char shell, int phase, boolean mainGroup) {
        this.name = name;
        this.symbol = symbol;
        this.ordinal = ordinal;
        this.shell = shell;
        this.phase = phase;
        this.mainGroup = mainGroup;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public char getShell() {
        return shell;
    }

    public int getPhase() {
        return phase;
    }

    public boolean isMainGroup() {
        return mainGroup;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public void setShell(char shell) {
        this.shell = shell;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public void setMainGroup(boolean mainGroup) {
        this.mainGroup = mainGroup;
    }

    // Helper method to get phase as string
    private String getPhaseString() {
        switch (phase) {
            case SOLID:
                return "fest";
            case LIQUID:
                return "flüssig";
            case GAS:
                return "gasförmig";
            default:
                return "unbekannt";
        }
    }

    // Helper method to get group as string
    private String getGroupString() {
        return mainGroup ? "Hauptgruppe" : "Nebengruppe";
    }

    @Override
    public String toString() {
        return String.format("%s (%s,%d) Schale: %c, %s, Gruppe: %s",
                name, symbol, ordinal, shell, getPhaseString(), getGroupString());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Element) {
            Element other = (Element) o;
            return this.ordinal == other.ordinal;
        }
        return false;
    }
}