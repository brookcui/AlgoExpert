import java.util.*;

class Program {
	// O(n) time | O(1) space
  public static int getNthFib(int n) {
    // Write your code here.
		if (n <= 1) {
			return 0;
		}
		int a = 0, b = 1, c = 1;
		for (int i = 3; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
    return c;
  }
}
