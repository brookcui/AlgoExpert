import java.util.*;

// Solution 1
// class Program {
// 	// O(n) time | O(n) space
//   public static int waterArea(int[] heights) {
//     // Write your code here.
// 		int n = heights.length;
// 		if (n <= 2) {
// 			return 0;
// 		}
// 		int[] left = new int[n];
// 		int leftMax = heights[0];
// 		for (int i = 1; i < n - 1; i++) {
// 			left[i] = leftMax;
// 			leftMax = Math.max(leftMax, heights[i]);
// 		}
// 		int[] right = new int[n];
// 		int rightMax = heights[n-1];
// 		for (int i = n - 2; i >= 1; i--) {
// 			right[i] = rightMax;
// 			rightMax = Math.max(rightMax, heights[i]);
// 		}
// 		int total = 0;
// 		for (int i = 1; i < n - 1; i++) {
// 			total += Math.max(0, Math.min(left[i], right[i]) - heights[i]);
// 		}
//     return total;
//   }
// }

// Solution 2
class Program {
	// O(n) time | O(n) space
  public static int waterArea(int[] heights) {
    // Write your code here.
		int n = heights.length;
		if (n <= 2) {
			return 0;
		}
		int total = 0;
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (i < n) {
			while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
				int top = stack.pop();
				if (stack.isEmpty()) {
					break;
				}
				int distance = i - stack.peek() - 1;
				int boundedHeight = Math.min(heights[i], heights[stack.peek()]) - heights[top];
				total += distance * boundedHeight;
			}
			stack.push(i);
			i++;
		}
    return total;
  }
}
