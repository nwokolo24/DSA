package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int pair = 3;
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, pair);

        System.out.println(result);
    }

    private static void backtrack(List<String> result, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            result.add(cur);
            return;
        }

        if (open < max) backtrack(result, cur + "(", open+1, close, max);
        if (close < open) backtrack(result, cur + ")", open, close+1, max);
    }
}
