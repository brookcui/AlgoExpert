import java.util.*;

class Program {
	// O(n^2) time | O(n) space
	public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
		// Write your code here.
		int[] sequences = new int[array.length];
		Arrays.fill(sequences, Integer.MIN_VALUE);
		int[] dp = array.clone();
		int maxSumEndingIdx = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				// at each index, store the maximum sum that can be accumulated
				// also, mark the sequence indexes
				if (array[j] < array[i] && dp[j] + array[i] >= dp[i]) {
					dp[i] = dp[j] + array[i];
					sequences[i] = j; // keep track of potential sequences and store the previous numbers
				}
			}
			if (dp[i] >= dp[maxSumEndingIdx]) {
				maxSumEndingIdx = i;
			}
		}
		return buildSequence(array, sequences, maxSumEndingIdx, dp[maxSumEndingIdx]);
	}

	private static List<List<Integer>> buildSequence(int[] array, int[] sequences, int idx, int maxSum) {
		List<List<Integer>> sequence = new ArrayList<>();
		sequence.add(new ArrayList<>());
		sequence.get(0).add(maxSum);
		sequence.add(new ArrayList<>());
		while (idx != Integer.MIN_VALUE) {
			sequence.get(1).add(0, array[idx]);
			idx = sequences[idx];
		}
		return sequence;
	}
}
