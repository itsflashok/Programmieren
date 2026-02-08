package programmieren.datatypes;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welches Jahr soll auf Schaltjahr geprüft werden? ");
        int year = scanner.nextInt();
        scanner.close();
        System.out.println(String.format("%d ist %sein Schaltjahr", year, isLeapYear(year) ? "" : "k"));
    }

    public static boolean isLeapYear(int year) {
        if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }
}
