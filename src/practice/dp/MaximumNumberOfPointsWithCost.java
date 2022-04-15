package practice.dp;

public class MaximumNumberOfPointsWithCost {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = points[0][i];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + points[i][j] - Math.abs(j - k));
                }
            }
        }
        long res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) res = Math.max(res, dp[m - 1][i]);
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 2, 3}, {1, 5, 1}, {3, 1, 1}};
        int[][] points2 = {{1, 5}, {2, 3}, {4, 2}};
        MaximumNumberOfPointsWithCost maximumNumberOfPointsWithCost = new MaximumNumberOfPointsWithCost();
        System.out.println(maximumNumberOfPointsWithCost.maxPoints(points));
        System.out.println(maximumNumberOfPointsWithCost.maxPoints(points2));
    }
}
