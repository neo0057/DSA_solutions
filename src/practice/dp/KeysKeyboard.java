package practice.dp;

public class KeysKeyboard {
    public int minSteps(int n) {
        if (n == 1) return 0;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) dp[i] = (dp[i] == 0) ? dp[j] + i / j : Math.min(dp[i], dp[j] + i / j);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        KeysKeyboard keysKeyboard = new KeysKeyboard();
        System.out.println(keysKeyboard.minSteps(30));
    }
}
