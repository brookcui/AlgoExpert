import java.util.*;

class Program {
    // O(n) time | O(1) space
    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        Map<Character, Integer> counter = new HashMap<>();
        for (char ch : string.toCharArray()) {
            counter.put(ch, 1 + counter.getOrDefault(ch, 0));
        }
        for (int idx = 0; idx < string.length(); idx++) {
            char ch = string.charAt(idx);
            if (counter.get(ch) == 1) {
                return idx;
            }
        }
        return -1;
    }
}
