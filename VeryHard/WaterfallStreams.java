import java.util.*;

class Program {
	// O(wh * w) time | O(w) space
  public double[] waterfallStreams(double[][] array, int source) {
    // Write your code here.
		double[] rowAbove = array[0];
		rowAbove[source] = -1; // -1 for water, 1 for block, 0 for free space
		for (int row = 1; row < array.length; row++) {
			double[] currRow = array[row];
			for (int col = 0; col < rowAbove.length; col++) {
				double valueAbove = rowAbove[col];
				if (valueAbove >= 0) {
					continue;
				}
				if (currRow[col] != 1) {
					currRow[col] += valueAbove;
					continue;
				}
				double splitWater = valueAbove / 2;
				int idx = col;
				// split water to right side
				while (idx + 1 < rowAbove.length) {
					idx++;
					if (rowAbove[idx] == 1.0) { // block in the way
						break;
					} else if (currRow[idx] != 1) { // no block below
						currRow[idx] += splitWater;
						break;
					}
				}
				idx = col;
				// split water to left side
				while (idx - 1 >= 0) {
					idx--;
					if (rowAbove[idx] == 1.0) { // block in the way
						break;
					} else if (currRow[idx] != 1) { // no block below
						currRow[idx] += splitWater;
						break;
					}
				}
			}
			rowAbove = currRow;
		}
		double[] percentages = new double[rowAbove.length];
		for (int col = 0; col < rowAbove.length; col++) {
			if (rowAbove[col] == 0) {
				percentages[col] = 0;
			} else {
				percentages[col] = -100 * rowAbove[col];
			}
		}
    return percentages;
  }
}
