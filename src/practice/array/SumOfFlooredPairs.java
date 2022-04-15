package practice.array;

import java.util.Arrays;

public class SumOfFlooredPairs {
    public int sumOfFlooredPairs(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int t = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = t;
        }
        int res = n;
//        int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] > nums[i]) break;
                res += Math.floor(nums[i] / nums[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 9};
        int[] arr2 = {7, 7, 7, 7, 7, 7, 7};
        SumOfFlooredPairs sumOfFlooredPairs = new SumOfFlooredPairs();
        System.out.println(sumOfFlooredPairs.sumOfFlooredPairs(arr));
        System.out.println(sumOfFlooredPairs.sumOfFlooredPairs(arr2));
    }
}
