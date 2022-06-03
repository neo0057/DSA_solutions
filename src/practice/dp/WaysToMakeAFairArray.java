package practice.dp;

public class WaysToMakeAFairArray {
    public int waysToMakeFair(int[] nums) {
        int len = nums.length;
        int[] leftOddSumDP = new int[len];
        int[] leftEvenSumDP = new int[len];
        int[] rightOddSumDP = new int[len];
        int[] rightEvenSumDP = new int[len];
        leftEvenSumDP[0] = nums[0];
        leftEvenSumDP[1] = leftEvenSumDP[0];
        leftOddSumDP[0] = 0;
        leftOddSumDP[1] = nums[1];
        for (int i = 2; i < len; i++) {
            if (i % 2 == 0) {
                leftEvenSumDP[i] = leftEvenSumDP[i - 2] + nums[i];
                leftOddSumDP[i] = leftOddSumDP[i - 1];
            } else {
                leftOddSumDP[i] = leftOddSumDP[i - 2] + nums[i];
                leftEvenSumDP[i] = leftEvenSumDP[i - 1];
            }
        }

        boolean isEven = ((len - 1) % 2) == 0;
        rightEvenSumDP[len - 1] = (isEven) ? nums[len - 1] : 0;
        rightEvenSumDP[len - 2] = (isEven) ? rightEvenSumDP[len - 1] : nums[len - 2];
        rightOddSumDP[len - 1] = (isEven) ? 0 : nums[len - 1];
        rightOddSumDP[len - 2] = (isEven) ? nums[len - 1] : rightOddSumDP[len - 1];
        for (int i = len - 3; i >= 0; i--) {
            if (i % 2 == 0) {
                rightEvenSumDP[i] = rightEvenSumDP[i + 2] + nums[i];
                rightOddSumDP[i] = rightOddSumDP[i + 1];
            } else {
                rightOddSumDP[i] = rightOddSumDP[i + 2] + nums[i];
                rightEvenSumDP[i] = rightEvenSumDP[i + 1];
            }
        }
        int res = 0, evenSum, oddSum;
        for (int i = 0; i < len; i++) {
            evenSum = leftEvenSumDP[i] + rightOddSumDP[i] - nums[i];
            oddSum = leftOddSumDP[i] + rightEvenSumDP[i] - nums[i];
            if (evenSum == oddSum) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        WaysToMakeAFairArray ways = new WaysToMakeAFairArray();
        int[] nums = {2, 1, 6, 4};
//        System.out.println(ways.waysToMakeFair(nums));
//        System.out.println(ways.waysToMakeFair(new int[]{1, 1, 1}));
        System.out.println(ways.waysToMakeFair(new int[]{1, 2, 3}));
    }
}
