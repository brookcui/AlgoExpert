import java.util.*;

class Program {
    // O(n^2) time | O(1) space
    public static int[] selectionSort(int[] array) {
        // Write your code here.
        for (int i = 0; i < array.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[idx]) {
                    idx = j;
                }
            }
            swap(i, idx, array);
        }
        return array;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
