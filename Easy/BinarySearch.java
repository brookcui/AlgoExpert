import java.util.*;

class Program {
    // O(log(n)) time | O(1) space
    public static int binarySearch(int[] array, int target) {
        // Write your code here.
        int l = 0, r = array.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (array[m] == target) {
                return m;
            } else if (array[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (l >= array.length || array[l] != target) {
            return -1;
        }
        return l;
    }
}
