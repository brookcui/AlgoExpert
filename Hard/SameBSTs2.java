import java.util.*;

class Program {
    // O(n^2) time | O(h) space
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        // Write your code here.
        return areSameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Actually, there is no need to copy the array into each recursive invocation,
    // which means we can use indexes as pointers.
    private static boolean areSameBsts(List<Integer> arrayOne, List<Integer> arrayTwo, int rootIdxOne, int rootIdxTwo,
            int minValue, int maxValue) {
        if (rootIdxOne == -1 || rootIdxTwo == -1) { // either of both of root node is null
            return rootIdxOne == rootIdxTwo;
        }
        // Both root nodes each each level should have the same value
        int rootValueOne = arrayOne.get(rootIdxOne);
        int rootValueTwo = arrayTwo.get(rootIdxTwo);
        if (rootValueOne != rootValueTwo) {
            return false;
        }
        // Partition each array into two subarrays by indexes
        int leftRootIdxOne = getIdxOfFirstSmallerNum(arrayOne, rootIdxOne, minValue);
        int leftRootIdxTwo = getIdxOfFirstSmallerNum(arrayTwo, rootIdxTwo, minValue);
        int rightRootIdxOne = getIdxOfFirstGreaterOrEqualNum(arrayOne, rootIdxOne, maxValue);
        int rightRootIdxTwo = getIdxOfFirstGreaterOrEqualNum(arrayTwo, rootIdxTwo, maxValue);
        boolean leftAreSame = areSameBsts(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minValue, rootValueOne);
        boolean rightAreSame = areSameBsts(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, rootValueOne,
                maxValue);
        // Each subarray should have equal BST structure
        return leftAreSame && rightAreSame;
    }

    private static int getIdxOfFirstSmallerNum(List<Integer> array, int startIdx, int minValue) {
        for (int i = startIdx + 1; i < array.size(); i++) {
            if (array.get(i) >= minValue && array.get(i) < array.get(startIdx)) {
                return i;
            }
        }
        return -1;
    }

    private static int getIdxOfFirstGreaterOrEqualNum(List<Integer> array, int startIdx, int maxValue) {
        for (int i = startIdx + 1; i < array.size(); i++) {
            if (array.get(i) < maxValue && array.get(i) >= array.get(startIdx)) {
                return i;
            }
        }
        return -1;
    }
}
