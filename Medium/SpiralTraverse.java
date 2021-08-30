import java.util.*;

class Program {
	// O(n) time | O(n) space - where n is the total number of the array elements
	public static List<Integer> spiralTraverse(int[][] array) {
		// Write your code here.
		List<Integer> res = new ArrayList<>();
		if (array.length == 0) {
			return res;
		}
		int top = 0;
		int bottom = array.length - 1;
		int left = 0;
		int right = array[0].length - 1;
		while (top <= bottom && left <= right) {
			for (int col = left; col <= right; col++) {
				res.add(array[top][col]);
			}
			for (int row = top + 1; row <= bottom; row++) {
				res.add(array[row][right]);
			}
			for (int col = right - 1; col >= left; col--) {
				if (top == bottom) {
					break;
				}
				res.add(array[bottom][col]);
			}
			for (int row = bottom - 1; row >= top + 1; row--) {
				if (left == right) {
					break;
				}
				res.add(array[row][left]);
			}
			++left;
			--right;
			++top;
			--bottom;
		}
		return res;
	}
}
