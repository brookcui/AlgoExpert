import java.util.*;

class Program {
  public static int[] subarraySort(int[] array) {
    // Write your code here.
		int minOutOfOrder = Integer.MAX_VALUE;
		int maxOutOfOrder = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			if (isOutOfOrder(i, array)) {
				minOutOfOrder = Math.min(minOutOfOrder, num);
				maxOutOfOrder = Math.max(maxOutOfOrder, num);
			}
		}
		if (minOutOfOrder == Integer.MAX_VALUE) {
			return new int[] {-1, -1};
		}
		int subarrayLeft = 0;
		while (minOutOfOrder >= array[subarrayLeft]) {
			subarrayLeft++;
		}
		int subarrayRight = array.length - 1;
		while (maxOutOfOrder <= array[subarrayRight]) {
			subarrayRight--;
		}
    return new int[] {subarrayLeft, subarrayRight};
  }
	
	private static boolean isOutOfOrder(int i, int[] array) {
		if (i == 0) {
			return array[i] > array[i+1];
		}
		if (i == array.length - 1) {
			return array[i-1] > array[i];
		}
		return array[i-1] > array[i] || array[i] > array[i+1];
	}
}

