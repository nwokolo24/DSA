package array;

import javafx.scene.transform.Scale;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class MyFib {
    private static HashMap<Integer, Long> map = new HashMap<>();
    private static long[] cache;
    public static void main(String[] args) {
        System.out.println(calculateFibRecursive(50));
        int num = 50;
        cache = new long[num + 1];

        System.out.println(calculateFibIterative(num));
    }

    private static long calculateFibRecursive(int num) {
        // Base case
        if (num < 2)
            return (long) num;

        if (!map.containsKey(num)) {
            map.put(num, calculateFibRecursive(num - 1) + calculateFibRecursive(num - 2));
        }

        return map.get(num);
    }

    private static long calculateFibIterative(int num) {
        // Base case
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;

        for (int i = 3; i <= num; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[num];
    }
}
