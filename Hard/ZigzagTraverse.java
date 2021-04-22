import java.util.*;

class Program {
	// O(n) time | O(n) space
  public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
    // Write your code here.
		int m = array.size(); // height
		int n = array.get(0).size(); // width
		List<Integer> output = new ArrayList<>();
		int r = 0, c = 0;
		boolean goingDown = true;
		while (!isOutOfBounds(r, c, m, n)) {
			output.add(array.get(r).get(c));
			if (goingDown) {
				if (c == 0 || r == m - 1) {
					goingDown = false; // turn
					if (r == m - 1) {
						c++;
					} else {
						r++;
					}
				} else {
					r++;
					c--;
				}
			} else {
				if (r == 0 || c == n - 1) {
					goingDown = true;
					if (c == n - 1) {
						r++;
					} else {
						c++;
					}
				} else {
					r--;
					c++;
				}
			}
		}
    return output;
  }
	
	private static boolean isOutOfBounds(int r, int c, int m, int n) {
		return r < 0 || r >= m || c < 0 || c >= n;
	}
}
