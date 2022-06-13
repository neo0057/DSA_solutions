package practice.trie;

public class TrieNode {
    private static final int ALPHABET_SIZE = 26;
    TrieNode[] childrens = new TrieNode[ALPHABET_SIZE];
    boolean isEndOfWord;

    public TrieNode() {
        this.isEndOfWord = false;
    }
}
