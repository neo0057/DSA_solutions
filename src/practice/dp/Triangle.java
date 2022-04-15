package practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][];
        for (int i = 0; i < len; i++) {
            int sz = triangle.get(i).size();
            dp[i] = new int[sz];
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            List<Integer> arr = triangle.get(i);
            int colSize = arr.size();
            dp[i][0] = dp[i - 1][0] + arr.get(0);
            for (int j = 1; j < colSize; j++) {
                if (j < colSize - 1) dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + arr.get(j);
                else dp[i][j] = dp[i - 1][j - 1] + arr.get(j);
            }
        }
        int res = dp[len - 1][0];
        for (int i = 1; i < triangle.get(len - 1).size(); i++) res = Math.min(res, dp[len - 1][i]);
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(List.of(2));
        arr.add(Arrays.asList(3, 4));
        arr.add(Arrays.asList(6, 5, 7));
        arr.add(Arrays.asList(4, 1, 8, 3));
        Triangle t = new Triangle();
        System.out.println("res: " + t.minimumTotal(arr));
    }
}