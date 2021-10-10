import java.util.*;

class Program {
	// O(mn) time | O(mn) space
	public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
		// Write your code here.
		int height = array.size();
		int width = array.get(0).size();
		List<Integer> output = new ArrayList<Integer>();
		boolean isGoingDown = true;
		int row = 0;
		int col = 0;
		while (0 <= row && row < height && 0 <= col && col < width) {
			output.add(array.get(row).get(col));
			if (isGoingDown) {
				if (col == 0 || row == height - 1) {
					isGoingDown = false;
					if (row == height - 1) {
						col++;
					} else {
						row++;
					}
				} else {
					row++;
					col--;
				}
			} else {
				if (row == 0 || col == width - 1) {
					isGoingDown = true;
					if (col == width - 1) {
						row++;
					} else {
						col++;
					}
				} else {
					row--;
					col++;
				}
			}
		}
		return output;
	}
}
