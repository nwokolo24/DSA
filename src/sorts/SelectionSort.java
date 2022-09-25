package sorts;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 3, 6, 7, 2, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        if (arr.length == 0) return;

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            swap(arr, i, min);
        }
    }

    private static void swap(int[] arr, int i, int min) {
        int temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;
    }
}
