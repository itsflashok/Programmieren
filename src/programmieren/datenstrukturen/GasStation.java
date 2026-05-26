package programmieren.datenstrukturen;

public class GasStation {
    private String name;
    private double diesel;
    private double e5;
    private double e10;

    public GasStation(String name, double diesel, double e5, double e10) {
        this.name = name;
        this.diesel = diesel;
        this.e5 = e5;
        this.e10 = e10;
    }

    public String getName() {
        return name;
    }

    public double getDiesel() {
        return diesel;
    }

    public double getE5() {
        return e5;
    }

    public double getE10() {
        return e10;
    }

    @Override
    public String toString() {
        return name + " | Diesel: " + diesel + " | E5: " + e5 + " | E10: " + e10;
    }

    public String toFileString() {
        return name + ";" + diesel + ";" + e5 + ";" + e10;
    }
}
