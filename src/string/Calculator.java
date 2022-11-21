package string;

import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    Map<Character, BiFunction<Integer, Integer, Integer>> ops = Map.of(
            '+', (a, b) -> a + b,
            '-', (a, b) -> a - b
    );
    Tokenizer tokenizer;

    public int calculate(String str) {
        tokenizer = new Tokenizer(str);

        return expr();
    }

    private int expr() {
        int acc = factor();
        while (tokenizer.hasNext() && ops.containsKey(tokenizer.currentChar())) {
            char op = tokenizer.currentChar();
            tokenizer.next();
            acc = ops.get(op).apply(acc, factor());
        }

        return acc;
    }

    private Integer factor() {
        int neg = 1;
        if (tokenizer.currentChar() == '-') {
            tokenizer.next();
            neg = -1;
        }

        int n = 0;
        if (tokenizer.currentChar() == '(') {
            tokenizer.next();
            n = expr();
            tokenizer.next();
        } else if (tokenizer.isDigit()) {
            n = num();
        }

        return n * neg;
    }

    private int num() {
        int n = 0;
        while (tokenizer.hasNext() && tokenizer.isDigit()) {
            n = (n * 10) + (tokenizer.currentChar() - '0');
            tokenizer.next();
        }

        return n;
    }
}
