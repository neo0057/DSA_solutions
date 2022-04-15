package practice.backtracking;

public class StoneGameVII {
    public int stoneGameVII(int[] stones) {
        int len = stones.length;
        if (len <= 2) return Math.max(stones[0], (len > 1) ? stones[1] : 0);
        int[][][] dp = new int[len][len][2];
        int totalSum = 0;
        for (int stone : stones) totalSum += stone;
        winGame(stones, totalSum, 0, len - 1, 0, dp);
        return dp[0][len - 1][0] - dp[0][len - 1][1];
    }

    private int winGame(int[] stones, int sum, int i, int j, int k, int[][][] dp) {
        if (i > j) return 0;
        if(i + 1 == j) return Math.max(stones[i], stones[j]);
        if (dp[i][j][k] != 0) return dp[i][j][k];
        int nextK = (k == 0) ? 1 : 0;
        int firstChoice = sum - stones[i] + Math.min(winGame(stones, sum - stones[i], i + 2, j, nextK, dp), winGame(stones, sum - stones[i], i + 1, j - 1, nextK, dp));
        int secondChoice = sum - stones[j] + Math.min(winGame(stones, sum - stones[j], i, j - 2, nextK, dp), winGame(stones, sum - stones[j], i + 1, j - 1, nextK, dp));
        dp[i][j][k] = Math.max(firstChoice, secondChoice);
        return dp[i][j][k];
    }

    public static void main(String[] args) {
        int[] stones = {5, 3, 1, 4, 2};
        int[] stones2 = {7, 90, 5, 1, 100, 10, 10, 2};
        StoneGameVII stoneGameVII = new StoneGameVII();
        System.out.println("Can win diff: " + stoneGameVII.stoneGameVII(stones2));
    }
}
