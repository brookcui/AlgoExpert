import java.util.*;

class Program {
	// O(n^2) time | O(n^2) space
  public static int palindromePartitioningMinCuts(String str) {
    // Write your code here.
		int length = str.length();
		if (length <= 1) {
			return 0;
		}
		boolean[][] dp = new boolean[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i == j) {
					dp[i][j] = true;
				} else {
					dp[i][j] = false;
				}
			}
		}
		for (int j = 1; j < length; j++) {
			for (int i = 0; i < j; i++) {
				if (str.charAt(i) == str.charAt(j) && (i + 1 > j - 1 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
				}
			}
		}
		int[] cuts = new int[length];
		Arrays.fill(cuts, Integer.MAX_VALUE);
		for (int i = 0; i < length; i++) {
			if (dp[0][i]) {
				cuts[i] = 0;
			} else {
				cuts[i] = cuts[i - 1] + 1;
				for (int j = 1; j < i; j++) {
					if (dp[j][i] && cuts[j - 1] + 1 < cuts[i]) {
						cuts[i] = cuts[j - 1] + 1;
					}
				}
			}
		}
    return cuts[length - 1];
  }
}
