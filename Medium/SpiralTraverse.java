import java.util.*;

class Program {
	// O(n) time | O(n) space
  public static List<Integer> spiralTraverse(int[][] array) {
    // Write your code here.
		if (array.length == 0 || array[0].length == 0) {
			return new ArrayList<Integer>();
		}
		List<Integer> order = new ArrayList<Integer>();
		int top = 0, bottom = array.length - 1, left = 0, right = array[0].length - 1;
		while (top <= bottom && left <= right) {
			for (int col = left; col <= right; col++) {
				order.add(array[top][col]);
			}
			for (int row = top + 1; row <= bottom; row++) {
				order.add(array[row][right]);
			}
			if (top == bottom) {
				break;
			}
			for (int col = right - 1; col >= left; col--) {
				order.add(array[bottom][col]);
			}
			if (left == right) {
				break;
			}
			for (int row = bottom - 1; row > top; row--) {
				order.add(array[row][left]);
			}
			top++;
			bottom--;
			left++;
			right--;
		}
    return order;
  }
}
