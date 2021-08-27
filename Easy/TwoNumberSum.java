import java.util.*;

class Program {
	// O(n) time | O(n) space
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
		Set<Integer> set = new HashSet<>();
		for (int num : array) {
			int potentialMatch = targetSum - num;
			if (set.contains(potentialMatch)) {
				return new int[]{potentialMatch, num};
			} else {
				set.add(num);
			}
		}
    return new int[0];
  }
}

