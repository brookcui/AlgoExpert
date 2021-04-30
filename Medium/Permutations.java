import java.util.*;

class Program {
	// Upper Bound: O(n^2*n!) time | O(n*n!) space
	// Roughly: O(n*n!) time | O(n*n!) space
  public static List<List<Integer>> getPermutations(List<Integer> array) {
    // Write your code here.
		List<List<Integer>> permutations = new ArrayList<>();
		permutations(array, new ArrayList<>(), permutations);
    return permutations;
  }
	
	private static void permutations(List<Integer> array, List<Integer> permutation, List<List<Integer>> permutations) {
		if (array.size() == 0 && permutation.size() > 0) {
			permutations.add(new ArrayList<>(permutation));
			return;
		}
		for (int i = 0; i < array.size(); i++) {
			int value = array.remove(i);
			permutation.add(value);
			permutations(array, permutation, permutations);
			permutation.remove(permutation.size() - 1);
			array.add(i, value);
		}
	}
}
