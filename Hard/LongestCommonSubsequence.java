import java.util.*;

class Program {
	// O(nm * min(m,n)) time | O(nm * min(m,n)) space
  public static List<Character> longestCommonSubsequence(String str1, String str2) {
    // Write your code here.
		List<List<List<Character>>> lcs = new ArrayList<>();
		int m = str1.length(), n = str2.length();
		for (int i = 0; i <= m; i++) {
			lcs.add(new ArrayList<>());
			for (int j = 0; j <= n; j++) {
				lcs.get(i).add(new ArrayList<>());
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					List<Character> copy = new ArrayList<Character>(lcs.get(i).get(j));
					copy.add(str1.charAt(i));
					lcs.get(i+1).set(j+1, copy);
				} else {
					if (lcs.get(i).get(j+1).size() > lcs.get(i+1).get(j).size()) {
						lcs.get(i+1).set(j+1, lcs.get(i).get(j+1));
					} else {
						lcs.get(i+1).set(j+1, lcs.get(i+1).get(j));
					}
				}
			}
		}
    return lcs.get(m).get(n);
  }
}
