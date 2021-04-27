import java.util.*;

class Program {
	// O(n^3) time | O(n^2) space
  public static boolean squareOfZeroes(List<List<Integer>> matrix) {
    // Write your code here.
		int n = matrix.size();
		if (n <= 1) {
			return false;
		}
		int[][][] dp = new int[n][n][2];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (matrix.get(r).get(c) == 0) {
					dp[r][c][0] = 1;
					dp[r][c][1] = 1;
				}
			}
		}
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (matrix.get(r).get(c) == 0) {
					if (r == 0 && c == 0) {
						continue;
					} else if (r == 0) {
						dp[r][c][0] = dp[r][c - 1][0] + 1;
					} else if (c == 0) {
						dp[r][c][1] = dp[r - 1][c][1] + 1;
					} else {
						dp[r][c][0] = dp[r][c - 1][0] + 1;
						dp[r][c][1] = dp[r - 1][c][1] + 1;
					}
				}
			}
		}
		for (int r = 0; r < n - 1; r++) {
			for (int c = 0; c < n - 1; c++) {
				int squareLength = 2;
				while (r <= n - squareLength && c <= n - squareLength) {
					int topRow = r;
					int leftCol = c;
					int bottomRow = r + squareLength - 1;
					int rightCol = c + squareLength - 1;
					if (isSquareOfZeroes(dp, squareLength, topRow, leftCol, bottomRow, rightCol)) {
						return true;
					}
					squareLength++;
				}
			}
		}
    return false;
  }
	
	private static boolean isSquareOfZeroes(int[][][] dp, int squareLength, int top, int left, int bottom, int right) {
		return dp[top][right][0] >= squareLength
			&& dp[bottom][left][1] >= squareLength
			&& dp[bottom][right][0] >= squareLength
			&& dp[bottom][right][1] >= squareLength;
	}
}
