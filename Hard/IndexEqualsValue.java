import java.util.*;

class Program {
  // O(log(n)) time | O(1) space
  public int indexEqualsValue(int[] array) {
    // Write your code here.
		if (array.length == 0) {
			return -1;
		}
		int l = 0;
		int r = array.length;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (array[m] == m && m == 0) {
				return m;
			} else if (array[m] == m && array[m - 1] < m - 1) {
				return m;
			} else if (array[m] < m) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		if (l >= array.length || array[l] != l) {
			return -1;
		}
    return l;
  }
}
