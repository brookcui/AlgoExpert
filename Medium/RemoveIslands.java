import java.util.*;

class Program {
	// O(hw) time | O(hw) space
	public int[][] removeIslands(int[][] matrix) {
		// Write your code here.
		int height = matrix.length;
		int width = matrix[0].length;
		boolean[][] onesConnectedToBorder = new boolean[height][width];
		for (int c = 0; c < width; c++) {
			markOnesConnectedToBorder(0, c, matrix, onesConnectedToBorder);
			markOnesConnectedToBorder(height - 1, c, matrix, onesConnectedToBorder);
		}
		for (int r = 0; r < height; r++) {
			markOnesConnectedToBorder(r, 0, matrix, onesConnectedToBorder);
			markOnesConnectedToBorder(r, width - 1, matrix, onesConnectedToBorder);
		}
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				if (onesConnectedToBorder[r][c]) {
					continue;
				}
				matrix[r][c] = 0;
			}
		}
		return matrix;
	}

	private static void markOnesConnectedToBorder(int row, int col, int[][] matrix, boolean[][] onesConnectedToBorder) {
		if (matrix[row][col] != 1 || onesConnectedToBorder[row][col]) {
			return;
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col });
		while (!queue.isEmpty()) {
			int[] position = queue.poll();
			int r = position[0];
			int c = position[1];
			boolean alreadyVisited = onesConnectedToBorder[r][c];
			if (alreadyVisited || matrix[r][c] != 1) {
				continue;
			}
			onesConnectedToBorder[r][c] = true;
			for (int[] neighbor : getNeighbors(r, c, matrix)) {
				int nr = neighbor[0];
				int nc = neighbor[1];
				queue.add(new int[] { nr, nc });
			}
		}
	}

	private static List<int[]> getNeighbors(int row, int col, int[][] matrix) {
		List<int[]> neighbors = new ArrayList<>();
		if (row > 0) {
			neighbors.add(new int[] { row - 1, col });
		}
		if (row < matrix.length - 1) {
			neighbors.add(new int[] { row + 1, col });
		}
		if (col > 0) {
			neighbors.add(new int[] { row, col - 1 });
		}
		if (col < matrix[0].length - 1) {
			neighbors.add(new int[] { row, col + 1 });
		}
		return neighbors;
	}
}
