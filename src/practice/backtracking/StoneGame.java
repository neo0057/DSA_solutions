package practice.backtracking;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        if (len <= 2) return true;
        int[][] dp = new int[len][len];
        int p1Sum = winGame(piles, 0, len - 1, dp);
        int p2Sum = 0;
        for (int pile : piles) p2Sum += pile;
        p2Sum -= p1Sum;
        return p1Sum >= p2Sum;
    }
    private int winGame(int[] piles, int i, int j, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        int firstChoice = piles[i] + Math.min(winGame(piles, i + 2, j, dp), winGame(piles, i + 1, j - 1, dp));
        int secondChoice = piles[j] + Math.min(winGame(piles, i, j - 2, dp), winGame(piles, i + 1, j - 1, dp));
        dp[i][j] = Math.max(firstChoice, secondChoice);
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] piles = {5,3,4,5};
        StoneGame stoneGame = new StoneGame();
        System.out.println("Can alice win: " + stoneGame.stoneGame(piles));
    }
}
