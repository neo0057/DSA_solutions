package practice.array;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class MatrixSearch {
     public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++) {
            if(target < matrix[i][0] || target > matrix[i][col - 1]) continue;
            boolean isAvailable = binarySearch(matrix[i], col, target);
            if(isAvailable) return true;
        }
        return false;
    }

    private static boolean binarySearch(int[] matrix, int col, int target) {
        int m, l = 0, r = col - 1;
        while (l <= r) {
            m = (l + r)/2;
            if (matrix[m] == target) return true;
            if (matrix[m] < target) l = m + 1;
            else r = m - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        int target = 1;
        System.out.println("target " + target + " is available: " + searchMatrix(matrix, target));
    }
}
