import java.util.*;

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
