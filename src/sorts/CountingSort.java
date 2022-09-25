package sorts;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {

        int[] arr = new int[]{3,3,2};
        System.out.println(Arrays.toString(arr));
        System.out.println();
        mySort(arr);
        System.out.println(Arrays.toString(arr));
    }

     private static void mySort(int[] arr) {
        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

        int[] newArr = new int[max - min + 1];

         // Use the value in the original array to determine
         // what index to increase;
        for (int val : arr) {
            newArr[val - min]++;
        }

        int idx = 0;
        for (int i = 0; i < newArr.length; i++) {
            while (newArr[i] > 0) {
                arr[idx] = i + min;
                newArr[i]--;
                idx++;
            }
        }
     }
}
