package string;

public class MyString {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int val = 8;
        sb.append("A");
        sb.append("(");
        sb.append(")");
        sb.append("A");

        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == ')' && sb.charAt(i - 1) == '(') {
                sb.deleteCharAt(i-1);
                sb.deleteCharAt(i);
            }
        }

        System.out.println(sb.toString());
    }
}
