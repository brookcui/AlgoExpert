import java.util.*;

class Program {
  // Feel free to add new properties and methods to the class.
  static class MinMaxStack {
		List<int[]> minMaxStack = new ArrayList<>();
		List<Integer> stack = new ArrayList<>();
		
		// O(1) time | O(1) space
    public int peek() {
      // Write your code here.
      return stack.get(stack.size() - 1);
    }

		// O(1) time | O(1) space
    public int pop() {
      // Write your code here.
			minMaxStack.remove(minMaxStack.size() - 1);
      return stack.remove(stack.size() - 1);
    }

		// O(1) time | O(1) space
    public void push(Integer number) {
      // Write your code here.
			int[] minMax = new int[] {number, number};
			if (!minMaxStack.isEmpty()) {
				minMax[0] = Math.min(minMaxStack.get(minMaxStack.size() - 1)[0], minMax[0]);
				minMax[1] = Math.max(minMaxStack.get(minMaxStack.size() - 1)[1], minMax[1]);
			}
			minMaxStack.add(minMax);
			stack.add(number);
    }

		// O(1) time | O(1) space
    public int getMin() {
      // Write your code here.
      return minMaxStack.get(minMaxStack.size() - 1)[0];
    }

		// O(1) time | O(1) space
    public int getMax() {
      // Write your code here.
      return minMaxStack.get(minMaxStack.size() - 1)[1];
    }
  }
}
