import java.util.*;

class Program {
	// O(n) time | O(1) space
	public static boolean hasSingleCycle(int[] array) {
		// Write your code here.
		int n = array.length;
		int index = 0;
		int numVisited = 0;
		while (numVisited < n) {
			if (numVisited > 0 && index == 0) {
				return false;
			}
			index = indexAfterJump(index, array);
			++numVisited;
		}
		return index == 0;
	}

	private static int indexAfterJump(int currentIndex, int[] array) {
		int jump = array[currentIndex];
		int nextIndex = (currentIndex + jump) % array.length;
		return nextIndex >= 0 ? nextIndex : nextIndex + array.length;
	}
}
