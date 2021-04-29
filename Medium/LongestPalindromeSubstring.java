import java.util.*;

class Program {
	// O(n^2) time | O(n) space
  public static String longestPalindromicSubstring(String str) {
    // Write your code here.
		if (str.length() <= 1) {
			return str;
		}
		int[] longestRange = {0, 1};
		for (int i = 1; i < str.length(); i++) {
			int[] odd = getLongestPalindromeFrom(str, i - 1, i + 1);
			int[] even = getLongestPalindromeFrom(str, i - 1, i);
			int[] longerOne = (odd[1] - odd[0] > even[1] - even[0]) ? odd : even;
			longestRange = (longerOne[1] - longerOne[0] > longestRange[1] - longestRange[0]) ? longerOne : longestRange;
		}
    return str.substring(longestRange[0], longestRange[1]);
  }
	
	private static int[] getLongestPalindromeFrom(String str, int left, int right) {
		while (left >= 0 && right < str.length()) {
			if (str.charAt(left) != str.charAt(right)) {
				break;
			}
			left--;
			right++;
		}
		return new int[] {left + 1, right};
	}
}
