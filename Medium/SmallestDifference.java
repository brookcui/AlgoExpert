import java.util.*;

class Program {
	// O(nlog(n)+mlog(m)) time | O(1) space
	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		// Write your code here.
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int i = 0, j = 0;
		int smallestDiff = Integer.MAX_VALUE;
		int diff = Integer.MAX_VALUE;
		int[] smallestPair = new int[2];
		while (i < arrayOne.length && j < arrayTwo.length) {
			int first = arrayOne[i];
			int second = arrayTwo[j];
			if (first < second) {
				diff = second - first;
				i++;
			} else if (first > second) {
				diff = first - second;
				j++;
			} else {
				return new int[] { first, second };
			}
			if (diff < smallestDiff) {
				smallestDiff = diff;
				smallestPair = new int[] { first, second };
			}
		}
		return smallestPair;
	}
}
