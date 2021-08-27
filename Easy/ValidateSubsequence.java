import java.util.*;

class Program {
	// O(n) time | O(1) space - where n is the length of the array
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Write your code here.
		int m = array.size(), n = sequence.size();
		int l = 0, r = 0;
		while (l < m && r < n) {
			if (array.get(l).equals(sequence.get(r))) {
				++r;
			}
			++l;
		}
    return r == n;
  }
}

