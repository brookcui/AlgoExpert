import java.util.*;

class Program {
	// O(n) time | O(1) space
  public static boolean isMonotonic(int[] array) {
    // Write your code here.
		if (array.length <= 2) {
			return true;
		}
		int direction = array[1] - array[0];
		for (int i = 2; i < array.length; i++) {
			int diff = array[i] - array[i-1];
			if (direction == 0) {
				direction = diff;
				continue;
			} else if (direction > 0) {
				if (diff < 0) {
					return false;
				}
			} else if (direction < 0) {
				if (diff > 0) {
					return false;
				}
			}
		}
    return true;
  }
}
