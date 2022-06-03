package practice.dp;

public class CountSquareSubMatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        int res = matrix[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0];
            res += matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i];
            res += matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) dp[i][j] = 0;
                else dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                res += dp[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        CountSquareSubMatricesWithAllOnes matricesWithAllOnes = new CountSquareSubMatricesWithAllOnes();
        System.out.println(matricesWithAllOnes.countSquares(matrix));
    }
}
