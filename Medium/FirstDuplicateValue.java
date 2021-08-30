import java.util.*;

class Program {
	// O(n) time | O(1) space
	public int firstDuplicateValue(int[] array) {
		// Write your code here.
		for (int num : array) {
			int absValue = Math.abs(num);
			if (array[absValue - 1] < 0) {
				return absValue;
			}
			array[absValue - 1] *= -1;
		}
		return -1;
	}
}
