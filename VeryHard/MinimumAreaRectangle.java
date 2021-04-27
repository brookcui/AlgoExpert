import java.util.*;

class Program {
	// O(n^2) time | O(n) space
  public int minimumAreaRectangle(int[][] points) {
    // Write your code here.
		if (points.length < 4) {
			return 0;
		}
		int minArea = Integer.MAX_VALUE;
		Set<String> pointSet = buildPointSet(points);
		for (int i = 1; i < points.length; i++) {
			int p1x = points[i][0];
			int p1y = points[i][1];
			for (int j = 0; j < i; j++) {
				int p2x = points[j][0];
				int p2y = points[j][1];
				if (p1x == p2x || p1y == p2y) {
					continue; // two points not at opposite ends
				}
				boolean diagonalExists = pointSet.contains(formatPoint(p1x, p2y))
					&& pointSet.contains(formatPoint(p2x, p1y));
					if (diagonalExists) {
						int area = Math.abs(p2x - p1x) * Math.abs(p2y - p1y);
						minArea = Math.min(minArea, area);
					}
			}
		}
    return (minArea == Integer.MAX_VALUE) ? 0 : minArea;
  }
	
	private String formatPoint(int x, int y) {
		return x + "," + y;
	}
	
	private Set<String> buildPointSet(int[][] points) {
		Set<String> pointSet = new HashSet<>();
		for (int[] point : points) {
			pointSet.add(formatPoint(point[0], point[1]));
		}
		return pointSet;
	}
}
