package programmieren.strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte Wort eingeben: ");
        String wort = scanner.next();
        scanner.close();
        String palindrome = palindrome(wort);
        System.out.print(wort);
        System.out.print(
                wort.toLowerCase().equals(palindrome.toLowerCase()) ? " ist ein Palindrom.\n"
                        : " ist kein Palindrom.\n");
    }

    public static String palindrome(String wort) {
        String umgekehrt = "";
        for (String i : wort.split("")) {
            umgekehrt = i + umgekehrt;
        }
        return umgekehrt;
    }

}
