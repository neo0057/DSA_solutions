package practice.dp;

public class MinimumSidewayJumps {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[4][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= 3; j++) {
                dp[j][i] = dp[j][i + 1];
                if (obstacles[i] == j)
                    dp[j][i] = Integer.MAX_VALUE;
            }
            int j = obstacles[i + 1];
            dp[j][i] = Math.min(dp[1][i], Math.min(dp[2][i], dp[3][i])) + 1;
        }
        return dp[2][0];
    }

    public static void main(String[] args) {
        int[] obstacles = {0,1,2,3,0};
        MinimumSidewayJumps minimumSidewayJumps = new MinimumSidewayJumps();
        System.out.println(minimumSidewayJumps.minSideJumps(obstacles));
    }
}
