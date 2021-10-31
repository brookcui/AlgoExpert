import java.util.*;

class Program {
	// O(n) time | O(n) space
	public static int waterArea(int[] heights) {
		// Write your code here.
		if (heights.length == 0) {
			return 0;
		}
		int[] containerHeights = new int[heights.length];
		int leftMax = 0;
		for (int i = 0; i < heights.length; i++) {
			int height = heights[i];
			containerHeights[i] = leftMax;
			leftMax = Math.max(leftMax, height);
		}
		int rightMax = 0;
		for (int i = heights.length - 1; i >= 0; i--) {
			int height = heights[i];
			int minHeight = Math.min(rightMax, containerHeights[i]);
			if (height < minHeight) {
				containerHeights[i] = minHeight - height;
			} else {
				containerHeights[i] = 0;
			}
			rightMax = Math.max(rightMax, height);
		}
		int totalArea = 0;
		for (int i = 0; i < heights.length; i++) {
			totalArea += containerHeights[i];
		}
		return totalArea;
	}
}
