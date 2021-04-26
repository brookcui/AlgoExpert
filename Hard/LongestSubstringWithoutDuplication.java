import java.util.*;

class Program {
	// O(n) time | O(min(m,n)) space - where n is the length of the string and m is the size of the charset
  public static String longestSubstringWithoutDuplication(String str) {
    // Write your code here
		if (str.length() == 0) {
			return "";
		}
		int[] longestRange = {0, 1};
		Map<Character, Integer> dict = new HashMap<>();
		int l = 0;
		for (int r = 0; r < str.length(); r++) {
			char ch = str.charAt(r);
			dict.put(ch, dict.getOrDefault(ch, 0) + 1);
			while (dict.getOrDefault(ch, 0) > 1) {
				dict.put(str.charAt(l), dict.get(str.charAt(l)) - 1);
				l++;
			}
			if (r + 1 - l > longestRange[1] - longestRange[0]) {
				longestRange[0] = l;
				longestRange[1] = r + 1;
			}
		}
    return str.substring(longestRange[0], longestRange[1]);
  }
}
