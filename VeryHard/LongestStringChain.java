import java.util.*;

class Program {
	// O(n * m^2 + nlog(n)) time | O(nm) space - where n is the number of strings and m is the length of the longest string
  public static List<String> longestStringChain(List<String> strings) {
    // Write your code here.
		Map<String, StringChain> stringChains = new HashMap<>();
		for (String string : strings) {
			stringChains.put(string, new StringChain("", 1));
		}
		List<String> sortedStrings = new ArrayList<String>(strings);
		sortedStrings.sort((a, b) -> a.length() - b.length());
		for (String string : sortedStrings) {
			for (String substring : substringsWithOneLetterRemoved(string)) {
				if (stringChains.containsKey(substring)) {
					updateStringChain(stringChains, string, substring);
				}
			}
		}
    return buildLongestStringChain(stringChains, strings);
  }
	
	private static class StringChain {
		String nextString;
		Integer maxChainLength;
		
		public StringChain(String nextString, Integer maxChainLength) {
			this.nextString = nextString;
			this.maxChainLength = maxChainLength;
		}
	}
	
	private static List<String> substringsWithOneLetterRemoved(String string) {
		List<String> substrings = new ArrayList<>();
		for (int i = 0; i < string.length(); i++) {
			substrings.add(string.substring(0, i) + string.substring(i + 1));
		}
		return substrings;
	}
	
	private static void updateStringChain(Map<String, StringChain> stringChains, String string, String substring) {
		int substringChainLength = stringChains.get(substring).maxChainLength;
		int stringChainLength = stringChains.get(string).maxChainLength;
		if (substringChainLength + 1 > stringChainLength) {
			stringChains.get(string).nextString = substring;
			stringChains.get(string).maxChainLength = substringChainLength + 1;
		}
	}
	
	private static List<String> buildLongestStringChain(Map<String, StringChain> stringChains, List<String> strings) {
		int maxStringChainLength = 0;
		String startString = "";
		for (String string : strings) {
			if (stringChains.get(string).maxChainLength > maxStringChainLength) {
				maxStringChainLength = stringChains.get(string).maxChainLength;
				startString = string;
			}
		}
		List<String> stringChain = new ArrayList<>();
		String string = startString;
		while (!string.equals("")) {
			stringChain.add(string);
			string = stringChains.get(string).nextString;
		}
		if (stringChain.size() == 1) {
			return new ArrayList<>();
		}
		return stringChain;
	}
}
