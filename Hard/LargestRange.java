import java.util.*;

class Program {
	// O(n) time | O(n) space
	public static int[] largestRange(int[] array) {
		// Write your code here.
		// record each number in a hash table
		Map<Integer, Boolean> records = new HashMap<>();
		for (int num : array) {
			records.put(num, true);
		}
		// explore possible ranges
		int longestLength = 0;
		int[] largestRange = new int[] { -1, -1 };
		for (int num : array) {
			if (!records.get(num)) { // skip those visited ones
				continue;
			}
			records.put(num, false); // mark as visited
			int length = 1;
			int left = num - 1;
			while (records.containsKey(left)) {
				records.put(left, false); // mark as visited
				left--;
				length++;
			}
			int right = num + 1;
			while (records.containsKey(right)) {
				records.put(right, false); // mark as visited
				right++;
				length++;
			}
			if (length > longestLength) { // the longer range wins
				longestLength = length;
				largestRange = new int[] { left + 1, right - 1 };
			}
		}
		return largestRange;
	}
}
