import java.util.*;

class Program {
	// O(n) time | O(n) space - where n is the length of the array
  public int maximizeExpression(int[] array) {
    // Write your code here.
		if (array.length < 4) {
			return 0;
		}
		int n = array.length;
		int[] a = new int[n];
		a[0] = array[0];
		int[] b = new int[n];
		b[0] = Integer.MIN_VALUE;
		int[] c = new int[n];
		c[0] = Integer.MIN_VALUE; c[1] = Integer.MIN_VALUE;
		int[] d = new int[n];
		d[0] = Integer.MIN_VALUE; d[1] = Integer.MIN_VALUE; d[2] = Integer.MIN_VALUE;
		for (int i = 1; i < n - 3; i++) {
			a[i] = Math.max(a[i-1], array[i]);
		}
		for (int i = 1; i < n - 2; i++) {
			b[i] = Math.max(b[i-1], a[i-1] - array[i]);
		}
		for (int i = 2; i < n - 1; i++) {
			c[i] = Math.max(c[i-1], b[i-1] + array[i]);
		}
		for (int i = 3; i < n; i++) {
			d[i] = Math.max(d[i-1], c[i-1] - array[i]);
		}
    return d[n-1];
  }
}
