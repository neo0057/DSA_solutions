package practice.array;

public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) dp[i][j] = -1;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, dp, i, j, m, n, Integer.MIN_VALUE));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int[][] dp, int i, int j, int m, int n, int val) {
        if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] == -1) return 0;
        if (matrix[i][j] <= val) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int temp = matrix[i][j];
        matrix[i][j] = -1;
        int left = dfs(matrix, dp, i, j - 1, m, n, temp);
        int right = dfs(matrix, dp, i, j + 1, m, n, temp);
        int up = dfs(matrix, dp, i - 1, j, m, n, temp);
        int down = dfs(matrix, dp, i + 1, j, m, n, temp);
        int res = 1 + Math.max(Math.max(left, right), Math.max(up, down));
        matrix[i][j] = temp;
        dp[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        LongestIncreasingPathInAMatrix longestIncreasingPathInAMatrix = new LongestIncreasingPathInAMatrix();
        System.out.println(longestIncreasingPathInAMatrix.longestIncreasingPath(matrix));
    }
}
