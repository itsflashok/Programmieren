package src.programmieren;

public class my_first_programm {
    public static void main(String[] args) {
        System.out.printf("Hello %s. Missed call from %s.\n", "Ulli", "Tanja");
        int i = 123;
        System.out.printf("|%d| |%d|\n", i, -i); // |123| |-123|
        System.out.printf("|%5d| |%5d|\n", i, -i); // | 123| | -123|
        System.out.printf("|%-5d| |%-5d|\n", i, -i); // |123 | |-123 |
        double d = 1234.5678;
        System.out.printf("|%10f| |%10f|\n", d, -d);
        // |1234,567800| |-1234,567800|
        System.out.printf("|%10.2f| |%10.2f|%n", d, -d);
        // | 1234,57| | -1234,57|
        System.out.printf("|%010.2f| |%010.2f|\n", d, -d);
        // |0001234,57| |-001234,57|
    }
}
