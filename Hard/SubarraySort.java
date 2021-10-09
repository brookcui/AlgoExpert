import java.util.*;

class Program {
	// O(n) time | O(1) space
  public static int[] subarraySort(int[] array) {
    // Write your code here.
		int minOutOfOrder = Integer.MAX_VALUE;
		int maxOutOfOrder = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (isOutOfOrder(i, array)) {
				minOutOfOrder = Math.min(minOutOfOrder, array[i]);
				maxOutOfOrder = Math.max(maxOutOfOrder, array[i]);
			}
		}
		if (minOutOfOrder == Integer.MAX_VALUE) {
			return new int[] {-1, -1};
		}
		int left = 0;
		while (minOutOfOrder >= array[left]) {
			left++;
		}
		int right = array.length - 1;
		while (maxOutOfOrder <= array[right]) {
			right--;
		}
    return new int[] {left, right};
  }
	
	private static boolean isOutOfOrder(int i, int[] array) {
		if (i == 0) {
			return array[i] > array[i + 1];
		}
		if (i == array.length - 1) {
			return array[i] < array[i - 1];
		}
		return array[i] > array[i + 1] || array[i] < array[i - 1];
	}
}
