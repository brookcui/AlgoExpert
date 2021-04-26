import java.util.*;

// Solution 1
class Program {
	// O(k^n) time | O(n) space
  public int staircaseTraversal(int height, int maxSteps) {
    // Write your code here.
		if (maxSteps == 0) {
			return -1;
		}
    if (height <= 1) {
			return 1;
		}
		int numOfWays = 0;
		for (int step = 1; step <= Math.min(maxSteps, height); step++) {
			numOfWays += staircaseTraversal(height - step, maxSteps);
		}
		return numOfWays;
  }
}

// Solution 2
class Program {
	// O(n * k) time | O(n) space
  public int staircaseTraversal(int height, int maxSteps) {
    // Write your code here.
		if (maxSteps == 0) {
			return -1;
		} else if (height <= 1) {
			return 1;
		}
		int[] dp = new int[height + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int h = 2; h <= height; h++) {
			for (int step = 1; step <= Math.min(maxSteps, h); step++) {
				dp[h] = dp[h] + dp[h-step];
			}
		}
    return dp[height];
  }
}
