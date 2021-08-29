import java.util.*;

class Program {
    // O(n) time | O(1) space
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        // threeLargest: third largest, second largest, first largest
        int[] threeLargest = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
        for (int num : array) {
            updateThreeLargest(threeLargest, num);
        }
        return threeLargest;
    }

    private static void updateThreeLargest(int[] threeLargest, int num) {
        if (num > threeLargest[2]) { // greater than largest
            shiftAndUpdate(threeLargest, num, 2);
        } else if (num > threeLargest[1]) { // greater than sceond largest
            shiftAndUpdate(threeLargest, num, 1);
        } else if (num > threeLargest[0]) { // greater than third largest
            shiftAndUpdate(threeLargest, num, 0);
        }
    }

    private static void shiftAndUpdate(int[] array, int num, int idx) {
        for (int i = 0; i <= idx; i++) {
            if (i == idx) {
                array[i] = num;
            } else {
                array[i] = array[i + 1];
            }
        }
    }
}
