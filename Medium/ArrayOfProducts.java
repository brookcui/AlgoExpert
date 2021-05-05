import java.util.*;

class Program {
	// O(n) time | O(n) space
  public int[] arrayOfProducts(int[] array) {
    // Write your code here.
		int[] products = new int[array.length];
		int left = 1;
		for (int i = 0; i < array.length; i++) {
			products[i] = left;
			left *= array[i];
		}
		int right = 1;
		for (int i = array.length - 1; i >= 0; i--) {
			products[i] *= right;
			right *= array[i];
		}
    return products;
  }
}
