package practice.backtracking;

public class PathWithMaximumGold {
    int max = 0;

    public int getMaximumGold(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) max = Math.max(max, dfs(grid, i, j, row, col, visited, 0));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int row, int col, boolean[][] visited, int curr) {
        if (i < 0 || j < 0 || i >= row || j >= col || visited[i][j] || grid[i][j] == 0) {
            max = Math.max(max, curr);
            return max;
        }
        visited[i][j] = true;
        int p1 = dfs(grid, i - 1, j, row, col, visited, curr + grid[i][j]);
        int p2 = dfs(grid, i + 1, j, row, col, visited, curr + grid[i][j]);
        int p3 = dfs(grid, i, j - 1, row, col, visited, curr + grid[i][j]);
        int p4 = dfs(grid, i, j + 1, row, col, visited, curr + grid[i][j]);
        visited[i][j] = false;
        return Math.max(p1, Math.max(p2, Math.max(p3, p4)));
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        PathWithMaximumGold pathWithMaximumGold = new PathWithMaximumGold();
        System.out.println(pathWithMaximumGold.getMaximumGold(grid));
    }
}
