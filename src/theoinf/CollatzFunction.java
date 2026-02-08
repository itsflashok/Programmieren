package theoinf;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CollatzFunction {
    public static int f (int alpha, int beta, int n) {
        return (n % 2 == 0) ? n / 2 : alpha * n + beta;
    }

    public static int findK(int alpha, int beta, int start) {
        int n = start, k= 0;
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && k < 10000) {
            if (seen.contains(n)) {
                return -1;
            }
            seen.add(n);
            n = f(alpha, beta, n);
            k++;
        }
        return (n == 1) ? k : -1;
    }

    public static Set<Integer> nonCoverging(int alpha, int beta, int max) {
        Set<Integer> result = new HashSet<>();
        for (int n = 1; n <= max; n++) {
        if (findK(alpha, beta, n) == -1) {
                result.add(n);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int k = findK(3, 1, 27);
        System.out.println("k: " + k);

        Set<Integer> M = nonCoverging(3, 7, 20);
        System.out.println("M = " + new TreeSet<>(M));
    }
}
