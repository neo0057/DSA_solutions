package practice.array;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        int diff, res = 0;
        for (int num : nums) {
            if (numMap.get(num) == 0) continue;
            diff = k - num;
            if (!numMap.containsKey(diff)) continue;
            if (num == diff) {
                if (numMap.getOrDefault(num, 0) >= 2) {
                    res++;
                    numMap.put(num, numMap.get(num) - 2);
                }
            } else if (numMap.getOrDefault(diff, 0) > 0) {
                res++;
                numMap.put(num, numMap.getOrDefault(num, 1) - 1);
                numMap.put(diff, numMap.getOrDefault(diff, 1) - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 3};
        int[] nums2 = {1, 2, 3, 4};
        MaxNumberOfKSumPairs maxNumberOfKSumPairs = new MaxNumberOfKSumPairs();
        System.out.println(maxNumberOfKSumPairs.maxOperations(nums, 6));
        System.out.println(maxNumberOfKSumPairs.maxOperations(nums2, 5));
    }
}
