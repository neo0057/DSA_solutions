package practice.array;

import java.util.*;

public class TopKFrequentWords {
    static class Pair {
        public String name;
        public Integer freq;

        public Pair(String name, Integer freq) {
            this.name = name;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        int index = 0;
        Pair[] pairs = new Pair[freqMap.size()];
        for (String name : freqMap.keySet()) pairs[index++] = new Pair(name, freqMap.get(name));
        Comparator<Pair> comparator = (p1, p2) -> {
            if (!Objects.equals(p1.freq, p2.freq)) return p1.freq - p2.freq;
            else {
                int comp = p1.name.compareTo(p2.name);
                if (comp == 0) return 0;
                if (comp >= 1) return -1;
                return 1;
            }
        };
        Arrays.sort(pairs, comparator);
        List<String> res = new ArrayList<>();
        for (int i = freqMap.size() - 1; i > freqMap.size() - k - 1; i--) res.add(pairs[i].name);
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        System.out.println(topKFrequentWords.topKFrequent(words, k));
    }
}
