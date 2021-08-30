import java.util.*;

class Program {
	// O(n) time | O(1) space
	public static int longestPeak(int[] array) {
		// Write your code here.
		int maxLength = 0;
		for (int idx = 1; idx < array.length - 1;) {
			int l = idx - 1, r = idx + 1;
			boolean isPeak = array[l] < array[idx] && array[idx] > array[r];
			if (!isPeak) {
				++idx;
				continue;
			}
			while (l >= 0 && array[l] < array[l + 1]) {
				--l;
			}
			while (r < array.length && array[r - 1] > array[r]) {
				++r;
			}
			maxLength = Math.max(maxLength, r - l - 1);
			idx = r;
		}
		return maxLength;
	}
}
