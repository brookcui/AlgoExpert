import java.util.*;

class Program {
	private static int[] dr = new int[]{0, -1, 0, 1};
	private static int[] dc = new int[]{-1, 0, 1, 0};
	
	// O(mn) time | O(mn) space
  public static List<Integer> riverSizes(int[][] matrix) {
    // Write your code here.
		int m = matrix.length, n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];
		List<Integer> riverSizes = new ArrayList<Integer>();
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (!visited[r][c] && matrix[r][c] == 1) {
					riverSizes.add(dfs(r, c, visited, matrix, m, n));
				}
			}
		}
    return riverSizes;
  }
	
	private static int dfs(int r, int c, boolean[][] visited, int[][] matrix, int m, int n) {
		visited[r][c] = true;
		int size = 1;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (0 <= nr && nr < m && 0 <= nc && nc < n && !visited[nr][nc] && matrix[nr][nc] == 1) {
				size += dfs(nr, nc, visited, matrix, m, n);
			}
		}
		return size;
	}
}

