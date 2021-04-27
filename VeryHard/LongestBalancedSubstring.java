import java.util.*;

// Solution 1
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

// Solution 2
class Program {
	// O(n) time | O(1) space
  public int longestBalancedSubstring(String string) {
    // Write your code here.
		int maxLength = 0;
		int opening = 0;
		int closing = 0;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '(') {
				opening++;
			} else {
				closing++;
			}
			if (opening == closing) {
				maxLength = Math.max(maxLength, opening + closing);
			} else if (closing > opening) {
				opening = 0;
				closing = 0;
			}
		}
		opening = 0;
		closing = 0;
		for (int i = string.length() - 1; i >= 0; i--) {
			char c = string.charAt(i);
			if (c == ')') {
				opening++;
			} else {
				closing++;
			}
			if (opening == closing) {
				maxLength = Math.max(maxLength, opening + closing);
			} else if (closing > opening) {
				opening = 0;
				closing = 0;
			}
		}
    return maxLength;
  }
}
