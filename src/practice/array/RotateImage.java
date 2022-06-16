package practice.array;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int start = 0, end = n - 1;
        while (start < end) {
            for (int i = start; i < end; i++) {
//                int top = matrix[start][i];
//                int right = matrix[i][end];
//                int bottom = matrix[end][n - i];
//                int left = matrix[n - i - 1][start];

                int temp = matrix[start][i];
                matrix[start][i] = matrix[n - i - 1][start];
                matrix[n - i - 1][start] = matrix[end][n - i - 1];
                matrix[end][n - i - 1] = matrix[i][end];
                matrix[i][end] = temp;
            }
            start++;
            end--;
        }
    }
}
