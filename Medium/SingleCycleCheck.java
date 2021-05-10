import java.util.*;

class Program {
	// O(n) time | O(1) space
  public static boolean hasSingleCycle(int[] array) {
    // Write your code here.
		int n = array.length;
		int visited = 0;
		int idx = 0;
		while (visited < n) {
			if (visited > 0 && idx == 0) {
				return false;
			}
			visited++;
			int nextIdx = (idx + array[idx]) % n;
			idx = nextIdx >= 0 ? nextIdx : nextIdx + n;
		}
    return idx == 0;
  }
}
