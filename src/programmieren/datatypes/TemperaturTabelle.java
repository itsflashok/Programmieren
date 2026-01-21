package src.programmieren.datatypes;

public class TemperaturTabelle {
    public static void main(String[] args) {
        double celsius;
        System.out.println("Fahrenheit | Celsius");
        System.out.println("-----------+--------");
        for (double fahrenheit = 0; fahrenheit <= 300; fahrenheit += 20) {
            celsius = (5. / 9) * (fahrenheit - 32);
            System.out.format("%11d%1s%5f\n", (int) fahrenheit, "|", celsius);
        }
    }
}
