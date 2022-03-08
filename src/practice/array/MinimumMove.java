package practice.array;

import java.util.Arrays;

public class MinimumMove {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int prvMoves = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int diff = nums[nums.length - 1] - nums[i];
            res += diff - prvMoves;
            prvMoves = diff;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        MinimumMove mm = new MinimumMove();
        System.out.println(mm.minMoves(arr));
    }
}
