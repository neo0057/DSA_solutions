package practice.string;

import java.util.*;

public class SortCharacterByFrequency {
    public String frequencySort(String s) {
        SortedMap<Integer, List<Character>> sortedMap = new TreeMap<>();
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                Integer f = map.get(arr[i]);
                map.put(arr[i], f + 1);
            } else map.put(arr[i], 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (sortedMap.containsKey(entry.getValue())) {
                List<Character> list = sortedMap.get(entry.getValue());
                list.add(entry.getKey());
                sortedMap.put(entry.getValue(), list);
            } else {
                List<Character> list = new ArrayList<>();
                list.add(entry.getKey());
                sortedMap.put(entry.getValue(), list);
            }
        }
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> keys = new ArrayList<>(sortedMap.keySet());
        for (int i = keys.size() - 1; i >= 0; i--) {
            List<Character> charList = sortedMap.get(keys.get(i));
            for (Character character : charList) {
                for (int j = 0; j < keys.get(i); j++) res.append(character);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        SortCharacterByFrequency sortCharacterByFrequency = new SortCharacterByFrequency();
        System.out.println(sortCharacterByFrequency.frequencySort("tree"));
    }
}
