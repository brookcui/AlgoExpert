import java.util.*;

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
class Program {
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        // O(n) time | O(1) space
        public List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
            for (int idx = (array.size() - 2) / 2; idx >= 0; idx--) {
                siftDown(idx, array.size() - 1, array);
            }
            return array;
        }

        // O(log(n)) time | O(1) space
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            // Write your code here.
            int leftChildIdx = currentIdx * 2 + 1;
            while (leftChildIdx <= endIdx) {
                int rightChildIdx = currentIdx * 2 + 2;
                int idxToSwap = leftChildIdx;
                if (rightChildIdx <= endIdx && heap.get(rightChildIdx) < heap.get(leftChildIdx)) {
                    idxToSwap = rightChildIdx;
                }
                if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    leftChildIdx = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        private static void swap(int i, int j, List<Integer> array) {
            int temp = array.get(j);
            array.set(j, array.get(i));
            array.set(i, temp);
        }

        // O(log(n)) time | O(1) space
        public void siftUp(int currentIdx, List<Integer> heap) {
            // Write your code here.
            int parentIdx = (currentIdx - 1) / 2;
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }
        }

        // O(1) time | O(1) space
        public int peek() {
            // Write your code here.
            return heap.get(0);
        }

        // O(log(n)) time | O(1) space
        public int remove() {
            // Write your code here.
            int valueToRemove = heap.get(0);
            swap(0, heap.size() - 1, heap);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        // O(log(n)) time | O(1) space
        public void insert(int value) {
            // Write your code here.
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }
    }
}
