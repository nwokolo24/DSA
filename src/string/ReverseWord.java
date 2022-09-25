package string;

public class ReverseWord {
    public static void main(String[] args) {
        String s = "leetcode is fun";
        String test = "bueze";
//        System.out.println(reverseString(test));
        StringBuilder sb = trimSpaces(s);
//        reverse(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        System.out.println(trimSpaces(sb.toString()));
    }

    public static StringBuilder trimSpaces(String str) {
        int left = 0;
        int right = str.length() - 1;

        // this does what str.trim() would have done
        while (left <= right && str.charAt(left) == ' ') left++;
        while (left <= right && str.charAt(right) == ' ') right--;

        StringBuilder sb = new StringBuilder();
        // ensure only one space exist between words in a string
        while (left <= right) {
            char c = str.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') sb.append(c);
            left++;
        }
        return sb;
    }

    private static void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }

    private static void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0;
        int end = 0;
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') end++;
            reverse(sb, start, end - 1);
            start = end + 1;
            end++;
        }
    }

    private static String reverseString(String str) {
        if (str.length() == 0) return "";

        return reverseString(str.substring(1, str.length())) + str.charAt(0);
    }
}
