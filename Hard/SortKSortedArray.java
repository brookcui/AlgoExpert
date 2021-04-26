import java.util.*;

class Program {
	// O(nlog(k)) time | O(k) space
  public int[] sortKSortedArray(int[] array, int k) {
    // Write your code here.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < Math.min(k + 1, array.length); i++) {
			pq.add(array[i]);
		}
		int idx = 0;
		for (int i = k + 1; i < array.length; i++) {
			int minNum = pq.poll();
			array[idx] = minNum;
			idx++;
			pq.add(array[i]);
		}
		while (!pq.isEmpty()) {
			int minNum = pq.poll();
			array[idx] = minNum;
			idx++;
		}
    return array;
  }
}
