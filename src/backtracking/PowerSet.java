package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2};
        System.out.println(solve(arr));
    }

    private static List<List<Integer>> solve(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        subSet(result, new ArrayList<>(), arr, 0);
        return result;
    }

    private static void subSet(List<List<Integer>> result, List<Integer> cur, int[] arr, int start) {
        result.add(new ArrayList(cur));
        for (int i = start; i < arr.length; i++) {
            cur.add(arr[i]);
            subSet(result, cur, arr, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
