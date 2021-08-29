import java.util.*;

class Program {
    // O(n) time | O(1) space
    public static boolean isPalindrome(String str) {
        // Write your code here.
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }
}
