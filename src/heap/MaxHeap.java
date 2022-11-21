package heap;

import java.util.ArrayList;

public class MaxHeap {
    private Integer[] heap;
    private int size;

    public MaxHeap(int capacity) {
        this.heap = new Integer[capacity + 1];
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void insert(int val) {
        if (size == heap.length - 1) {
            resize(2 * heap.length);
        }
        this.size++;
        heap[size] = val;
        heapify(size);
    }

    public int deleteMax() {
        int max = heap[1];
        swap(1, size);
        size--;
        reheapify(size);
        heap[size + 1] = null;
        if (size > 0 && (size == (heap.length - 1) / 4)) {
            resize(heap.length / 2);
        }
        return max;
    }
    /**
     * This method satisfies binary heap and complete binary tree property.
     * We keep moving the largest value to the root of the binary tree.
     * The formula for finding the parent of a value at index i = i / 2
     * @param index
     */
    private void heapify(int index) {
        while (index > 1 && heap[index / 2] < heap[index]) {
            int temp = heap[index];
            heap[index] = heap[index / 2];
            heap[index / 2] = temp;
            index = index / 2;
        }
    }

    private void reheapify(int index) {
        while (index * 2 <= size) {
            int leftChildIndex = index * 2;
            // We need to check if there is a right child and if a right child exists, we
            // need to compare the left and the right child.
            if (leftChildIndex < size && heap[leftChildIndex] < heap[leftChildIndex + 1]) {
                leftChildIndex++;
            }

            if (heap[index] >= heap[leftChildIndex]) {
                break;
            }
            swap(index, leftChildIndex);
            index = leftChildIndex;
        }
    }
    private void resize(int capacity) {
        Integer[] temp = new Integer[capacity];
        for (int i = 0; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }
    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public String toString() {
        for (Integer val : heap) {
            System.out.print(val +" ");
        }
        return null;
    }
}
