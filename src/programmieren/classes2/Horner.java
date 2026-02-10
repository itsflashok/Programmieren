package programmieren.classes2;

public class Horner {
    private double[] attributes;

    public Horner(double[] attributes) {
        this.attributes = attributes;
    }

    public static void main(String[] args) {
        Horner myHorner = new Horner(new double[] { 0.5, -3.0, 2.0, 4.0, 3.0, -10.0, 8.0, 4.5, 3.0, -2.0, 1.0 });
        System.out.println(myHorner);
        System.out.println(myHorner.getValue(8.5));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.print("Polynomial f: ");
        for (int i = 0; i < this.attributes.length; i++) {
            sb.append(String.format("%.1fx^%d ", this.attributes[i], this.attributes.length - 1 - i));
            if (i < this.attributes.length - 1) {
                if (this.attributes[i + 1] >= 0) {
                    sb.append("+ ");
                }
            }
        }
        return sb.toString();
    }

    public double getValue(double x) {
        double result = this.attributes[0];
        for (int i = 1; i < this.attributes.length; i++) {
            result = result * x + this.attributes[i];
        }
        return result;
    }

}
