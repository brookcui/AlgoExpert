import java.util.*;

class Program {
	// O(n) time | O(1) space
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    // Write your code here.
		int length = array.size();
		if (length <= 1) {
			return array;
		}
		int slow = 0;
		int fast = length - 1;
		while (slow < fast) {
			while (slow < fast && array.get(fast) == toMove) {
				fast--;
			}
			while (slow < fast && array.get(slow) != toMove) {
				slow++;
			}
			int tmp = array.get(slow);
			array.set(slow, array.get(fast));
			array.set(fast, tmp);
			slow++;
			fast--;
		}
    return array;
  }
}
