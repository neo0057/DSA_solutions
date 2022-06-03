package practice.dp;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodWaysToSplitAString {
    public int numSplits(String s) {
        int len = s.length();
        int[] leftDp = new int[len];
        int[] rightDp = new int[len];
        Map<Character, Boolean> freqMap = new HashMap<>();
        leftDp[0] = 1;
        freqMap.put(s.charAt(0), true);
        for (int i = 1; i < len; i++) {
            char ch = s.charAt(i);
            leftDp[i] = leftDp[i - 1] + ((freqMap.containsKey(ch)) ? 0 : 1);
            freqMap.put(ch, true);
        }
        freqMap.clear();
        rightDp[len - 1] = 1;
        freqMap.put(s.charAt(len - 1), true);
        for (int i = len - 2; i >= 0; i--) {
            char ch = s.charAt(i);
            rightDp[i] = rightDp[i + 1] + ((freqMap.containsKey(ch)) ? 0 : 1);
            freqMap.put(ch, true);
        }
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            if (leftDp[i] == rightDp[i + 1]) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfGoodWaysToSplitAString number = new NumberOfGoodWaysToSplitAString();
        System.out.println(number.numSplits("aacaba"));
        System.out.println(number.numSplits("abcd"));
    }
}
