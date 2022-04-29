package practice.array;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = nums[n - 1] + nums[0];
        int l = 1, r = n - 2;
        while (l < r) {
            res = Math.max(res, nums[l] + nums[r]);
            l++;
            r--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 2, 4, 6};
        int[] arr2 = {3, 5, 2, 3};
        int[] arr3 = {4, 1, 5, 1, 2, 5, 1, 5, 5, 4};
        MinimizeMaximumPairSumInArray minimizeMaximumPairSumInArray = new MinimizeMaximumPairSumInArray();
        System.out.println(minimizeMaximumPairSumInArray.minPairSum(arr));
        System.out.println(minimizeMaximumPairSumInArray.minPairSum(arr2));
        System.out.println(minimizeMaximumPairSumInArray.minPairSum(arr3));
    }
}
