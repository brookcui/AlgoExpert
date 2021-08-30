import java.util.*;

class Program {
	// O(n^2) time | O(n) space
	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		// Write your code here.
		Arrays.sort(array);
		List<Integer[]> triplets = new ArrayList<>();
		for (int i = 0; i < array.length - 2; i++) {
			int j = i + 1, k = array.length - 1;
			while (j < k) {
				int tripletSum = array[i] + array[j] + array[k];
				if (tripletSum > targetSum) {
					--k;
				} else if (tripletSum < targetSum) {
					++j;
				} else {
					triplets.add(new Integer[] { array[i], array[j], array[k] });
					++j;
					--k;
				}
			}
		}
		return triplets;
	}
}
