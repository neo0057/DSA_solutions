package practice.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for (int num : nums) dp[num]++;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < dp.length; i++) if (dp[i] > 1) res.add(i);
        return res;
    }
}
