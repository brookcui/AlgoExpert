import java.util.*;

class Program {
	// O(nlog(n)) time | O(n) space
  public int countInversions(int[] array) {
    // Write your code here.
    return mergeSort(array, 0, array.length - 1);
  }
	
	private int mergeSort(int[] array, int start, int end) {
		if (start >= end) {
			return 0;
		}
		int middle = start + (end - start) / 2;
		int inversions = 0;
		int left = mergeSort(array, start, middle);
		int right = mergeSort(array, middle + 1, end);
		int merged = merge(array, start, middle, end);
		return left + right + merged;
	}
	
	private int merge(int[] array, int start, int middle, int end) {
		int inversion = 0;
		int[] newArray = new int[end - start + 1];
		int i = start, j = middle + 1, k = 0;
		int count = 0;
		while (i <= middle && j <= end) {
			if (array[i] <= array[j]) {
				newArray[k++] = array[i++];
				inversion += count;
			} else {
				newArray[k++] = array[j++];
				count++;
			}
		}
		while (i <= middle) {
			newArray[k++] = array[i++];
			inversion += count;
		}
		while (j <= end) {
			newArray[k++] = array[j++];
		}
		for (int idx = 0; idx < newArray.length; idx++) {
			array[start + idx] = newArray[idx];
		}
		return inversion;
	}
}
