package programmieren.Inheritance;

public class Metal extends Element {
    private boolean metalloid;
    private double conductivity;

    // Constructor
    public Metal(String name, String symbol, int ordinal, char shell, int phase, boolean mainGroup,
            boolean metalloid, double conductivity) {
        super(name, symbol, ordinal, shell, phase, mainGroup);
        this.metalloid = metalloid;
        this.conductivity = conductivity;
    }

    // Getters
    public boolean isMetalloid() {
        return metalloid;
    }

    public double getConductivity() {
        return conductivity;
    }

    // Setters
    public void setMetalloid(boolean metalloid) {
        this.metalloid = metalloid;
    }

    public void setConductivity(double conductivity) {
        this.conductivity = conductivity;
    }

    @Override
    public String toString() {
        String baseInfo = super.toString();
        String metalloidInfo = metalloid ? ", Halbleiter" : "";
        return baseInfo + metalloidInfo + String.format(", \u03C3: %.4G", conductivity);
    }
}
