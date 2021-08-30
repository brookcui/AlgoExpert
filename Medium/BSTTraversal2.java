import java.util.*;

class Program {
    // O(n) time | O(n) space - where n is the number of nodes in the BST
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        Stack<BST> stack = new Stack<>();
        BST curr = tree;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            array.add(curr.value);
            curr = curr.right;
        }
        return array;
    }

    // O(n) time | O(n) space - where n is the number of nodes in the BST
    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        Stack<BST> stack = new Stack<>();
        BST curr = tree;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                array.add(curr.value);
                stack.add(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                curr = curr.right;
            }
        }
        return array;
    }

    // O(n) time | O(n) space - where n is the number of nodes in the BST
    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        Stack<BST> stack = new Stack<>();
        BST curr = tree;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                array.add(0, curr.value);
                stack.add(curr);
                curr = curr.right;
            } else {
                curr = stack.pop();
                curr = curr.left;
            }
        }
        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
