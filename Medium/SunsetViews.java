import java.util.*;

class Program {
	// O(n) time | O(n) space
  public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
    // Write your code here.
		ArrayList<Integer> sunsetBuildings = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		if (direction.equals("EAST")) {
			for (int idx = 0; idx < buildings.length; idx++) {
				while (!stack.isEmpty() && buildings[stack.peek()] <= buildings[idx]) {
					stack.pop();
				}
				stack.push(idx);
			}
			while (!stack.isEmpty()) {
				sunsetBuildings.add(0, stack.pop());
			}
		} else if (direction.equals("WEST")) {
			for (int idx = buildings.length - 1; idx >= 0; idx--) {
				while (!stack.isEmpty() && buildings[stack.peek()] <= buildings[idx]) {
					stack.pop();
				}
				stack.push(idx);
			}
			while (!stack.isEmpty()) {
				sunsetBuildings.add(stack.pop());
			}
		} else {
    	return new ArrayList<Integer>();
		}
		return sunsetBuildings;
  }
}
