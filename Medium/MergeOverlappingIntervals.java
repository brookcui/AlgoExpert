import java.util.*;

class Program {
	// O(nlog(n)) time | O(n) space
  public int[][] mergeOverlappingIntervals(int[][] intervals) {
    // Write your code here.
		int[][] sortedIntervals = intervals.clone();
		Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));
		List<int[]> mergedIntervals = new ArrayList<>();
		for (int[] interval : sortedIntervals) {
			if (mergedIntervals.isEmpty() || interval[0] > mergedIntervals.get(mergedIntervals.size() - 1)[1]) {
				mergedIntervals.add(interval);
			} else {
				mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math.max(mergedIntervals.get(mergedIntervals.size() - 1)[1], interval[1]);
			}
		}
    return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
  }
}
