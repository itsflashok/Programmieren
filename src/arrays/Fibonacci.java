package src.arrays;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Wie viele Fibonacci-Zahlen möchtest du sehen? ");
        int n = input.nextInt();
        input.close();

        System.out.println("\nFibonacci-Folge (erste " + n + " Zahlen):");
        for (int i = 0; i < n; i++) {
            System.out.println("F(" + i + ") = " + fibonacci(i));
        }
    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
