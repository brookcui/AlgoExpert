import java.util.*;

class Program {
	// O(n^2) time | O(n) space
  public static List<Integer> longestIncreasingSubsequence(int[] array) {
    // Write your code here.
		int n = array.length;
		if (n == 0) {
			return new ArrayList<>();
		}
		int[] sequences = new int[n];
		Arrays.fill(sequences, Integer.MIN_VALUE);
		int[] lengths = new int[n];
		Arrays.fill(lengths, 1);
		int maxLengthIdx = 0;
		for (int i = 1; i < n; i++) {
			int num = array[i];
			for (int j = 0; j < i; j++) {
				int otherNum = array[j];
				if (otherNum < num && lengths[j] + 1 > lengths[i]) {
					lengths[i] = lengths[j] + 1;
					sequences[i] = j;
				}
			}
			if (lengths[i] >= lengths[maxLengthIdx]) {
				maxLengthIdx = i;
			}
		}
    return buildSequence(array, sequences, maxLengthIdx);
  }
	
	private static List<Integer> buildSequence(int[] array, int[] sequences, int idx) {
		List<Integer> sequence = new ArrayList<>();
		while (idx != Integer.MIN_VALUE) {
			sequence.add(0, array[idx]);
			idx = sequences[idx];
		}
		return sequence;
	}
}
