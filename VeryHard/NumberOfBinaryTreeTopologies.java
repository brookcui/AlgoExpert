import java.util.*;

// Solution 1
class Program {
	// O((n*(2n)!)/(n!(n+1)!)) | O(n) space
  public static int numberOfBinaryTreeTopologies(int n) {
    // Write your code here.
		if (n == 0) {
			return 1;
		}
		int num = 0;
		for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
			int rightTreeSize = n - 1 - leftTreeSize;
			int numLeft = numberOfBinaryTreeTopologies(leftTreeSize);
			int numRight = numberOfBinaryTreeTopologies(rightTreeSize);
			num += numLeft * numRight;
		}
    return num;
  }
}

// Solution 2
class Program {
	// O(n^2) time | O(n) space
  public static int numberOfBinaryTreeTopologies(int n) {
    // Write your code here.
		Map<Integer, Integer> memo = new HashMap<>();
		memo.put(0, 1);
		return dfs(n, memo);
  }
	
	private static int dfs(int n, Map<Integer, Integer> memo) {
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		int num = 0;
		for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
			int rightTreeSize = n - 1 - leftTreeSize;
			int numLeft = numberOfBinaryTreeTopologies(leftTreeSize);
			int numRight = numberOfBinaryTreeTopologies(rightTreeSize);
			num += numLeft * numRight;
		}
		memo.put(n, num);
    return num;
	}
}
