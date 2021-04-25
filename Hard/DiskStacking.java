import java.util.*;

class Program {
	// O(n) time | O(n) space
  public static List<Integer[]> diskStacking(List<Integer[]> disks) {
    // Write your code here.
		disks.sort((disk1, disk2) -> disk1[2].compareTo(disk2[2]));
		int[] heights = new int[disks.size()];
		int[] sequences = new int[disks.size()];
		for (int i = 0; i < disks.size(); i++) {
			heights[i] = disks.get(i)[2];
			sequences[i] = Integer.MIN_VALUE;
		}
		int maxHeightIdx = 0;
		for (int i = 1; i < disks.size(); i++) {
			Integer[] disk = disks.get(i);
			for (int j = 0; j < i; j++) {
				Integer[] other = disks.get(j);
				if (disk[0] > other[0] && disk[1] > other[1] && disk[2] > other[2]) {
					if (heights[i] <= disk[2] + heights[j]) {
						heights[i] = disk[2] + heights[j];
						sequences[i] = j;
					}
				}
			}
			if (heights[i] >= heights[maxHeightIdx]) {
				maxHeightIdx = i;
			}
		}
    return buildSequence(disks, sequences, maxHeightIdx);
  }
	
	private static List<Integer[]> buildSequence(List<Integer[]> disks, int[] sequences, int idx) {
		List<Integer[]> sequence = new ArrayList<>();
		while (idx != Integer.MIN_VALUE) {
			sequence.add(0, disks.get(idx));
			idx = sequences[idx];
		}
		return sequence;
	}
}
