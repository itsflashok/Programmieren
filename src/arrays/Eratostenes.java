package src.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Eratostenes {
    public static void main(String[] args) {
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        List<Integer> sorted = eratostenes(n);
        System.out.println("Sortiert: " + sorted);
    }

    public static List<Integer> eratostenes(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        List<Integer> sieve = new ArrayList<Integer>();

        for (int i = 2; i <= n; i++) {
            sieve.add(i);
        }

        while (sieve.size() != 0) {
            int prime = sieve.get(0);
            primes.add(prime);

            for (int i = sieve.size() - 1; i >= 0; i--) {
                if (sieve.get(i) % prime == 0) {
                    sieve.remove(i);
                }
            }
        }

        return primes;
    }
}
