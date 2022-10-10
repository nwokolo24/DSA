package string;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnag(strs);

        System.out.println(result);
    }

    private static List<List<String>> groupAnag(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String newStr = String.valueOf(ch);

//            map.putIfAbsent(newStr, new ArrayList<>());
//            map.get(newStr).add(s);

            if (map.containsKey(newStr)) {
                map.get(newStr).add(s);
            } else {
                map.put(newStr, new ArrayList<String>());
                map.get(newStr).add(s);
            }
        }

        return new ArrayList<>(map.values());
    }
}
