package practice.backtracking;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 1][1];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                else if (arr[i] < arr[j]) dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};
        WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        System.out.println(wiggleSubsequence.wiggleMaxLength(nums));
    }
}
