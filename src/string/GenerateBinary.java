package string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinary {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generate(3)));
    }
    private static String[] generate(int num) {
        String[] result = new String[num];
        Queue<String> q = new LinkedList<>();
        q.offer("1");

        for (int i = 0; i < num; i++) {
            result[i] = q.poll();
            String str1 = result[i] + "0";
            String str2 = result[i] + "1";
            q.offer(str1);
            q.offer(str2);
        }
        return result;
    }
}
