package practice.dp;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;
        int[] dp = new int[n];
        int[] countDP = new int[n];
        dp[0] = 1;
        countDP[0] = 1;
        int maxLISLength = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            countDP[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    countDP[i] = countDP[j];
                } else if (arr[j] < arr[i] && dp[i] == dp[j] + 1) {
                    countDP[i] += countDP[j];
                }
            }
            maxLISLength = Math.max(maxLISLength, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) if (dp[i] == maxLISLength) res += countDP[i];
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 7};
        int[] arr2 = {2, 2, 2, 2, 2};
        int[] arr3 = {1, 2, 4, 3, 5, 4, 7, 2};
        NumberOfLongestIncreasingSubsequence number = new NumberOfLongestIncreasingSubsequence();
//        System.out.println(number.findNumberOfLIS(arr));
//        System.out.println(number.findNumberOfLIS(arr2));
        System.out.println(number.findNumberOfLIS(arr3));
    }
}
