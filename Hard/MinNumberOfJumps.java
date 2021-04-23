import java.util.*;

// Solution 1
class Program {
	// O(n^2) time | O(n) space
  public static int minNumberOfJumps(int[] array) {
    // Write your code here.
		if (array.length <= 1) {
			return 0;
		}
		if (array[0] == 0) {
			return -1;
		}
		int[] dp = new int[array.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] >= i - j) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
    return dp[dp.length-1];
  }
}

// Solution 2
class Program {
	// O(n) time | O(1) space
  public static int minNumberOfJumps(int[] array) {
    // Write your code here.
		if (array.length <= 1) {
			return 0;
		}
		if (array[0] == 0) {
			return -1;
		}
		int maxReach = array[0];
		int step = array[0];
		int jump = 1;
		for (int i = 1; i < array.length; i++) {
			if (i == array.length - 1) {
				return jump;
			}
			maxReach = Math.max(maxReach, i + array[i]);
			step--;
			if (step == 0) {
				jump++;
				if (i >= maxReach) {
					return -1;
				}
				step = maxReach - i;
			}
		}
		return -1;
  }
}
