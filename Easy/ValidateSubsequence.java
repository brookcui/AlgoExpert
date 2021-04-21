import java.util.*;

class Program {
	// O(n) time | O(1) space
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Write your code here.
		int l = 0, r = 0;
		int m = array.size(), n = sequence.size();
		while (l < m && r < n) {
			if (array.get(l).equals(sequence.get(r))) {
				r++;
			}
			l++;
		}
    return r == n;
  }
}

