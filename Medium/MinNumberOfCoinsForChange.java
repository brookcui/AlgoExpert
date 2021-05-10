import java.util.*;

class Program {
	// O(n) time | O(n) space
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    // Write your code here.
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;
		for (int denom : denoms) {
			for (int amount = 1; amount <= n; amount++) {
				if (denom <= amount) {
					dp[amount] = Math.min(dp[amount], dp[amount - denom] + 1);
				}
			}
		}
		if (dp[n] == Integer.MAX_VALUE - 1) {
			return -1;
		}
    return dp[n];
  }
}
