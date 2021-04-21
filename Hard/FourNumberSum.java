import java.util.*;

class Program {
  public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
    // Write your code here.
		List<Integer[]> quadruplets = new ArrayList<>();
		Map<Integer, List<Integer[]>> allPairs = new HashMap<>();
		for (int i = 1; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int currSum = array[i] + array[j];
				int complement = targetSum - currSum;
				if (allPairs.containsKey(complement)) {
					for (Integer[] pair: allPairs.get(complement)) {
						Integer[] quadruplet = {pair[0], pair[1], array[i], array[j]};
						quadruplets.add(quadruplet);
					}
				}
			}
			for (int k = 0; k < i; k++) {
				int currSum = array[k] + array[i];
				Integer[] pair = {array[k], array[i]};
				if (!allPairs.containsKey(currSum)) {
					allPairs.put(currSum, new ArrayList<>());
				}
				allPairs.get(currSum).add(pair);
			}
		}
    return quadruplets;
  }
}

