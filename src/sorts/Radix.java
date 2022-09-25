package sorts;

public class Radix {
    public static void main(String[] args) {
        int[] arr = new int[] {237, 146, 259, 348, 152, 163, 235, 48, 36, 62};
        System.out.println(getMax(arr));
    }

    private static void applyCountingSort(int[] arr, int size, int placeValue) {

        int[] output = new int[size + 1];
        int max = getMax(arr);

        int[] count = new int[max + 1];

        for (int i = 0; i < max; i++) {
            count[i] = 0;
        }
        int range = 10; // decimal system, numbers from 0-9


    }
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return arr.length == 0 ? 0 : max;
    }
}
