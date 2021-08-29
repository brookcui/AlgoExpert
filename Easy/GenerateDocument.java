import java.util.*;

class Program {
    // O(n + m) time | O(c) space - where n is the number of characters, m
    // is the length of document, and c is the number of unique characters
    // in the characters string
    public boolean generateDocument(String characters, String document) {
        // Write your code here.
        Map<Character, Integer> counter = new HashMap<>();
        for (char ch : characters.toCharArray()) {
            counter.put(ch, 1 + counter.getOrDefault(ch, 0));
        }
        for (char ch : document.toCharArray()) {
            if (!counter.containsKey(ch) || counter.get(ch) == 0) {
                return false;
            }
            counter.put(ch, -1 + counter.get(ch));
        }
        return true;
    }
}
