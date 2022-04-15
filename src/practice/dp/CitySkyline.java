package practice.dp;

public class CitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] row = new int[n];
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[i] = Math.max(col[i], grid[j][i]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minHeightBuilding = Math.min(row[i], col[j]);
                res += (minHeightBuilding > grid[i][j]) ? minHeightBuilding - grid[i][j] : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        int[][] grid2 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        CitySkyline citySkyline = new CitySkyline();
        System.out.println(citySkyline.maxIncreaseKeepingSkyline(grid));
        System.out.println(citySkyline.maxIncreaseKeepingSkyline(grid2));
    }
}
