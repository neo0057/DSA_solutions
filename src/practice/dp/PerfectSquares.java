package practice.dp;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        if (n < 2) return n;
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        System.out.println(perfectSquares.numSquares(13));
        System.out.println(perfectSquares.numSquares(12));
    }
}
