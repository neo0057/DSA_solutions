package practice.backtracking;

public class TargetSum {
    int res;

    public int findTargetSumWays(int[] arr, int target) {
        res = 0;
        findTargetSumWaysRec(arr, 0, 0, target);
        return res;
    }

    private void findTargetSumWaysRec(int[] arr, int sum, int index, int target) {
        if (index >= arr.length) {
            if (sum == target) res++;
        } else {
            findTargetSumWaysRec(arr, sum + arr[index], index + 1, target);
            findTargetSumWaysRec(arr, sum - arr[index], index + 1, target);
        }
    }

    public int findTargetSumWays2(int[] arr, int target) {
        int n = arr.length;
        int sum = 0;
        for (int a : arr) sum += a;
        if (target > sum || (sum - target) % 2 == 1) return 0;
        sum = (sum + target) / 2;
        if (sum < 0) return 0;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 1; i <= sum; i++) dp[0][i] = 0;
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= arr[i - 1]) dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        TargetSum targetSum = new TargetSum();
//        System.out.println(targetSum.findTargetSumWays(arr, 3));
        System.out.println(targetSum.findTargetSumWays2(arr, 3));
    }
}
