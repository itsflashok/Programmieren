package src.programmieren.datatypes;

public class ShortValue {
    public static void main(String[] args) {
        short s = 32767;
        System.out.println("Short value: " + s);
        s += 1;
        System.out.println("After overflow: " + s);
    }
}
