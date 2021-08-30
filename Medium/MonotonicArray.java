import java.util.*;

class Program {
	// O(n) time | O(1) space
	public static boolean isMonotonic(int[] array) {
		// Write your code here.
		boolean isNonDecreasing = true;
		boolean isNonIncreasing = true;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				isNonDecreasing = false;
			}
			if (array[i] > array[i - 1]) {
				isNonIncreasing = false;
			}
		}
		return isNonDecreasing || isNonIncreasing;
	}
}
