package stacks;

import java.util.Stack;

public class ValidateParentheses {
    public static void main(String[] args) {
        String str = "{}{}(){[][]}";
        System.out.println(isValid(str));
    }

    private static boolean isValid(String str) {
        if (str.length() == 0) return true;

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if ((c == ')' && top == '(')
                        || (c == '}' && top == '{')
                        || (c == ']' && top == '[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
