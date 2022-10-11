package string;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String str = "2[abc]3[cd]ef";
        System.out.println(decodeString(str));
    }

    private static String decodeString(String s) {
        if (s.length() == 0) return "";

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        int digit = 0;
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digit = digit * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                word.append(c);
            } else if (c == '[') {
                numStack.push(digit);
                strStack.push(word.toString());

                digit = 0;
                word = new StringBuilder();
            } else {
                int count = numStack.pop();
                StringBuilder decodStr = new StringBuilder(strStack.pop());

//                decodStr.append(String.valueOf(word).repeat(Math.max(0, count)));  // shorthand

                for (int j = 0; j < count; j++) {
                    decodStr.append(word);
                }
                word = decodStr;
            }
        }
        return word.toString();
    }
}
