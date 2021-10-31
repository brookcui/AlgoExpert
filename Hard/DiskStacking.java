import java.util.*;

class Program {
	// O(n^2) time | O(n) space
	public static List<Integer[]> diskStacking(List<Integer[]> disks) {
		// Write your code here.
		// sort by heights
		disks.sort((disk1, disk2) -> disk1[1].compareTo(disk2[2]));
		int[] heights = new int[disks.size()];
		for (int i = 0; i < disks.size(); i++) {
			heights[i] = disks.get(i)[2];
		}
		// sequences are indexes of disks in the final stack
		int[] sequences = new int[disks.size()];
		for (int i = 0; i < disks.size(); i++) {
			sequences[i] = Integer.MIN_VALUE;
		}
		int maxHeightIdx = 0;
		for (int i = 1; i < disks.size(); i++) {
			Integer[] disk = disks.get(i);
			for (int j = 0; j < disks.size(); j++) {
				Integer[] otherDisk = disks.get(j);
				if (isSmaller(otherDisk, disk)) {
					if (heights[i] <= disk[2] + heights[j]) {
						heights[i] = disk[2] + heights[j]; // maximize total heights
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

	private static boolean isSmaller(Integer[] disk, Integer[] otherDisk) {
		return disk[0] < otherDisk[0] && disk[1] < otherDisk[1] && disk[2] < otherDisk[2];
	}

	private static List<Integer[]> buildSequence(List<Integer[]> disks, int[] sequences, int idx) {
		List<Integer[]> sequence = new ArrayList<Integer[]>();
		while (idx != Integer.MIN_VALUE) {
			sequence.add(0, disks.get(idx));
			idx = sequences[idx];
		}
		return sequence;
	}
}
