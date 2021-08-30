import java.util.*;

class Program {
	// O(n) time | O(1) space
	public int[] arrayOfProducts(int[] array) {
		// Write your code here.
		int[] products = new int[array.length];
		int runningProduct = 1;
		for (int i = 0; i < array.length; i++) {
			products[i] = runningProduct;
			runningProduct *= array[i];
		}
		runningProduct = 1;
		for (int i = array.length - 1; i >= 0; i--) {
			products[i] *= runningProduct;
			runningProduct *= array[i];
		}
		return products;
	}
}
