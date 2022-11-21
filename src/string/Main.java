package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        System.out.println(charFromInt(16));
//        System.out.println(hackerrankInString("hereiamstackerrank"));

//        String str = "Hellow";
//        StringBuilder sb = new StringBuilder(str);

//        String str = "abcc";
        String str = "abccc";
//        String str = "aabbcd";
//        String str = "aabbccddeefghi";
//        String str = "abcdefghhgfedecba";

//        System.out.println(sherlockValidString(str));

        Calculator calculator = new Calculator();
        int ans = calculator.calculate("-(2 - 3 + 6) + 5");
        System.out.println(ans);
    }

    private static Character charFromInt(int i) {
        return i > 0 && i < 27 ? (char)(i + 64) : null;
    }

    public static String hackerrankInString(String s) {
        // Write your code here
        char[] hr = "hackerrank".toCharArray();
        int pointer1 = 0;

        // hereiamstackerrank
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (pointer1 == hr.length) {
                return "YES";
            }

            if (c == hr[pointer1]) {
                pointer1++;
            }
        }
        return "NO";
    }

    public static String sherlockValidString(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        ArrayList<Integer> array = new ArrayList<>(map.values());
        int max = Collections.max(array);
        int min = Collections.min(array);

        if (min == max) return "YES";

        int minCount = 0, maxCount = 0;
        for (int val : array) {
            if (val == max)
                maxCount++;
            else if (val == min)
                minCount++;
        }

        if (minCount + maxCount != array.size())
            return "NO";

        return (minCount == 1 || (maxCount == 1 && max == min + 1)) ? "YES" : "NO";
    }
}
