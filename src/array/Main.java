package array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       int[] nums = new int[] {1,2,3,4,5,6,7};
       int k = 3;

       rotateArray(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotateArray(int[] array, int k) {
        int n = array.length;
        if (n < 2) {
            return;
        }
        // New array
        int[] tempArr = new int[n];
        for (int i = 0; i < n; i++) {
            tempArr[(i + k) % n] = array[i];
        }

        for (int i = 0; i < n; i++) {
            array[i] = tempArr[i];
        }
    }
}
