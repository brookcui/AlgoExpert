import java.util.*;

class Program {
	// O(n^2) time | O(n) space
  public static int rectangleMania(Point[] coords) {
    // Write your code here.
		Set<String> coordsTable = new HashSet<>();
		for (Point coord : coords) {
			coordsTable.add(coord.toString());
		}
		int rectangleCount = 0;
		for (Point coord1 : coords) {
			for (Point coord2 : coords) {
				if (!isInUpperRight(coord1, coord2)) { // not diagonal points pair
					continue;
				}
				Point upperLeft = new Point(coord1.x, coord2.y);
				Point lowerRight = new Point(coord2.x, coord1.y);
				if (coordsTable.contains(upperLeft.toString()) && coordsTable.contains(lowerRight.toString())) {
					rectangleCount++;
				}
			}
		}
    return rectangleCount;
  }
	
	private static boolean isInUpperRight(Point coord1, Point coord2) {
		return coord2.x > coord1.x && coord2.y > coord1.y;
	}

  static class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
		
		@Override
		public String toString() {
			return x + "," + y;
		}
  }
}
