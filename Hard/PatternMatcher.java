import java.util.*;

class Program {
	// O(C(s, p)) time | O(max(p, s)) space - where p is the length of pattern and s is the length of string
  public static String[] patternMatcher(String pattern, String str) {
    // Write your code here.
		if (pattern.length() > str.length()) {
			return new String[] {};
		}
		Map<Character, String> patternMap = new HashMap<>();
		Set<String> mappedStrings = new HashSet<>();
		if (isMatch(0, pattern, 0, str, patternMap, mappedStrings)) {
			String[] res = new String[2];
			res[0] = (patternMap.containsKey('x')) ? patternMap.get('x') : "";
			res[1] = (patternMap.containsKey('y')) ? patternMap.get('y') : "";
			return res;
		}
    return new String[] {};
  }
	
	private static boolean isMatch(int i, String pattern, int j, String str, Map<Character, String> patternMap, Set<String> mappedStrings) {
		if (i == pattern.length() && j == str.length()) {
			return true;
		}
		if (i >= pattern.length() || j >= str.length()) {
			return false;
		}
		char ch = pattern.charAt(i);
		if (patternMap.containsKey(ch)) {
			String s = patternMap.get(ch);
			if (!str.startsWith(s, j)) {
				return false;
			}
			return isMatch(i + 1, pattern, j + s.length(), str, patternMap, mappedStrings);
		} else {
			for (int k = j + 1; k <= str.length(); k++) {
				String s = str.substring(j, k);
				if (mappedStrings.contains(s)) {
					continue;
				}
				patternMap.put(ch, s);
				mappedStrings.add(s);
				if (isMatch(i + 1, pattern, k, str, patternMap, mappedStrings)) {
					return true;
				}
				patternMap.remove(ch);
				mappedStrings.remove(s);
			}
			return false;
		}
	}
}
