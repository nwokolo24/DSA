package string;

public class PalindromeStrings {
    private static int resultStart;
    private static int resultLength;

    public static void main(String[] args) {
        String str = "babad";

        System.out.println(longestPalSubStringImproved(str));

//        System.out.println(longestPalSubstring(str));
    }
    /*
    * Big O(n^3) solution
     */
    private static String longestPalSubstring(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String tempString = str.substring(i, j);
                if (isPalindrome(tempString) && tempString.length() >= result.length()) {
                    result = tempString;
                }
            }
        }

        return result;
    }
    private static boolean isPalindrome(String str) {
        if (str.length() == 0) return true;

        int left = 0;
        int right = str.length() - 1;

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray())
            sb.append(c);

        while (left <= right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
        return sb.toString().equals(str);
    }

    /*
    * Big O(n^2) solution
     */
    private static String longestPalSubStringImproved(String str) {
        if (str == null || str.length() < 2) return str;

        for (int start = 0; start < str.length(); start++) {
            expandRange(str, start, start);
            expandRange(str, start, start + 1);
        }

        return str.substring(resultStart, resultStart + resultLength);
    }

    private static void expandRange(String str, int start, int end) {
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }

        if (resultLength < end - start - 1) {
            resultStart = start + 1;
            resultLength = end - start - 1;
        }
    }
}
