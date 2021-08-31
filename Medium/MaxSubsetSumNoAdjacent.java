import java.util.*;

class Program {
	// O(n) time | O(n) space
	public static int maxSubsetSumNoAdjacent(int[] array) {
		// Write your code here.
		if (array.length == 0) {
			return 0;
		} else if (array.length == 1) {
			return array[0];
		}
		int[] dp = array.clone();
		dp[1] = Math.max(array[0], array[1]);
		for (int i = 2; i < array.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i]);
		}
		return dp[array.length - 1];
	}
}
