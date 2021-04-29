import java.util.*;

class Program {
	// O(n * w * log(w)) time | O(nw) space
  public static List<List<String>> groupAnagrams(List<String> words) {
    // Write your code here.
		Map<String, List<String>> anagrams = new HashMap<>();
		for (String word : words) {
			char[] charArray = word.toCharArray();
			Arrays.sort(charArray);
			String sortedWord = new String(charArray);
			if (!anagrams.containsKey(sortedWord)) {
				anagrams.put(sortedWord, new ArrayList<>());
			}
			anagrams.get(sortedWord).add(word);
		}
    return new ArrayList(anagrams.values());
  }
}
