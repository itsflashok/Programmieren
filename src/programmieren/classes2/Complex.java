package programmieren.classes2;

public class Complex {
    public static void main(String[] args) {
        Complex c1 = new Complex(2, 3);
        Complex c2 = new Complex(4, -1);

        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
        System.out.println();

        System.out.println("c1 + c2: " + c1.add(c2));
        System.out.println("c1 - c2: " + c1.sub(c2));
        System.out.println("c1 * c2: " + c1.mult(c2));
        System.out.println("c1 / c2: " + c1.div(c2));
        System.out.println("Abs(c1): " + c1.abs());
        System.out.println("Abs(c2): " + c2.abs());
        System.out.println("Is c1 less than c2? " + c1.isLess(c2));

        Complex[] complexArray = { c1, c2, new Complex(1, 1), new Complex(0, 2) };
        System.out.println("\nBefore sorting:");
        for (Complex c : complexArray) {
            System.out.println(c + " (abs: " + c.abs() + ")");
        }
        c1.bubbleSort(complexArray);
        System.out.println("\nAfter sorting:");
        for (Complex c : complexArray) {
            System.out.println(c + " (abs: " + c.abs() + ")");
        }

    }

    private double real;

    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public Complex add(Complex comp) {
        return new Complex(this.real + comp.real, this.imag + comp.imag);
    }

    public Complex sub(Complex comp) {
        return new Complex(this.real - comp.real, this.imag - comp.imag);
    }

    public Complex mult(Complex comp) {
        return new Complex(this.real * comp.real - this.imag * comp.imag,
                this.real * comp.imag + this.imag * comp.real);
    }

    public Complex div(Complex comp) {
        return new Complex(
                (this.real * comp.real + this.imag * comp.imag) / (comp.real * comp.real + comp.imag * comp.imag),
                (this.imag * comp.real - this.real * comp.imag) / (comp.real * comp.real + comp.imag * comp.imag));
    }

    public String toString() {
        return String.format("%f + %fi", this.real, this.imag);
    }

    public double abs() {
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }

    public double[] generateRandomComplexNumbers(int n) {
        double[] complexNumbers = new double[n];
        for (int i = 0; i < n; i++) {
            complexNumbers[i] = Math.random() * 10;
        }
        return complexNumbers;
    }

    public void bubbleSort(Complex[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].abs() > arr[j + 1].abs()) {
                    Complex temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public boolean isLess(Complex comp) {
        return this.abs() < comp.abs();
    }
}