package dp;

import java.util.Arrays;

public class MaxIncreaseSubsequence {
    public static void main(String[] args) {
        int[] arr = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(mis(arr));
    }
    // arr = [10, 9, 2, 5, 3, 7, 101, 18]
    // dp = [1, 1, 1, 1, 1, 1, 1, 1]
    private static int mis(int[] arr) {
        int[] dp = new int[arr.length];
        int longest = 1;

        Arrays.fill(dp, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            longest = Math.max(longest, dp[i]);
        }

        return longest;
    }
}
