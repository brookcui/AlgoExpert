import java.util.*;

class Program {
	// O(nlog(n) + mlog(m)) time | O(1) space
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int l = 0;
		int r = 0;
		int smallestDiff = Integer.MAX_VALUE;
		int diff = Integer.MAX_VALUE;
		int[] smallestDiffPair = new int[2];
		while (l < arrayOne.length && r < arrayTwo.length) {
			int first = arrayOne[l];
			int second = arrayTwo[r];
			if (first < second) {
				diff = second - first;
				l++;
			} else if (first > second) {
				diff = first - second;
				r++;
			} else {
				return new int[] {first, second};
			}
			if (diff < smallestDiff) {
				smallestDiff = diff;
				smallestDiffPair = new int[] {first, second};
			}
		}
    return smallestDiffPair;
  }
}
