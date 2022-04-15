package practice.dp;

public class KnightDialer {

    public int knightDialer(int n) {
        int[][] dp = new int[10][n + 1];
        int res = 0;
        int mod = 1000000007;
        int[][] possibleMoves = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};

        // there is 1 way to reach i'th number in 1 step
        for (int i = 0; i < 10; i++) dp[i][1] = 1;

        for (int step = 2; step <= n; step++) {
            for (int curNum = 0; curNum < 10; curNum++) {
                for (int prevNum : possibleMoves[curNum]) dp[curNum][step] = (dp[curNum][step] + dp[prevNum][step - 1]) % mod;
            }
        }
        for (int i = 0; i < 10; i++) res = (res + dp[i][n]) % mod;
        return res;
    }

    public static void main(String[] args) {
        KnightDialer knightDialer = new KnightDialer();
        System.out.println(knightDialer.knightDialer(2));
    }
}
