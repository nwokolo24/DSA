package sorts;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 3, 6, 7, 2, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        // define base case for exiting this function
        if (low >= high) return;

        // get the pivot for partitioning
        int pivot = arr[high];

        // always get left and right pointers from the low and high
        // values given in the function argument
        int leftPointer = low;
        int rightPointer = high;

        // using while loop, move
        while (leftPointer < rightPointer) {

            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (arr[leftPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(arr, leftPointer, rightPointer);
        }
        swap(arr, leftPointer, high);

        sort(arr, low, leftPointer-1);
        sort(arr, leftPointer+1, high);
    }

    private static void swap(int[] arr, int leftPointer, int rightPointer) {
        int temp = arr[leftPointer];
        arr[leftPointer] = arr[rightPointer];
        arr[rightPointer] = temp;
    }
}
