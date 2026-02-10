package programmieren.classes2;

public class Polynomial {
    private double a;
    private double b;
    private double c;

    public Polynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public String toString() {
        return String.format("%fx^2 + (%fx) + (%f)",
                this.a, this.b, this.c);
    }

    public Polynomial minus(Polynomial polynomial) {
        return new Polynomial(this.a - polynomial.a, this.b - polynomial.b, this.c - polynomial.c);
    }

    public Polynomial add(Polynomial polynomial) {
        return new Polynomial(this.a + polynomial.a, this.b + polynomial.b, this.c + polynomial.c);
    }

    public double[] nullpoints() {
        double discriminant = this.b * this.b - 4 * this.a * this.c;
        double x1 = (-this.b + Math.sqrt(discriminant)) / (2 * this.a);
        double x2 = (-this.b - Math.sqrt(discriminant)) / (2 * this.a);
        return new double[] { x1, x2 };
    }

    public Polynomial skalarMultiplication(int skalar) {
        return new Polynomial(this.a * skalar, this.b * skalar, this.c * skalar);
    }

    public double functionWert(int x) {
        return (this.a * x * x + this.b * x + this.c);
    }

    public static void main(String[] args) {
        // Erstelle zwei Polynome
        Polynomial p1 = new Polynomial(1, -3, 2); // x^2 - 3x + 2
        Polynomial p2 = new Polynomial(2, 1, -1); // 2x^2 + x - 1

        System.out.println("Polynom 1: " + p1);
        System.out.println("Polynom 2: " + p2);
        System.out.println();

        // Test Addition
        Polynomial sum = p1.add(p2);
        System.out.println("p1 + p2 = " + sum);

        // Test Subtraktion
        Polynomial diff = p1.minus(p2);
        System.out.println("p1 - p2 = " + diff);
        System.out.println();

        // Test Skalar-Multiplikation
        Polynomial p1Scaled = p1.skalarMultiplication(3);
        System.out.println("p1 * 3 = " + p1Scaled);
        System.out.println();

        // Test Funktionswert
        System.out.println("p1(0) = " + p1.functionWert(0));
        System.out.println("p1(1) = " + p1.functionWert(1));
        System.out.println("p1(2) = " + p1.functionWert(2));
        System.out.println();

        // Test Nullstellen
        double[] nullstellen = p1.nullpoints();
        System.out.println("Nullstellen von p1:");
        System.out.println("x1 = " + nullstellen[0]);
        System.out.println("x2 = " + nullstellen[1]);
    }
}
