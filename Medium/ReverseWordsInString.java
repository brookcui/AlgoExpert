import java.util.*;

class Program {
	// O(n) time | O(n) space
  public String reverseWordsInString(String string) {
    // Write your code here.
		List<String> words = new ArrayList<>();
		int startOfWord = 0;
		for (int idx = 0; idx < string.length(); idx++) {
			char letter = string.charAt(idx);
			if (letter == ' ') {
				words.add(string.substring(startOfWord, idx));
				startOfWord = idx;
			} else if (string.charAt(startOfWord) == ' ') {
				words.add(" ");
				startOfWord = idx;
			}
		}
		words.add(string.substring(startOfWord));
		Collections.reverse(words);
    return String.join("", words);
  }
}
