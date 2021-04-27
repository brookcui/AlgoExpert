import java.util.*;

class Program {
	// Average: O(nlog(n)) time | O(n) space
	// Worst: O(n^2) time | O(n) space
  public static List<Integer> rightSmallerThan(List<Integer> array) {
    // Write your code here.
		List<Integer> smallerCounts = new ArrayList<Integer>();
		List<Integer> indexes = new ArrayList<>();
		for (int i = 0; i < array.size(); i++) {
			smallerCounts.add(0);
			indexes.add(i);
		}
		mergeSort(array, indexes, 0, array.size() - 1, smallerCounts);
    return smallerCounts;
  }
	
	private static void mergeSort(List<Integer> array, List<Integer> indexes, int start, int end, List<Integer> smallerCounts) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSort(array, indexes, start, mid, smallerCounts);
			mergeSort(array, indexes, mid + 1, end, smallerCounts);
			merge(array, indexes, start, end, smallerCounts);
		}
	}
	
	private static void merge(List<Integer> array, List<Integer> indexes, int start, int end, List<Integer> smallerCounts) {
		int mid = start + (end - start) / 2;
		int idx = 0;
		int leftIdx = start;
		int rightIdx = mid + 1;
		int rightSmallerCount = 0;
		List<Integer> newIndexes = new ArrayList<>();
		for (int i = 0; i < end - start + 1; i++) {
			newIndexes.add(0);
		}
		while (leftIdx <= mid && rightIdx <= end) {
			if (array.get(indexes.get(leftIdx)) > array.get(indexes.get(rightIdx))) { // right smaller
				rightSmallerCount++;
				newIndexes.set(idx, indexes.get(rightIdx));
				rightIdx++;
			} else {
				newIndexes.set(idx, indexes.get(leftIdx));
				smallerCounts.set(indexes.get(leftIdx), smallerCounts.get(indexes.get(leftIdx)) + rightSmallerCount);
				leftIdx++;
			}
			idx++;
		}
		while (leftIdx <= mid) {
			newIndexes.set(idx, indexes.get(leftIdx));
			smallerCounts.set(indexes.get(leftIdx), smallerCounts.get(indexes.get(leftIdx)) + rightSmallerCount);
			leftIdx++;
			idx++;
		}
		while (rightIdx <= end) {
			newIndexes.set(idx, indexes.get(rightIdx));
			rightIdx++;
			idx++;
		}
		for (int i = start; i <= end; i++) {
			indexes.set(i, newIndexes.get(i - start));
		}
	}
}
