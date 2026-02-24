package programmieren.Methoden;

public class Quicksort {
    public static int[] givenArray = { 5, 2, 9, 1, 5, 6 };

    public static void main(String[] args) {
        quicksort(0, givenArray.length - 1);
        for (int i : givenArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void quicksort(int left, int right) {
        if (left < right) {
            int divider = divide(left, right);
            quicksort(left, divider - 1);
            quicksort(divider + 1, right);
        }
    }

    public static int divide(int left, int right) {
        int i = left;
        int j = right - 1;
        int pivot = givenArray[right];

        while (i <= j) {
            while (givenArray[i] < pivot) {
                i++;
            }
            while (j >= 0 && givenArray[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        swap(i, right);
        return i;
    }

    public static void swap(int index1, int index2) {
        int temp = givenArray[index1];
        givenArray[index1] = givenArray[index2];
        givenArray[index2] = temp;
    }
}
