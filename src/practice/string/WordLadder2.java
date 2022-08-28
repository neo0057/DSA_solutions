package practice.string;

import java.util.*;

public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Boolean> wordMap = new HashMap<>();
        for (String word : wordList) wordMap.put(word, true);
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)) return result;
        List<String> subResult = new ArrayList<>();
        queue.offer(beginWord);
        subResult.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String currWord = queue.poll();
                wordMap.remove(currWord);
                if (currWord.equals(endWord)) {
                    subResult.add(currWord);
                    List<String> newResult = new ArrayList<>(subResult);
                    result.add(newResult);
                    String toRemove = subResult.get(subResult.size() - 1);
                    subResult.remove(toRemove);
                    wordMap.put(toRemove, true);
                }
                for (String key : wordList) {
                    if (!key.equals(currWord) && wordMap.containsKey(key) && isValid(currWord, key)) {
                        queue.offer(key);
                        System.out.println("selected word: " + key + ", level: " + level);
                        subResult.add(key);
//                        result.add(new ArrayList<>(subResult));
                        wordMap.remove(key);
                    }
                }
                size--;
            }
            level++;
        }
        return result;
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
        WordLadder2 wordLadder = new WordLadder2();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(wordLadder.findLadders("hit", "cog", wordList));
    }
}
