import java.util.*;

class Program {
	// O(n) time | O(n) space
  public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
    // Write your code here.
		int maxArea = 0;
		if (buildings.size() == 0) {
			return 0;
		}
		buildings.add(0); // final sentinel
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < buildings.size(); i++) {
			int height = buildings.get(i);
			while (!stack.isEmpty() && buildings.get(stack.peek()) >= height) {
				int lastHeight = buildings.get(stack.pop());
				int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, width * lastHeight);
			}
			stack.add(i);
		}
    return maxArea;
  }
}
