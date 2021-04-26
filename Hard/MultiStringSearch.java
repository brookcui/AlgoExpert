import java.util.*;

class Program {
	// O(ns + bs) time | O(ns) space
  public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
    // Write your code here.
		List<Boolean> res = new ArrayList<Boolean>();
		Trie trie = new Trie();
		for (String smallStr : smallStrings) {
			trie.add(smallStr);
		}
		Set<String> containedStrings = new HashSet<>();
		for (int i = 0; i < bigString.length(); i++) {
			findSmallStringsIn(bigString.substring(i), trie, containedStrings);
		}
		for (String smallStr : smallStrings) {
			res.add(containedStrings.contains(smallStr));
		}
    return res;
  }
	
	private static void findSmallStringsIn(String str, Trie trie, Set<String> containedStrings) {
		Trie node = trie;
		for (char letter : str.toCharArray()) {
			if (!node.children.containsKey(letter)) {
				break;
			}
			node = node.children.get(letter);
			if (!node.word.equals("")) {
				containedStrings.add(node.word);
			}
		}
	}
		
	static class Trie {
		Map<Character, Trie> children;
		String word;
		
		public Trie() {
			this.children = new HashMap<>();
			this.word = "";
		}
		
		public void add(String str) {
			Trie node = this;
			for (char letter : str.toCharArray()) {
				if (!node.children.containsKey(letter)) {
					node.children.put(letter, new Trie());
				}
				node = node.children.get(letter);
			}
			node.word = str;
		}
	}
}
