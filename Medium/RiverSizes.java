import java.util.*;

class Program {
	// O(hw) time | O(hw) space
	public static List<Integer> riverSizes(int[][] matrix) {
		// Write your code here.
		List<Integer> riverSizes = new ArrayList<>();
		int h = matrix.length;
		int w = matrix[0].length;
		boolean[][] visited = new boolean[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (visited[i][j]) {
					continue;
				}
				traverse(i, j, matrix, visited, riverSizes);
			}
		}
		return riverSizes;
	}

	private static void traverse(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> riverSizes) {
		int riverSize = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		while (!queue.isEmpty()) {
			int[] position = queue.poll();
			i = position[0];
			j = position[1];
			if (visited[i][j]) {
				continue;
			}
			visited[i][j] = true;
			if (matrix[i][j] == 0) {
				continue;
			}
			++riverSize;
			List<int[]> neighbors = getNeighbors(i, j, matrix, visited);
			queue.addAll(neighbors);
		}
		if (riverSize > 0) {
			riverSizes.add(riverSize);
		}
	}

	private static List<int[]> getNeighbors(int i, int j, int[][] matrix, boolean[][] visited) {
		List<int[]> neighbors = new ArrayList<>();
		if (i > 0 && !visited[i - 1][j]) {
			neighbors.add(new int[] { i - 1, j });
		}
		if (i < matrix.length - 1 && !visited[i + 1][j]) {
			neighbors.add(new int[] { i + 1, j });
		}
		if (j > 0 && !visited[i][j - 1]) {
			neighbors.add(new int[] { i, j - 1 });
		}
		if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
			neighbors.add(new int[] { i, j + 1 });
		}
		return neighbors;
	}
}
