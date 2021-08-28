import java.util.*;

class Program {

  public boolean classPhotos(
      ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
    // Write your code here.
		int n = redShirtHeights.size();
		Collections.sort(redShirtHeights);
		Collections.sort(blueShirtHeights);
		if (redShirtHeights.get(n - 1) < blueShirtHeights.get(n - 1)) {
			return shorterThan(redShirtHeights, blueShirtHeights);
		} else if (redShirtHeights.get(n - 1) > blueShirtHeights.get(n - 1)) {
			return shorterThan(blueShirtHeights, redShirtHeights);
		} else {
			return false;
		}
  }
	
	private static boolean shorterThan(ArrayList<Integer> frontRow, ArrayList<Integer> backRow) {
		for (int i = 0; i < frontRow.size(); i++) {
			if (frontRow.get(i) >= backRow.get(i)) {
				return false;
			}
		}
		return true;
	}
}
