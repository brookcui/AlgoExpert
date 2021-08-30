import java.util.*;

class Program {
  // O(nlog(n)) time | O(n) space - where n is the length of the array
  public static BST minHeightBst(List<Integer> array) {
    // Write your code here.
    return constructMinHeightBst(array, null, 0, array.size() - 1);
  }

  private static BST constructMinHeightBst(List<Integer> array, BST root, int startIdx, int endIdx) {
    if (startIdx > endIdx) {
      return null;
    }
    int midIdx = startIdx + (endIdx - startIdx) / 2;
    if (root == null) {
      root = new BST(array.get(midIdx));
    } else {
      root.insert(array.get(midIdx)); // takes O(log(n)) time
    }
    constructMinHeightBst(array, root, startIdx, midIdx - 1);
    constructMinHeightBst(array, root, midIdx + 1, endIdx);
    return root;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      left = null;
      right = null;
    }

    public void insert(int value) {
      if (value < this.value) {
        if (left == null) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new BST(value);
        } else {
          right.insert(value);
        }
      }
    }
  }
}
