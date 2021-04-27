import java.util.*;

class Program {
	// O(br) time | O(br) space
  public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
    // Write your code here.
		int blocksNumber = blocks.size();
		int requirementsNumber = reqs.length;
		if (blocksNumber == 0 || requirementsNumber == 0) {
			return 0;
		}
		int[][] left = new int[blocksNumber][requirementsNumber];
		Arrays.fill(left[0], Integer.MIN_VALUE);
		int[][] right = new int[blocksNumber][requirementsNumber];
		Arrays.fill(right[blocksNumber - 1], Integer.MAX_VALUE);
		for (int i = 0; i < blocksNumber; i++) {
			for (int j = 0; j < requirementsNumber; j++) {
				if (blocks.get(i).get(reqs[j])) {
					left[i][j] = i;
				} else if (i > 0) {
					left[i][j] = left[i-1][j];
				}
			}
		}
		for (int i = blocksNumber - 1; i >= 0; i--) {
			for (int j = 0; j < requirementsNumber; j++) {
				if (blocks.get(i).get(reqs[j])) {
					right[i][j] = i;
				} else if (i < blocksNumber - 1) {
					right[i][j] = right[i+1][j];
				}
			}
		}
		int minFarthestDistance = Integer.MAX_VALUE;
		int minFarthestDistanceIdx = -1;
		for (int i = 0; i < blocksNumber; i++) {
			int farthestDistance = Integer.MIN_VALUE;
			for (int j = 0; j < requirementsNumber; j++) {
				int leftDistance = (left[i][j] == Integer.MIN_VALUE) ? Integer.MAX_VALUE : i - left[i][j];
				int rightDistance = (right[i][j] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : right[i][j] - i;
				farthestDistance = Math.max(farthestDistance, Math.min(leftDistance, rightDistance));
			}
			if (farthestDistance < minFarthestDistance) {
				minFarthestDistance = farthestDistance;
				minFarthestDistanceIdx = i;
			}
 		}
    return minFarthestDistanceIdx;
  }
}
