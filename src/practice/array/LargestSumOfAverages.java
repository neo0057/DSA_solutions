package practice.array;

import java.util.Arrays;

public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] nums, int k) {
        Arrays.sort(nums);
        double res = 0;
        int len = nums.length;
        int i = len - 1;
        int c = 0;
        while (c < k - 1) {
            res += nums[i];
            i--;
            c++;
        }
        int sum = 0;
        for (int j = 0; j <= i; j++) sum += nums[j];
        res += (double) sum / (i + 1);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9, 1, 2, 3, 9};
        LargestSumOfAverages largestSumOfAverages = new LargestSumOfAverages();
        System.out.println(largestSumOfAverages.largestSumOfAverages(nums, 3));
        System.out.println(largestSumOfAverages.largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4));
    }
}
