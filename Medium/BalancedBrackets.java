import java.util.*;

class Program {
	// O(n) time | O(n) space
  public static boolean balancedBrackets(String str) {
    // Write your code here.
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);
			if (letter == '(' || letter == '[' || letter == '{') {
				stack.add(letter);
			} else if (letter == ')' || letter == ']' || letter == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				char lastLetter = stack.get(stack.size() - 1);
				if ((lastLetter == '(' && letter == ')')
						|| (lastLetter == '[' && letter == ']')
						|| (lastLetter == '{' && letter == '}')) {
					stack.remove(stack.size() - 1);
				} else {
					return false;
				}
			}
		}
    return stack.isEmpty();
  }
}
