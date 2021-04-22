import java.util.*;

class Program {
	// O(n^2) time | O(n^2) space
  public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
    // Write your code here.
		if (arrayOne.size() != arrayTwo.size()) {
			return false;
		}
		if (arrayOne.size() == 0 && arrayTwo.size() == 0) {
			return true;
		}
		if (arrayOne.get(0) != arrayTwo.get(0)) {
			return false;
		}
		List<Integer> leftOne = getSmallerNumbers(arrayOne);
		List<Integer> rightOne = getBiggerOrEqualNumbers(arrayOne);
		List<Integer> leftTwo = getSmallerNumbers(arrayTwo);
		List<Integer> rightTwo = getBiggerOrEqualNumbers(arrayTwo);
    return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
  }
	
	private static List<Integer> getSmallerNumbers(List<Integer> array) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i < array.size(); i++) {
			if (array.get(i) < array.get(0)) {
				res.add(array.get(i));
			}
		}
		return res;
	}
	
	private static List<Integer> getBiggerOrEqualNumbers(List<Integer> array) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i < array.size(); i++) {
			if (array.get(i) >= array.get(0)) {
				res.add(array.get(i));
			}
		}
		return res;
	}
}
