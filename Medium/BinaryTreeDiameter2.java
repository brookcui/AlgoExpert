import java.util.*;

class Program {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    private static int diameter;

    // O(n) time | O(h) space
    public int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        diameter = 0;
        helper(tree);
        return diameter;
    }

    private static int helper(BinaryTree root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        int height = Math.max(leftHeight, rightHeight);
        int longestPath = leftHeight + rightHeight;
        diameter = Math.max(diameter, longestPath);
        return 1 + height;
    }
}
