import java.util.*;

class Program {
    // O(n) time | O(n) space
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        key %= 26;
        StringBuilder sb = new StringBuilder();
        for (char letter : str.toCharArray()) {
            sb.append(letterShiftedByKey(letter, key));
        }
        return sb.toString();
    }

    private static char letterShiftedByKey(char letter, int key) {
        int shiftedIndex = ((int) letter - (int) 'a' + key) % 26;
        char shiftedLetter = (char) ((int) 'a' + shiftedIndex);
        return shiftedLetter;
    }
}
