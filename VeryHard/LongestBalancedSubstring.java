import java.util.*;

class Program {
	// O(n) time | O(n) space
  public int longestBalancedSubstring(String string) {
    // Write your code here.
		int maxLength = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					int leftIdx = stack.peek();
					maxLength = Math.max(maxLength, i - leftIdx);
				}
			}
		}
    return maxLength;
  }
}
