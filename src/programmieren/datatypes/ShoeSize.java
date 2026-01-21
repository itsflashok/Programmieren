package src.programmieren.datatypes;

public class ShoeSize {
    public static void main(String[] args) {
        double cm = 0;
        System.out.println("Zentimeter | Größe");
        System.out.println("-----------+--------");
        for (double size = 30; size <= 49; size++) {
            cm = size / 1.5;
            System.out.format("%.2f%1s%.2f%1s%5d\n", (cm - 0.67), "-", cm, "|", (int) size);
        }
    }
}
