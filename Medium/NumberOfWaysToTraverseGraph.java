import java.util.*;

// Solution 1
class Program {
	// O(hw) time | O(hw) space
  public int numberOfWaysToTraverseGraph(int width, int height) {
    // Write your code here.
		int[][] dp = new int[height + 1][width + 1];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (i == 0 || j == 0) {
					dp[i + 1][j + 1] = 1;
				} else {
					dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j];
				}
			}
		}
    return dp[height][width];
  }
}

// Solution 2
class Program {
	// O(h + w) time | O(1) space
  public int numberOfWaysToTraverseGraph(int width, int height) {
    // Write your code here.
		int numerator = factorial(height - 1 + width - 1);
		int denominator = factorial(height - 1) * factorial(width - 1);
    return numerator / denominator;
  }
	
	private int factorial(int num) {
		int res = 1;
		for (int n = 2; n <= num; n++) {
			res *= n;
		}
		return res;
	}
}
