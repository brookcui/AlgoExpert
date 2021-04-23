import java.util.*;

class Program {
	// O(n^2) time | O(n) space
  public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
    // Write your code here.
		int[] dp = array.clone();
		int[] previousIndexes = new int[array.length];
		Arrays.fill(previousIndexes, -1);
		int maxSumIdx = 0;
		for (int j = 1; j < array.length; j++) {
			int num = array[j];
			for (int i = 0; i < j; i++) {
				int prevNum = array[i];
				if (num > prevNum && dp[i] + num >= dp[j]) {
					dp[j] = dp[i] + num;
					previousIndexes[j] = i;
				}
			}
			if (dp[j] >= dp[maxSumIdx]) {
				maxSumIdx = j;
			}
		}
		return buildSequence(array, previousIndexes, maxSumIdx, dp[maxSumIdx]);
  }
	
	private static List<List<Integer>> buildSequence(int[] array, int[] previousIndexes, int idx, int maxSum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<>());
		res.get(0).add(maxSum);
		res.add(new ArrayList<>());
		while (idx != -1) {
			res.get(1).add(0, array[idx]);
			idx = previousIndexes[idx];
		}
		return res;
	}
}
