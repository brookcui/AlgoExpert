import java.util.*;

class Program {
	// O(nlog(n)) time | O(n) space
  public static int[] mergeSort(int[] array) {
    // Write your code here.
		if (array.length <= 1) {
			return array;
		}
		int[] duplicate = array.clone();
		mergeSort(array, 0, array.length - 1, duplicate);
    return array;
  }
	
	private static void mergeSort(int[] array, int start, int end, int[] duplicate) {
		if (start == end) {
			return;
		}
		int middle = start + (end - start) / 2;
		mergeSort(duplicate, start, middle, array);
		mergeSort(duplicate, middle + 1, end, array);
		merge(array, start, middle, end, duplicate);
	}
	
	private static void merge(int[] array, int start, int middle, int end, int[] duplicate) {
		int i = start, j = middle + 1, k = start;
		while (i <= middle && j <= end) {
			if (duplicate[i] <= duplicate[j]) {
				array[k++] = duplicate[i++];
			} else {
				array[k++] = duplicate[j++];
			}
		}
		while (i <= middle) {
			array[k++] = duplicate[i++];
		}
		while (j <= end) {
			array[k++] = duplicate[j++];
		}
	}
}
