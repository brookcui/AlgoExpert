import java.util.*;

class Program {
	// O(n) time | O(n) space
  public static int waterArea(int[] heights) {
    // Write your code here.
		int n = heights.length;
		if (n <= 2) {
			return 0;
		}
		int[] left = new int[n];
		int leftMax = heights[0];
		for (int i = 1; i < n - 1; i++) {
			left[i] = leftMax;
			leftMax = Math.max(leftMax, heights[i]);
		}
		int[] right = new int[n];
		int rightMax = heights[n-1];
		for (int i = n - 2; i >= 1; i--) {
			right[i] = rightMax;
			rightMax = Math.max(rightMax, heights[i]);
		}
		int total = 0;
		for (int i = 1; i < n - 1; i++) {
			total += Math.max(0, Math.min(left[i], right[i]) - heights[i]);
		}
    return total;
  }
}
