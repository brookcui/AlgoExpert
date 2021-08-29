import java.util.*;

class Program {
    // O(n) time | O(n) space
    public String runLengthEncoding(String string) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();
        int runLength = 1;
        for (int i = 1; i < string.length(); i++) {
            char curr = string.charAt(i);
            char prev = string.charAt(i - 1);
            if (curr != prev || runLength == 9) {
                sb.append(Integer.toString(runLength));
                sb.append(prev);
                runLength = 0;
            }
            ++runLength;
        }
        sb.append(Integer.toString(runLength));
        sb.append(string.charAt(string.length() - 1));
        return sb.toString();
    }
}
