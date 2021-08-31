import java.util.*;

class Program {
	// O(n) time | O(1) space
	public static int kadanesAlgorithm(int[] array) {
		// Write your code here.
		int sumEndingHere = array[0];
		int maxSumSoFar = array[0];
		for (int i = 1; i < array.length; i++) {
			int num = array[i];
			sumEndingHere = Math.max(num, sumEndingHere + num);
			maxSumSoFar = Math.max(maxSumSoFar, sumEndingHere);
		}
		return maxSumSoFar;
	}
}
