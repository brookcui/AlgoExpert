import java.util.*;

class Program {
	// O(n) time | O(1) space
  public static int kadanesAlgorithm(int[] array) {
    // Write your code here.
		if (array.length == 0) {
			return 0;
		}
		int currSum = array[0];
		int maxSum = array[0];
		for (int i = 1; i < array.length; i++) {
			int num = array[i];
			currSum = Math.max(num, currSum + num);
			maxSum = Math.max(maxSum, currSum);
		}
    return maxSum;
  }
}
