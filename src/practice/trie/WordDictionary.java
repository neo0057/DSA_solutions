package practice.trie;

import java.util.HashMap;

public class WordDictionary {
    static class TrieNodeWithMap {
        boolean isEndOfWord;
        HashMap<Character, TrieNodeWithMap> trieNodeMap;

        TrieNodeWithMap() {
            this.isEndOfWord = false;
            this.trieNodeMap = new HashMap<>();
        }
    }

    private final TrieNodeWithMap root;

    public WordDictionary() {
        this.root = new TrieNodeWithMap();
    }

    public void addWord(String word) {
        TrieNodeWithMap node = root;
        for (int index = 0; index < word.length(); index++) {
            char character = word.charAt(index);
            if (!node.trieNodeMap.containsKey(character)) node.trieNodeMap.put(character, new TrieNodeWithMap());
            node = node.trieNodeMap.get(character);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchRec(word, root, 0);
    }

    private boolean searchRec(String word, TrieNodeWithMap node, int index) {
        if (node == null) return false;
        if (index == word.length()) return node.isEndOfWord;
        char character = word.charAt(index);
        if (character == '.') {
            for (Character ch : node.trieNodeMap.keySet()) {
                boolean isFound = searchRec(word, node.trieNodeMap.get(ch), index + 1);
                if (isFound) return true;
            }
        } else if (!node.trieNodeMap.containsKey(character)) return false;
        return searchRec(word, node.trieNodeMap.get(character), index + 1);
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search("aa"));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".a"));
        System.out.println(wordDictionary.search("a."));
    }
}
