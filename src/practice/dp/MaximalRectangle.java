package practice.dp;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int ans = Integer.MIN_VALUE, r = matrix.length, c = matrix[0].length;
        int[] heights = new int[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            int area = largestRectangleArea(heights);
            ans = Math.max(ans, area);
        }
        return ans;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0, h, w;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[i] <= heights[stack.peek()])) {
                h = heights[stack.pop()];
                if (stack.empty()) w = i;
                else w = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'0', '1'}, {'1', '0'}};
        char[][] matrix2 = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        System.out.println(maximalRectangle.maximalRectangle(matrix2));
    }
}
