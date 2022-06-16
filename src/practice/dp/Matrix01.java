package practice.dp;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) dp[i][j] = -1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    boolean[][] visited = new boolean[m][n];
                    dfs(mat, i, j, i, j, m, n, 1, dp, visited);
                }
            }
        }
        return dp;
    }

    private void dfs(int[][] mat, int i, int j, int i1, int i2, int m, int n, int cost, int[][] dp, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (dp[i1][i2] != -1 && dp[i1][i2] < cost) return;
        if (visited[i][j]) return;
        if (dp[i][j] != -1) {
            if (dp[i1][i2] == -1) dp[i1][i2] = cost;
            else dp[i1][i2] = Math.min(dp[i1][i2], dp[i][j] + cost);
        }
        visited[i][j] = true;
        dfs(mat, i, j - 1, i1, i2, m, n, cost + 1, dp, visited);
        dfs(mat, i, j + 1, i1, i2, m, n, cost + 1, dp, visited);
        dfs(mat, i - 1, j, i1, i2, m, n, cost + 1, dp, visited);
        dfs(mat, i + 1, j, i1, i2, m, n, cost + 1, dp, visited);
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] mat2 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Matrix01 matrix01 = new Matrix01();
        int[][] res = matrix01.updateMatrix(mat);
        int[][] res2 = matrix01.updateMatrix(mat2);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[i].length; j++) {
//                System.out.print(res2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
