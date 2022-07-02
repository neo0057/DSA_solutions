package practice.string;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Boolean> wordMap = new HashMap<>();
        for (String word : wordList) wordMap.put(word, true);
        if (!wordList.contains(endWord)) return 0;
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String currWord = queue.poll();
                wordMap.remove(currWord);
                if (currWord.equals(endWord)) return level;
                for (String key : wordList) {
                    if (!key.equals(currWord) && wordMap.containsKey(key) && isValid(currWord, key)) {
                        queue.offer(key);
                        System.out.println("selected word: " + key + ", level: " + level);
                        wordMap.remove(key);
                    }
                }
                size--;
            }
            level++;
        }
        return 0;
    }

    private boolean isValid(String beginWord, String endWord) {
        int i = 0, count = 0;
        while (i < beginWord.length()) {
            if (count > 1) return false;
            if (beginWord.charAt(i) != endWord.charAt(i)) count++;
            i++;
        }
        return count < 2;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
//        wordList.add("cog");
        System.out.println(wordLadder.ladderLength("hit", "cog", wordList));
    }
}
