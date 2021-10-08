import java.util.*;

class Program {
	// Average: O(n^2) time | O(n^2) space
	// Worst: O(n^3) time | O(n^2) space
	public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
		// Write your code here.
		List<Integer[]> quadruplets = new ArrayList<>();
		Map<Integer, List<Integer[]>> pairSums = new HashMap<>();
		for (int i = 1; i < array.length - 1; i++) {
			int k = i;
			for (int l = k + 1; l < array.length; l++) {
				int currSum = array[k] + array[l];
				int diff = targetSum - currSum;
				if (pairSums.containsKey(diff)) {
					for (Integer[] pair : pairSums.get(diff)) {
						Integer[] quadruplet = { pair[0], pair[1], array[k], array[l] };
						quadruplets.add(quadruplet);
					}
				}
			}
			for (int j = 0; j < i; j++) {
				int currSum = array[i] + array[j];
				Integer[] pair = { array[i], array[j] };
				if (!pairSums.containsKey(currSum)) {
					pairSums.put(currSum, new ArrayList<>());
				}
				pairSums.get(currSum).add(pair);
			}
		}
		return quadruplets;
	}
}
