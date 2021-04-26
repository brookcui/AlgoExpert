import java.util.*;

class Program {
	// Average: O(n) time | O(1) space
	// Worst: O(n^2) time | O(1) space
  public static int quickselect(int[] array, int k) {
    // Write your code here.
    return helper(array, 0, array.length - 1, k - 1);
  }
	
	private static int helper(int[] array, int start, int end, int k) {
		while (true) {
			if (start > end) {
				throw new RuntimeException("never gonna happen");
			}
			int pivotIdx = start;
			int leftIdx = start + 1;
			int rightIdx = end;
			while (leftIdx <= rightIdx) {
				if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
					swap(leftIdx, rightIdx, array);
				}
				if (array[leftIdx] <= array[pivotIdx]) {
					leftIdx++;
				}
				if (array[rightIdx] >= array[pivotIdx]) {
					rightIdx--;
				}
			}
			swap(pivotIdx, rightIdx, array);
			if (rightIdx == k) {
				return array[rightIdx];
			} else if (rightIdx < k) {
				start = rightIdx + 1;
			} else {
				end = rightIdx - 1;
			}
		}
	}
	
	private static void swap(int i, int j, int[] array) {
		int tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}
}
