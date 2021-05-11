import java.util.*;

class Program {
	// O(hw) time | O(hw) space
  public int[][] removeIslands(int[][] matrix) {
    // Write your code here.
		int height = matrix.length, width = matrix[0].length;
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				boolean rowIsBorder = r == 0 || r == height - 1;
				boolean colIsBorder = c == 0 || c == width - 1;
				boolean isBorder = rowIsBorder || colIsBorder;
				if (!isBorder || matrix[r][c] != 1) {
					continue;
				}
				changeOnesConnectedToBorderToTwos(matrix, r, c);
			}
		}
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				int color = matrix[r][c];
				if (color == 1) {
					matrix[r][c] = 0;
				} else if (color == 2) {
					matrix[r][c] = 1;
				}
			}
		}
    return matrix;
  }
	
	private static int[] dr = {0, -1, 0, 1};
	private static int[] dc = {-1, 0, 1, 0};
	
	private void changeOnesConnectedToBorderToTwos(int[][] matrix, int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row, col});
		while (!queue.isEmpty()) {
			int[] coord = queue.poll();
			matrix[coord[0]][coord[1]] = 2;
			for (int i = 0; i < 4; i++) {
				int nextRow = coord[0] + dr[i];
				int nextCol = coord[1] + dc[i];
				if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length || matrix[nextRow][nextCol] != 1) {
					continue;
				}
				queue.add(new int[] {nextRow, nextCol});
			}
		}
	}
}
