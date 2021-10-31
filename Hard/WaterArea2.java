import java.util.*;

class Program {
    // O(n) time | O(1) space
    public static int waterArea(int[] heights) {
        // Write your code here.
        if (heights.length == 0) {
            return 0;
        }
        int leftIdx = 0, rightIdx = heights.length - 1;
        int leftMax = heights[leftIdx], rightMax = heights[rightIdx];
        int totalArea = 0;
        while (leftIdx < rightIdx) {
            if (heights[leftIdx] < heights[rightIdx]) {
                leftIdx++;
                leftMax = Math.max(leftMax, heights[leftIdx]);
                totalArea += leftMax - heights[leftIdx];
            } else {
                rightIdx--;
                rightMax = Math.max(rightMax, heights[rightIdx]);
                totalArea += rightMax - heights[rightIdx];
            }
        }
        return totalArea;
    }
}
