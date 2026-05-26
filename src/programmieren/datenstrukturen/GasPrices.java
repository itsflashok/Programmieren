package programmieren.datenstrukturen;

public class GasPrices {
    private double diesel;
    private double superE5;
    private double superE10;

    public GasPrices(double diesel, double superE5, double superE10) {
        this.diesel = diesel;
        this.superE5 = superE5;
        this.superE10 = superE10;
    }

    @Override
    public String toString() {
        return "Diesel: " + diesel + ", SuperE5: " + superE5 + ", SuperE10: " + superE10;
    }
}
