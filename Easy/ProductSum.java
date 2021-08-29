import java.util.*;

class Program {
	// O(n) time | O(h) space - where n is the number of elements in the special
	// array and h is the maximum depth
	// Tip: You can use `element instanceof ArrayList` to check whether an item
	// is an array or an integer.
	public static int productSum(List<Object> array) {
		// Write your code here.
		int sum = 0;
		for (Object obj : array) {
			sum += calculateSumAtDepth(obj, 1);
			System.out.println(sum);
		}
		return sum;
	}

	private static int calculateSumAtDepth(Object o, int depth) {
		if (o instanceof ArrayList) {
			++depth;
			int sum = 0;
			for (Object obj : (ArrayList) o) {
				sum += depth * calculateSumAtDepth(obj, depth);
			}
			return sum;
		} else {
			return ((Integer) o).intValue();
		}
	}
}