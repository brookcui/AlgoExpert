import java.util.*;

class Program {
	// O(n) time | O(1) space - where n is the number of queries
  public int minimumWaitingTime(int[] queries) {
    // Write your code here.
		Arrays.sort(queries);
		int remainQueries = queries.length;
		int totalWaitingTime = 0;
		for (int duration : queries) {
			--remainQueries;
			totalWaitingTime += remainQueries * duration;
		}
    return totalWaitingTime;
  }
}
