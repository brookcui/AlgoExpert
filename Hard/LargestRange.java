import java.util.*;

class Program {
	// O(n) time | O(n) space
  public static int[] largestRange(int[] array) {
    // Write your code here.
		int[] largestRange = new int[2];
		int longestLen = 0;
		Map<Integer, Boolean> visited = new HashMap<>();
		for (int num : array) {
			visited.put(num, true);
		}
		for (int num : array) {
			if (!visited.containsKey(num) || !visited.get(num)) {
				continue;
			}
			int left = num, right = num, currLen = 1;
			while (visited.containsKey(left-1)) {
				left--;
				currLen++;
				visited.put(left, false);
			}
			while (visited.containsKey(right+1)) {
				right++;
				currLen++;
				visited.put(right, false);
			}
			if (currLen > longestLen) {
				longestLen = currLen;
				largestRange[0] = left;
				largestRange[1] = right;
			}
		}
    return largestRange;
  }
}
