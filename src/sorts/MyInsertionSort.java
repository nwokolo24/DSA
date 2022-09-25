package sorts;

import java.util.Arrays;

public class MyInsertionSort {
    public static void main(String[] args) {
        int[] arr = {6, 2, 9, 1};

        System.out.println(Arrays.toString(insertSort(arr)));
    }

    private static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && key < arr[j]) {
                insertionSwap(arr, j);
                j--;
            }
        }
        return arr;
    }

    private static void insertionSwap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }
}
