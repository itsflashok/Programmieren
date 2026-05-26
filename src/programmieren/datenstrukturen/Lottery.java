package programmieren.datenstrukturen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Lottery {
    private static final int MAX_NUMBERS = 6;
    private static final int MAX_VALUE = 49;
    private static final int EXTRA_NUMBERS = 1;

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(generate(MAX_NUMBERS, MAX_VALUE));
        numbers.addAll(generate(EXTRA_NUMBERS, MAX_VALUE));

        System.out.print(numbers.subList(0, MAX_NUMBERS) + " ");
        System.out.println("Zusatzzahl: " + numbers.get(MAX_NUMBERS));
    }

    public static ArrayList<Integer> generate(int count, int max) {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < count) {
            numbers.add((int) (Math.random() * max) + 1);
        }
        return new ArrayList<>(numbers.stream().sorted().toList());
    }

}
