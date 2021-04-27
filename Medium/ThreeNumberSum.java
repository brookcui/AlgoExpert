import java.util.*;

class Program {
	// O(n^2) time | O(n) sapce
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
		Arrays.sort(array);
		List<Integer[]> triplets = new ArrayList<>();
		for (int i = 0; i < array.length - 2; i++) {
			int l = i + 1;
			int r = array.length - 1;
			while (l < r) {
				int sum = array[i] + array[l] + array[r];
				if (sum == targetSum) {
					triplets.add(new Integer[] {array[i], array[l], array[r]});
					l++;
					r--;
				} else if (sum < targetSum) {
					l++;
				} else if (sum > targetSum) {
					r--;
				}
			}
		}
    return triplets;
  }
}
