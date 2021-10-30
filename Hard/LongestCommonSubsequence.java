import java.util.*;

class Program {
	// O(mn) time | O(mn) space
	public static List<Character> longestCommonSubsequence(String str1, String str2) {
		// Write your code here.
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}
			}
		}
		return buildSequence(dp, str1);
	}

	private static List<Character> buildSequence(int[][] lengths, String baseStr) {
		List<Character> sequence = new ArrayList<Character>();
		int i = lengths.length - 1;
		int j = lengths[0].length - 1;
		while (i > 0 && j > 0) {
			if (lengths[i][j] == lengths[i - 1][j]) {
				i--;
			} else if (lengths[i][j] == lengths[i][j - 1]) {
				j--;
			} else {
				sequence.add(0, baseStr.charAt(i - 1));
				i--;
				j--;
			}
		}
		return sequence;
	}
}
