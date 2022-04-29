package practice.string;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        int singleFreqCount = 0;
        for (Character key : freqMap.keySet()) singleFreqCount += (freqMap.get(key) % 2 == 0) ? 0 : 1;
        return singleFreqCount <= k;
    }

    public static void main(String[] args) {
        ConstructKPalindromeStrings constructKPalindromeStrings = new ConstructKPalindromeStrings();
        System.out.println(constructKPalindromeStrings.canConstruct("annabelle", 2));
        System.out.println(constructKPalindromeStrings.canConstruct("leetcode", 3));
        System.out.println(constructKPalindromeStrings.canConstruct("yzyzyzyzyzyzyzy", 2));
    }
}
