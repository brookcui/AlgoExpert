import java.util.*;

class Program {
	// O(nd) time | O(n) space
	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		// Write your code here.
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int denom : denoms) {
			for (int amount = 1; amount <= n; amount++) {
				if (amount - denom >= 0) {
					dp[amount] += dp[amount - denom];
				}
			}
		}
		return dp[n];
	}
}
