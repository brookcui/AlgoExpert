import java.util.*;

class Program {
	// O(n) time | O(1) space
  public int validStartingCity(int[] distances, int[] fuel, int mpg) {
    // Write your code here.
		int n = distances.length;
		int remain = 0;
		int startIndex = 0;
		int remainFromStartIndex = 0;
		for (int idx = 1; idx < n; idx++) {
			remain += fuel[idx - 1] * mpg - distances[idx - 1];
			if (remain < remainFromStartIndex) {
				remainFromStartIndex = remain;
				startIndex = idx;
			}
		}
    return startIndex;
  }
}
