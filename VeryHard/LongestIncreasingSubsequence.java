import java.util.*;

// Solution 1
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

// Solution 2
class Program {
	// O(nlog(n)) time | O(n) space
  public static List<Integer> longestIncreasingSubsequence(int[] array) {
    // Write your code here.
		int n = array.length;
		if (n == 0) {
			return new ArrayList<>();
		}
		int[] sequences = new int[n];
		Arrays.fill(sequences, Integer.MIN_VALUE);
		int[] indices = new int[n + 1];
		Arrays.fill(indices, Integer.MIN_VALUE);
		int length = 0;
		for (int i = 0; i < n; i++) {
			int num = array[i];
			int newLength = binarySearch(array, indices, 1, length, num);
			sequences[i] = indices[newLength - 1];
			indices[newLength] = i;
			length = Math.max(length, newLength);
		}
    return buildSequence(array, sequences, indices[length]);
  }
	
	private static int binarySearch(int array[], int[] indices, int start, int end, int target) {
		int l = start, r = end;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (array[indices[m]] < target) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return l;
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
