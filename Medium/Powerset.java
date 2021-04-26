import java.util.*;

class Program {
	// O(n*2^m) time | O(n*2^n) space
  public static List<List<Integer>> powerset(List<Integer> array) {
    // Write your code here.
    return helper(array, 0);
  }
	
	private static List<List<Integer>> helper(List<Integer> array, int idx) {
		if (idx >= array.size()) {
			List<List<Integer>> emptySet = new ArrayList<>();
			emptySet.add(new ArrayList<>());
			return emptySet;
		}
		int num = array.get(idx);
		List<List<Integer>> subsets = helper(array, idx + 1);
		int length = subsets.size();
		for (int i = 0; i < length; i++) {
			List<Integer> currSubset = new ArrayList<>(subsets.get(i));
			currSubset.add(num);
			subsets.add(currSubset);
		}
		return subsets;
	}
}
