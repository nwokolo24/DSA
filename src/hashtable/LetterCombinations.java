package hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
        // Driver
        // String input
        String str = "34";

        // Result list
        List<String> result = new ArrayList<>();

        // Map of character(numbers) to string(letters)
        Map<Character, String> map = Map.of(
                '2',"abc",
                '3',"def",
                '4',"ghi",
                '5',"jkl",
                '6',"mno",
                '7',"pqrs",
                '8',"tuv",
                '9',"wxyz");

        getCombinations(result, "", 0, str, map);

        System.out.println(result);
    }

    private static void getCombinations(List<String> result, String formed, int index, String digits, Map<Character, String> map) {
        // Base case to generate combination
        if (formed.length() == digits.length()) {
            result.add(formed);
            return;
        }

        // Get letters from map
        String letters = map.get(digits.charAt(index));

        // Loop through letters, add the character at index i and call getCombinations again but increase index by 1
        for (int i = 0; i < letters.length(); i++) {
            getCombinations(result, formed + letters.charAt(i), index+1, digits, map);
        }
    }
}
