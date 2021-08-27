import java.util.*;

class Program {
	// O(n) time | O(n) space
  public int[] sortedSquaredArray(int[] array) {
    // Write your code here.
		int[] sortedSquares = new int[array.length];
		int l = 0, r = array.length - 1;
		for (int idx = array.length - 1; idx >= 0; idx--) {
			int left = array[l];
			int right = array[r];
			if (Math.abs(left) > Math.abs(right)) {
				sortedSquares[idx] = left * left;
				++l;
			} else {
				sortedSquares[idx] = right * right;
				--r;
			}
		}
    return sortedSquares;
  }
}
