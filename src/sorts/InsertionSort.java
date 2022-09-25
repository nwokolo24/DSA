package sorts;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 3, 6, 7, 2, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Time complexity if O(n^2) for average and worst case and O(n) for best case.
    // Space complexity is O(1) or constant space
    // It is a stable sorting algorithm.
    private static void sort(int[] arr) {
        if (arr.length == 0) return;

        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
