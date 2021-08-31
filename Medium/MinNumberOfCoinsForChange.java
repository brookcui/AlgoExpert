import java.util.*;

class Program {
	// O(nd) time | O(n) space
	public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		// Write your code here.
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int denom : denoms) {
			for (int amount = 0; amount <= n; amount++) {
				if (denom <= amount) {
					int toCompare = Integer.MAX_VALUE;
					if (dp[amount - denom] != Integer.MAX_VALUE) {
						toCompare = dp[amount - denom] + 1;
					}
					dp[amount] = Math.min(dp[amount], toCompare);
				}
			}
		}
		return dp[n] != Integer.MAX_VALUE ? dp[n] : -1;
	}
}
