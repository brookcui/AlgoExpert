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

    // O(h + k) time | O(h) space - where h is the height
    // of the tree and k is the input parameter
    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        Stack<BST> stack = new Stack<>();
        BST curr = tree;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            --k;
            if (k == 0) {
                return curr.value;
            }
            curr = curr.left;
        }
        return -1;
    }
}
