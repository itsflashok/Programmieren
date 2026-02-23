package theoinf;

import java.util.Arrays;
import java.util.Scanner;

public class Decoder {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] publicKey = readIntArray(sc, "Public Key eingeben (durch Leerzeichen getrennt):");
        
        System.out.println("Modulus C eingeben:");
        int C = Integer.parseInt(sc.nextLine().trim());

        int[] cipher = readIntArray(sc, "Chiffrate eingeben (durch Leerzeichen getrennt):");

        PrivateKeyResult result = findPrivateKey(publicKey, C);
        
        if (result == null) {
            System.out.println("Kein gültiges d gefunden.");
            sc.close();
            return;
        }

        System.out.println("Gefundenes d: " + result.d);
        System.out.println("Geheimer Schlüssel: " + Arrays.toString(result.privateKey));

        String plaintext = decrypt(cipher, result.privateKey, result.d, C);
        
        System.out.println("Entschlüsselter Text:");
        System.out.println(plaintext);

        sc.close();
    }

    private static int[] readIntArray(Scanner sc, String prompt) {
        System.out.println(prompt);
        String[] input = sc.nextLine().trim().split("\\s+");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        return array;
    }

    private static PrivateKeyResult findPrivateKey(int[] publicKey, int C) {
        int n = publicKey.length;
        
        for (int d = 1; d < C; d++) {
            int[] candidate = new int[n];
            
            for (int i = 0; i < n; i++) {
                candidate[i] = (d * publicKey[i]) % C;
            }

            if (isSuperIncreasing(candidate)) {
                return new PrivateKeyResult(d, candidate);
            }
        }
        
        return null;
    }

    private static String decrypt(int[] cipher, int[] privateKey, int d, int C) {
        StringBuilder plaintext = new StringBuilder();
        int n = privateKey.length;

        for (int S : cipher) {
            int S_prime = (d * S) % C;
            int[] bits = extractBits(S_prime, privateKey);
            
            int ascii = bitsToInt(bits);
            plaintext.append((char) ascii);
        }

        return plaintext.toString();
    }

    private static int[] extractBits(int value, int[] privateKey) {
        int n = privateKey.length;
        int[] bits = new int[n];
        int rest = value;

        for (int i = n - 1; i >= 0; i--) {
            if (privateKey[i] <= rest) {
                bits[i] = 1;
                rest -= privateKey[i];
            }
        }

        return bits;
    }

    private static int bitsToInt(int[] bits) {
        int result = 0;
        for (int bit : bits) {
            result = (result << 1) + bit;
        }
        return result;
    }

    private static boolean isSuperIncreasing(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            if (value <= sum) {
                return false;
            }
            sum += value;
        }
        return true;
    }

    private static class PrivateKeyResult {
        final int d;
        final int[] privateKey;

        PrivateKeyResult(int d, int[] privateKey) {
            this.d = d;
            this.privateKey = privateKey;
        }
    }
}
