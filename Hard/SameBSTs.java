import java.util.*;

class Program {
	// O(n^2) time | O(n^2) space
	public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
		// Write your code here.
		// If two arrays have equal sizes, it indicates that they have equal node number
		if (arrayOne.size() != arrayTwo.size()) {
			return false;
		}
		// If two arrays are both empty, then we've reached the leave nodes.
		if (arrayOne.size() == 0 && arrayTwo.size() == 0) {
			return true;
		}
		// Both root nodes should have equal values.
		int rootOne = arrayOne.get(0);
		int rootTwo = arrayTwo.get(0);
		if (rootOne != rootTwo) {
			return false;
		}
		// Partition each array into two subarrays, one with numbers smaller than
		// root value, another with numbers greater or equalthan root value
		List<Integer> leftOne = getSmallerNums(arrayOne);
		List<Integer> leftTwo = getSmallerNums(arrayTwo);
		List<Integer> rightOne = getGreaterOrEqualNums(arrayOne);
		List<Integer> rightTwo = getGreaterOrEqualNums(arrayTwo);
		// Each subarray should have equal BST structure
		return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
	}

	private static List<Integer> getSmallerNums(List<Integer> array) {
		List<Integer> smallerNums = new ArrayList<>();
		for (int i = 1; i < array.size(); i++) {
			if (array.get(i) < array.get(0)) {
				smallerNums.add(array.get(i));
			}
		}
		return smallerNums;
	}

	private static List<Integer> getGreaterOrEqualNums(List<Integer> array) {
		List<Integer> greaterOrEqualNums = new ArrayList<>();
		for (int i = 1; i < array.size(); i++) {
			if (array.get(i) >= array.get(0)) {
				greaterOrEqualNums.add(array.get(i));
			}
		}
		return greaterOrEqualNums;
	}
}
