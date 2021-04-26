import java.util.*;

class Program {
	// O(mn) time | O(mn) space
  public static boolean interweavingStrings(String one, String two, String three) {
    // Write your code here.
		if (one.length() + two.length() != three.length()) {
			return false;
		}
		Boolean[][] memo = new Boolean[one.length()+1][two.length()+1];
    return dfs(one, two, three, 0, 0, memo);
  }
	
	private static Boolean dfs(String one, String two, String three, int i, int j, Boolean[][] memo) {
		if (memo[i][j] != null) {
			return memo[i][j];
		}
		int k = i + j;
		if (k == three.length()) {
			return true;
		}
		if (i < one.length() && one.charAt(i) == three.charAt(k)) {
			memo[i][j] = dfs(one, two, three, i + 1, j, memo);
			if (memo[i][j]) {
				return true;
			}
		}
		if (j < two.length() && two.charAt(j) == three.charAt(k)) {
			memo[i][j] = dfs(one, two, three, i, j + 1, memo);
			if (memo[i][j]) {
				return true;
			}
		}
		memo[i][j] = false;
		return memo[i][j];
	}
}
