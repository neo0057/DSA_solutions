package practice.array;

public class MaximumAbsoluteSumOfAnySubArray {
    public int maxAbsoluteSum(int[] nums) {
        int res = Integer.MIN_VALUE, sum1 = 0, sum2 = 0;
        for (int num : nums) {
            sum1 += num;
            sum2 += (num * -1);
            res = Math.max(res, Math.max(sum1, sum2));
            if (sum1 < 0) sum1 = 0;
            if (sum2 < 0) sum2 = 0;

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, -3, 2, 3, -4};
        MaximumAbsoluteSumOfAnySubArray maximumAbsoluteSumOfAnySubArray = new MaximumAbsoluteSumOfAnySubArray();
        System.out.println(maximumAbsoluteSumOfAnySubArray.maxAbsoluteSum(nums));
    }
}
