import java.util.*;

class Program {
    // O(w * h) time | O(w * h) space
    public int minimumPassesOfMatrix(int[][] matrix) {
        // Write your code here.
        int passes = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.addAll(getAllPositivePositions(matrix));
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] position = queue.poll();
                int row = position[0];
                int col = position[1];
                List<int[]> neighbors = getNeighbors(row, col, matrix);
                for (int[] neighbor : neighbors) {
                    int r = neighbor[0];
                    int c = neighbor[1];
                    if (matrix[r][c] < 0) {
                        matrix[r][c] *= -1;
                        queue.add(new int[] { r, c });
                    }
                }
            }
            ++passes;
        }
        if (containsNegativeElements(matrix)) {
            return -1;
        }
        return passes - 1;
    }

    private static List<int[]> getAllPositivePositions(int[][] matrix) {
        List<int[]> positivePositions = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0) {
                    positivePositions.add(new int[] { i, j });
                }
            }
        }
        return positivePositions;
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

    private static boolean containsNegativeElements(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
