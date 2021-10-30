import java.util.*;

class Program {
	// O(n) time | O(1) space
	public static int minNumberOfJumps(int[] array) {
		// Write your code here.
		if (array.length == 1) {
			return 0;
		}
		int jumps = 1;
		int farthest = array[0];
		int steps = array[0];
		for (int i = 1; i < array.length - 1; i++) {
			farthest = Math.max(farthest, i + array[i]);
			steps--;
			if (steps == 0) {
				jumps++;
				steps = farthest - i;
			}
		}
		return jumps;
	}
}
