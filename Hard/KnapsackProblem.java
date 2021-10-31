import java.util.*;

class Program {
	// O(nc) time | O(nc) space
	public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
		// Write your code here.
		int[][] dp = new int[items.length + 1][capacity + 1];
		for (int i = 0; i < items.length; i++) {
			int value = items[i][0];
			int weight = items[i][1];
			for (int c = 0; c <= capacity; c++) {
				if (weight > c) {
					dp[i + 1][c] = dp[i][c];
				} else {
					dp[i + 1][c] = Math.max(dp[i][c], dp[i][c - weight] + value);
				}
			}
		}
		return buildCombinedResult(dp, items, capacity, dp[items.length][capacity]);
	}

	private static List<List<Integer>> buildCombinedResult(int[][] dp, int[][] items, int capacity, int maxValue) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> values = List.of(maxValue);
		result.add(values);
		result.add(new ArrayList<>());
		int i = items.length;
		int c = capacity;
		while (i > 0) {
			if (dp[i][c] == dp[i - 1][c]) {
				i--;
			} else {
				result.get(1).add(0, i - 1);
				c -= items[i - 1][1];
				i--;
			}
			if (c == 0) {
				break;
			}
		}
		return result;
	}
}
