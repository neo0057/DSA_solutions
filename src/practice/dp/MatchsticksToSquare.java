package practice.dp;

import java.util.Arrays;

public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        int len = matchsticks.length;
        if (len < 4) return false;
        int sum = 0;
        for (int i = 0; i < len; i++) sum += matchsticks[i];
        if (sum % 4 > 0) return false;
        boolean[] used = new boolean[len];
        return partition(4, sum/4, 0, matchsticks, used, 0);
    }

    private boolean partition(int k, int sum, int cs, int[] nums, boolean[] used, int start) {
        if (k == 1) return true;
        if (cs == sum) return partition(k - 1, sum, 0, nums, used, 0);
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cs + nums[i] <= sum) {
                used[i] = true;
                if (partition(k, sum, cs + nums[i], nums, used, i + 1)) return true;
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2};
        MatchsticksToSquare matchsticksToSquare = new MatchsticksToSquare();
        System.out.println(matchsticksToSquare.makesquare(arr));
    }
}
