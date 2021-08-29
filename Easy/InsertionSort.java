import java.util.*;

class Program {
    // O(n^2) time | O(1) space
    public static int[] insertionSort(int[] array) {
        // Write your code here.
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                swap(j - 1, j, array);
            }
        }
        return array;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
