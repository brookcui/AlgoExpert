import java.util.*;

class Program {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    private static int rootIdx;

    // O(n) time | O(n) space - where n is the number of the input array
    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        rootIdx = 0;
        return constructBst(preOrderTraversalValues, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static BST constructBst(ArrayList<Integer> values, int lowerBound, int upperBound) {
        if (rootIdx >= values.size()) {
            return null;
        }
        int rootValue = values.get(rootIdx);
        if (rootValue < lowerBound || rootValue >= upperBound) {
            return null;
        }
        ++rootIdx;
        BST root = new BST(rootValue);
        root.left = constructBst(values, lowerBound, rootValue);
        root.right = constructBst(values, rootValue, upperBound);
        return root;
    }
}
