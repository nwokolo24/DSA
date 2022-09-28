package trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();  // root node is null
    }
    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];  // 26 english characters from a - z
            this.isWord = false;
        }
    }

    public static void main(String[] args) {

    }
}
