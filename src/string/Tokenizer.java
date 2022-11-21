package string;

public class Tokenizer {
    String data;
    int currentIndex;

    public Tokenizer(String input) {
        data = input;
        currentIndex = 0;
        skipWhiteSpace();
    }

    public void next() {
        currentIndex++;
        skipWhiteSpace();
    }

    public boolean isDigit() {
        return Character.isDigit(currentChar());
    }
    public void skipWhiteSpace() {
        while (hasNext() && currentChar() == ' ') {
            currentIndex++;
        }
    }

    public char currentChar() {
        return data.charAt(currentIndex);
    }

    public boolean hasNext() {
        return currentIndex < data.length();
    }
}
