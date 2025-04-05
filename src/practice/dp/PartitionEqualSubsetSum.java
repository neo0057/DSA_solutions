package practice.dp;

public class PartitionEqualSubsetSum {

    private boolean targetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i < n; i++) dp[i][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j && dp[i - 1][j - arr[i - 1]]) dp[i][j] = true;
                else if (dp[i - 1][j]) dp[i][j] = true;
            }
        }
        return dp[n][target];
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 == 1) return false;
        return targetSum(nums, totalSum / 2);
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1, 1}));
    }
}
