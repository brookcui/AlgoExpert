import java.util.*;

class Program {
	// O(m * n) time | O(m * n) space - where m is the width and n is the height of the matrix
  public int maximumSumSubmatrix(int[][] matrix, int size) {
    // Write your code here.
		int m = matrix.length, n = matrix[0].length;
		int[][] sums = new int[m][n];
		sums[0][0] = matrix[0][0];
		for (int i = 1; i < m; i++) {
			sums[i][0] = sums[i-1][0] + matrix[i][0];
		}
		for (int j = 1; j < n; j++) {
			sums[0][j] = sums[0][j-1] + matrix[0][j];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				sums[i][j] = matrix[i][j] + sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1];
			}
		}
		int maxSubmatrixSum = Integer.MIN_VALUE;
		for (int i = size - 1; i < m; i++) {
			for (int j = size - 1; j < n; j++) {
				int total = sums[i][j];
				total -= (i - size >= 0) ? sums[i - size][j] : 0;
				total -= (j - size >= 0) ? sums[i][j - size] : 0;
				total += (i - size >= 0 && j - size >= 0) ? sums[i-size][j-size] : 0;
				maxSubmatrixSum = Math.max(maxSubmatrixSum, total);
			}
		}
    return maxSubmatrixSum;
  }
}
