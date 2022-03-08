package practice.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int val : nums) set.add(val);
        for (int value : nums) {
            if (!set.contains(value)) continue;
            int count = 0;
            int val = value;
            while (set.contains(val)) {
                count++;
                set.remove(val);
                val--;
            }
            val = value;
            while (set.contains(val)) {
                count++;
                set.remove(val);
                val++;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("len: " + longestConsecutive(arr));
    }
}
