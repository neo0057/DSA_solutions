package practice.dp;

import java.util.Arrays;

public class MoveBall {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] left = new int[n];
        int[] dp = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                total++;
                dp[0] += i;
            }
            left[i] = total;
        }

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + left[i - 1] - (total - left[i - 1]);
        }
        return dp;
    }

    public static void main(String[] args) {
        String boxes = "001011";
        MoveBall moveBall = new MoveBall();
        System.out.println(Arrays.toString(moveBall.minOperations(boxes)));
    }
}
