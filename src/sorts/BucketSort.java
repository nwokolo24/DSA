package sorts;

import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = new int[] {11, 9, 21, 8, 17, 19, 13, 1, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int[] arr) {
        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        int numBucks = (int)Math.sqrt(max - min);
        int divider = (int)Math.ceil((max + 1) / numBucks);
        // puting element to bucket

        // Create bucket with size 10
        List<Integer>[] buckets = new List[numBucks];

        // populate every index of bucket with LinkedList<Integer>()
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int num : arr) {
            int j = (int)Math.floor(num / divider);
            buckets[j].add(num);
        }

        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int idx = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[idx] = num;
                idx++;
            }
        }
    }

    private static void insertionSort(int[] arr) {
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
