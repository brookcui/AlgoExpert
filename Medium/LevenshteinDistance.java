import java.util.*;

class Program {
	// O(mn) time | O(mn) space
	public static int levenshteinDistance(String str1, String str2) {
		// Write your code here.
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = j;
			}
			dp[i][0] = i;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					dp[i + 1][j + 1] = 1 + Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1]));
				}
			}
		}
		return dp[m][n];
	}
}
