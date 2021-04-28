import java.util.*;

class Program {
	// O((n*(2n)!)/(n!(n+1)!)) | O(n) space
  public static int numberOfBinaryTreeTopologies(int n) {
    // Write your code here.
		if (n == 0) {
			return 1;
		}
		int num = 0;
		for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
			int rightTreeSize = n - 1 - leftTreeSize;
			int numLeft = numberOfBinaryTreeTopologies(leftTreeSize);
			int numRight = numberOfBinaryTreeTopologies(rightTreeSize);
			num += numLeft * numRight;
		}
    return num;
  }
}
