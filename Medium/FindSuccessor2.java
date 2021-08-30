import java.util.*;

class Program {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(h) time | O(1) space
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        if (node.right != null) {
            BinaryTree curr = node.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        } else {
            BinaryTree curr = node;
            while (curr.parent != null && curr.parent.right == curr) {
                curr = curr.parent;
            }
            return curr.parent;
        }
    }
}
