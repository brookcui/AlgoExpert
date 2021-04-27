import java.util.*;

class Program {
	// O(b + s) time | O(b + s) space
  public static String smallestSubstringContaining(String bigString, String smallString) {
    // Write your code here.
		Map<Character, Integer> targetCharsCount = new HashMap<>();
		for (char ch : smallString.toCharArray()) {
			targetCharsCount.put(ch, targetCharsCount.getOrDefault(ch, 0) + 1);
		}
		int length = bigString.length();
		int[] bound = new int[] {0, Integer.MAX_VALUE};
		int left = 0, right = 0;
		Map<Character, Integer> substringCharsCount = new HashMap<>();
		int numUniqueChars = 0;
		while (right < length) {
			char ch = bigString.charAt(right);
			if (!targetCharsCount.containsKey(ch)) {
				right++;
				continue;
			}
			substringCharsCount.put(ch, substringCharsCount.getOrDefault(ch, 0) + 1);
			if (substringCharsCount.get(ch).equals(targetCharsCount.get(ch))) {
				numUniqueChars++;
			}
			while (numUniqueChars == targetCharsCount.size() && left <= right) {
				bound = getCloserBound(bound, new int[] {left, right});
				char leftCh = bigString.charAt(left);
				if (!targetCharsCount.containsKey(leftCh)) {
					left++;
					continue;
				}
				if (substringCharsCount.get(leftCh).equals(targetCharsCount.get(leftCh))) {
					numUniqueChars--;
				}
				substringCharsCount.put(leftCh, substringCharsCount.getOrDefault(leftCh, 0) - 1);
				left++;
			}
			right++;
		}
		if (bound[1] == Integer.MAX_VALUE) {
			return "";
		}
    return bigString.substring(bound[0], bound[1] + 1);
  }
	
	private static int[] getCloserBound(int[] originalBound, int[] bound) {
		if (bound[1] - bound[0] < originalBound[1] - originalBound[0]) {
			return bound;
		}
		return originalBound;
	}
}
