import java.util.*;

class Program {
	// O(n!) time | O(n) sapce
  public int nonAttackingQueens(int n) {
    // Write your code here.
		blockedColumns = new HashSet<>();
		blockedUpDiagonals = new HashSet<>();
		blockedDownDiagonals = new HashSet<>();
    return dfs(0, n);
  }
	
	private Set<Integer> blockedColumns;
	private Set<Integer> blockedUpDiagonals;
	private Set<Integer> blockedDownDiagonals;
	
	private int dfs(int row, int boardSize) {
		if (row == boardSize) {
			return 1;
		}
		int num = 0;
		for (int col = 0; col < boardSize; col++) {
			if (isValidPosition(row, col)) {
				// place queen
				blockedColumns.add(col);
				blockedUpDiagonals.add(row + col);
				blockedDownDiagonals.add(row - col);
				// search recursively
				num += dfs(row + 1, boardSize);
				// remove queen
				blockedColumns.remove(col);
				blockedUpDiagonals.remove(row + col);
				blockedDownDiagonals.remove(row - col);
			}
		}
		return num;
	}
	
	private boolean isValidPosition(int row, int col) {
		return !blockedColumns.contains(col) && !blockedUpDiagonals.contains(row + col) && !blockedDownDiagonals.contains(row - col);
	}
}
