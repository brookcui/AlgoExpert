import java.util.*;

class Program {
	// O(nk) time | O(nk) space
  public static int maxProfitWithKTransactions(int[] prices, int k) {
    // Write your code here.
		if (prices.length <= 1) {
			return 0;
		}
		int maxProfit = 0;
		// dp[d][t]: the current max profit at day d after used t transactions
		int[][] dp = new int[k+1][prices.length];
		for (int t = 1; t <= k; t++) {
			int tmpMaxProfit = Integer.MIN_VALUE;
			for (int d = 1; d < prices.length; d++) {
				tmpMaxProfit = Math.max(tmpMaxProfit, dp[t-1][d-1] - prices[d-1]);
				dp[t][d] = Math.max(dp[t][d-1], tmpMaxProfit + prices[d]);
			}
		}
    return dp[k][prices.length-1];
  }
}

