import java.util.*;

class Program {
  // Tip: You can use `element instanceof ArrayList` to check whether an item
  // is an array or an integer.
  public static int productSum(List<Object> array) {
    // Write your code here.
    return dfs(array, 1);
  }
	
	private static int dfs(List<Object> array, int multiplier) {
		int sum = 0;
		for (Object e : array) {
			if (e instanceof ArrayList) {
				sum += dfs((ArrayList<Object>) e, multiplier + 1);
			} else {
				sum += (int) e;
			}
		}
		return sum * multiplier;
	}
}
