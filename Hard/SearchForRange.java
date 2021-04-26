import java.util.*;

class Program {
	// O(log(n)) time | O(1) space
  public static int[] searchForRange(int[] array, int target) {
    // Write your code here.
		int lower = lowerBound(array, target);
		if (lower == -1) {
    	return new int[] {-1, -1};
		}
		int upper = upperBound(array, target);
		return new int[] {lower, upper};
  }
	
	private static int lowerBound(int[] array, int target) {
		int l = 0;
		int r = array.length;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (array[m] >= target) {
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
	
	private static int upperBound(int[] array, int target) {
		int l = 0;
		int r = array.length;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (array[m] > target) {
				r = m - 1;
			} else if (array[m] == target) {
				if (m == array.length - 1 || array[m + 1] != target) {
					return m;
				} else {
					l = m + 1;
				}
			} else  {
				l = m + 1;
			}
		}
		return l;
	}
}
