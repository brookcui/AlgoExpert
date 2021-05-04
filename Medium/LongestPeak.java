import java.util.*;

class Program {
	// O(n) time | O(1) space
  public static int longestPeak(int[] array) {
    // Write your code here.
		int longestPeakLength = 0;
		int i = 1;
		while (i < array.length - 1) {
			int left = i - 1;
			int right = i + 1;
			boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];
			if (!isPeak) {
				i++;
				continue;
			}
			while (left >= 1 && array[left - 1] < array[left]) {
				left--;
			}
			while (right < array.length - 1 && array[right] > array[right + 1]) {
				right++;
			}
			int currPeakLength = right - left + 1;
			if (currPeakLength > longestPeakLength) {
				longestPeakLength = currPeakLength;
			}
			i = right + 1;
		}
    return longestPeakLength;
  }
}
