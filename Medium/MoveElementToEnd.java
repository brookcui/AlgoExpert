import java.util.*;

class Program {
	// O(n) time | O(1) space
	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		// Write your code here.
		int i = 0, j = array.size() - 1;
		while (i < j) {
			while (i < j && array.get(j) == toMove) {
				--j;
			}
			int temp = array.get(j);
			array.set(j, array.get(i));
			array.set(i, temp);
			++i;
		}
		return array;
	}
}
