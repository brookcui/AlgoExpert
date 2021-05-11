import java.util.*;

class Program {
	// O(n) time | O(1) space
  public int[] threeNumberSort(int[] array, int[] order) {
    // Write your code here.
		int firstValue = order[0];
		int secondValue = order[1];
		int firstIdx = 0;
		int secondIdx = 0;
		int thirdIdx = array.length - 1;
		while (secondIdx <= thirdIdx) {
			int value = array[secondIdx];
			if (value == firstValue) {
				swap(firstIdx, secondIdx, array);
				firstIdx++;
				secondIdx++;
			} else if (value == secondValue) {
				secondIdx++;
			} else {
				swap(secondIdx, thirdIdx, array);
				thirdIdx--;
			}
		}
    return array;
  }
	
	private static void swap(int i, int j, int[] array) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
}
