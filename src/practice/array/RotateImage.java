package practice.array;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) return;
        int i,j;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left < right && top < bottom) {
            int[] prv = new int[n];
            i = left;
            j = bottom;
            for (i = left; i <= right; i++) {
                prv[i] = matrix[top][i];
                matrix[j++][left] = matrix[left][i];
            }
            left++;
            for (j = bottom; j >= top; j--) {
               //matrix[top][]
                matrix[j][left] = matrix[left][i++];
            }
            //for (i = top; i <= bottom; i++)

        }
    }
}
