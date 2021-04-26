import java.util.*;

class Program {
	// O(mn) time | O(mn) space
  public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
    // Write your code here.
		solve(0, 0, board);
    return board;
  }
	
	private boolean solve(int r, int c, ArrayList<ArrayList<Integer>> board) {
		if (c == board.get(r).size()) {
			r += 1;
			c = 0;
			if (r == board.size()) {
				return true;
			}
		}
		if (board.get(r).get(c) == 0) {
			for (int digit = 1; digit <= 9; digit++) {
				if (isValidAt(digit, r, c, board)) {
					board.get(r).set(c, digit);
					if (solve(r, c + 1, board)) {
						return true;
					}
				}
			}
			board.get(r).set(c, 0); // backtrack
			return false;
		}
		return solve(r, c + 1, board);
	}
	
	private boolean isValidAt(int digit, int row, int col, ArrayList<ArrayList<Integer>> board) {
		for (int c = 0; c < board.get(row).size(); c++) {
			if (board.get(row).get(c) == digit) {
				return false;
			}
		}
		for (int r = 0; r < board.size(); r++) {
			if (board.get(r).get(col) == digit) {
				return false;
			}
		}
		int subgridRow = (row / 3) * 3;
		int subgridCol = (col / 3) * 3;
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (board.get(subgridRow + r).get(subgridCol + c) == digit) {
					return false;
				}
			}
		}
		return true;
	}
}
