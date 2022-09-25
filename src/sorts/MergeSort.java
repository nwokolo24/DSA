package sorts;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] {11, 9, 21, 8, 17, 19, 13, 1, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int[] arr) {
        // Write a base-case
        if (arr.length < 2) return;

        // calculate mid
        int mid = arr.length / 2;

        // create two arrays for left and right
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[arr.length - mid];

        // populate the arrays with values from original array
        for (int i = 0; i < mid; i++) {
            leftHalf[i] = arr[i];
        }

        for (int j = mid; j < arr.length; j++) {
            rightHalf[j - mid] = arr[j];
        }

        // call sort on the left and right
        sort(leftHalf);
        sort(rightHalf);

        // call merge on original, left and right arrays
        merge(arr, leftHalf, rightHalf);
    }

    private static void merge(int[] arr, int[] leftHalf, int[] rightHalf) {
        // get the size of left array and right array
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        // create 3 variables to iterate on the 3 arrays
        int i = 0, j = 0, k = 0;

        // us a while loop to fill the original array
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] < rightHalf[j]) {
                arr[k++] = leftHalf[i++];
            } else {
                arr[k++] = rightHalf[j++];
            }
        }

        // Take care of arrays of unequal length
        while (i < leftSize) arr[k++] = leftHalf[i++];
        while (j < rightSize) arr[k++] = rightHalf[j++];
    }
}
