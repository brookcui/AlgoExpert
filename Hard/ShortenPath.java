import java.util.*;

class Program {
	// O(n) time | O(n) space
  public static String shortenPath(String path) {
    // Write your code here;
		if (path.isEmpty()) {
			return "";
		}
		if (path.equals("/")) {
			return path;
		}
		boolean startsWithPath = path.charAt(0) == '/';
		String[] tokens = path.split("/");
		Stack<String> stack = new Stack<>();
		if (startsWithPath) {
			stack.add("");
		}
		for (String token : tokens) {
			if (token.isEmpty() || token.equals(".")) {
				continue;
			} else if (token.equals("..")) {
				if (stack.isEmpty() || stack.peek().equals("..")) {
					stack.add(token);
				} else if (!stack.peek().equals("")) { // not root path
					stack.pop();
				}
			} else {
				stack.add(token);
			}
		}
		if (stack.size() == 1 && stack.peek().equals("")) {
			return "/";
		}
    return String.join("/", stack);
  }
}
