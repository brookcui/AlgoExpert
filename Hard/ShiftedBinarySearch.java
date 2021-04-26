import java.util.*;

class Program {
	// O(log(n)) time | O(1) space
  public static int shiftedBinarySearch(int[] array, int target) {
    // Write your code here.
		if (array.length == 0) {
			return -1;
		}
		int l = 0;
		int r = array.length;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (array[m] == target) {
				return m;
			} else if (array[m] >= array[0]) {
				if (target < array[m] && target >= array[0]) {
					r = m;
				} else {
					l = m + 1;
				}
			} else {
				if (target > array[m] && target <= array[array.length-1]) {
					l = m + 1;
				} else {
					r = m;
				}
			}
		}
		if (l >= array.length || array[l] != target) {
			return -1;
		}
    return l;
  }
}
