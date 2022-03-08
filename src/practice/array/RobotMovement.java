package practice.array;

public class RobotMovement {
    /**
     * https://leetcode.com/problems/unique-paths-ii/
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // corner cases
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
        if (m == 1 && n == 1 && obstacleGrid[m - 1][n - 1] == 0) return 1;
        if (m == 1 && n == 1 && obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[][] dp = new int[m][n];
        int i, j;
        dp[0][0] = 1;
        for (i = 1; i < m; i++) dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) ? 1 : 0;
        for (i = 1; i < n; i++) dp[0][i] = (obstacleGrid[0][i] == 0 && dp[0][i - 1] == 1) ? 1 : 0;
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
            }
        }
        print(dp);
        return dp[m - 1][n - 1];
    }

    private static void print(int[][] arr) {
        for (int[] rowArr : arr) {
            for (int element : rowArr) System.out.print(element + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println("res: " + uniquePathsWithObstacles(grid));
        int[][] grid2 = {{0,0},{1,1},{0,0}};
        System.out.println("res: " + uniquePathsWithObstacles(grid2));
    }
}
