import java.util.*;

class Program {
	private static Map<Character, String[]> digitToLetters = new HashMap<>();
	static {
		digitToLetters.put('0', new String[] {"0"});
		digitToLetters.put('1', new String[] {"1"});
		digitToLetters.put('2', new String[] {"a", "b", "c"});
		digitToLetters.put('3', new String[] {"d", "e", "f"});
		digitToLetters.put('4', new String[] {"g", "h", "i"});
		digitToLetters.put('5', new String[] {"j", "k", "l"});
		digitToLetters.put('6', new String[] {"m", "n", "o"});
		digitToLetters.put('7', new String[] {"p", "q", "r", "s"});
		digitToLetters.put('8', new String[] {"t", "u", "v"});
		digitToLetters.put('9', new String[] {"w", "x", "y", "z"});
	}
	
	// O(4^n * n) time | O(4^n * n) space
  public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
    // Write your code here.
		String[] mnemonics = new String[phoneNumber.length()];
		ArrayList<String> mnemonicsFound = new ArrayList<>();
		dfs(0, phoneNumber, mnemonics, mnemonicsFound);
    return mnemonicsFound;
  }
	
	private void dfs(int idx, String phoneNumber, String[] mnemonics, ArrayList<String> mnemonicsFound) {
		if (idx == phoneNumber.length()) {
			String mnemonic = String.join("", mnemonics);
			mnemonicsFound.add(mnemonic);
		} else {
			char digit = phoneNumber.charAt(idx);
			for (String letter : digitToLetters.get(digit)) {
				mnemonics[idx] = letter;
				dfs(idx + 1, phoneNumber, mnemonics, mnemonicsFound);
			}
		}
	}
}
