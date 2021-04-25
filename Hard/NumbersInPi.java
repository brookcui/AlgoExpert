import java.util.*;

class Program {
	// O(n^3 + m) time | O(n + m) space - where n is the number of digits in Pi and m is the number of favorite numbers
  public static int numbersInPi(String pi, String[] numbers) {
    // Write your code here.
		Set<String> favoriteNumbers = new HashSet<>();
		for (String num : numbers) {
			favoriteNumbers.add(num);
		}
		int minSpaces = dfs(0, pi, favoriteNumbers, new HashMap<>());
    return (minSpaces == Integer.MAX_VALUE) ? -1 : minSpaces;
  }
	
	private static int dfs(int idx, String pi, Set<String> favoriteNumbers, Map<Integer, Integer> memo) {
		if (idx >= pi.length()) {
			return -1;
		}
		if (memo.containsKey(idx)) {
			return memo.get(idx);
		}
		int minSpaces = Integer.MAX_VALUE;
		for (int i = idx; i < pi.length(); i++) {
			String prefix = pi.substring(idx, i + 1);
			if (favoriteNumbers.contains(prefix)) {
				int tmp = dfs(i + 1, pi, favoriteNumbers, memo);
				if (tmp == Integer.MAX_VALUE) {
					continue;
				} else {
					minSpaces = Math.min(minSpaces, tmp + 1);
				}
			}
		}
		memo.put(idx, minSpaces);
		return memo.get(idx);
	}
}
