package practice.trie;

public class Trie {
    private TrieNode root;

    public void insert(String word) {
        int length = word.length();
        if (root == null) root = new TrieNode();
        TrieNode node = root;
        for (int level = 0; level < length; level++) {
            int index = word.charAt(level) - 'a';
            if (node.childrens[index] == null) node.childrens[index] = new TrieNode();
            node = node.childrens[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        if (root == null) return false;
        int length = word.length();
        TrieNode node = root;
        for (int level = 0; level < length; level++) {
            int index = word.charAt(level) - 'a';
            if (node.childrens[index] == null) return false;
            node = node.childrens[index];
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        if (root == null) return false;
        int level;
        int length = prefix.length();
        int index;
        TrieNode node = root;
        for (level = 0; level < length; level++) {
            index = prefix.charAt(level) - 'a';
            if (node.childrens[index] == null) return false;
            node = node.childrens[index];
        }
        return node != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
    }
}
