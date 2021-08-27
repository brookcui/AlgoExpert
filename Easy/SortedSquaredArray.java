import java.util.*;

class Program {
	// O(nlog(n)) time | O(n) space
  public int[] sortedSquaredArray(int[] array) {
    // Write your code here.
		int[] sortedSquares = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			int value = array[i];
			sortedSquares[i] = value * value;
		}
		Arrays.sort(sortedSquares);
    return sortedSquares;
  }
}
