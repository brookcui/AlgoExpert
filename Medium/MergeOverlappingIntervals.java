import java.util.*;

class Program {
	// O(nlog(n)) time | O(n) space
	public int[][] mergeOverlappingIntervals(int[][] intervals) {
		// Write your code here.
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		List<int[]> mergedIntervals = new ArrayList<>();
		int[] currentInterval = intervals[0];
		mergedIntervals.add(currentInterval);
		for (int i = 1; i < intervals.length; i++) {
			int currentIntervalEnd = currentInterval[1];
			int[] nextInterval = intervals[i];
			int nextIntervalStart = nextInterval[0];
			int nextIntervalEnd = nextInterval[1];
			if (currentIntervalEnd >= nextIntervalStart) { // overlapped
				currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
			} else {
				currentInterval = nextInterval;
				mergedIntervals.add(currentInterval);
			}
		}
		return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
	}
}
