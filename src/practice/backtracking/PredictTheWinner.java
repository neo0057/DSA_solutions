package practice.backtracking;

public class PredictTheWinner {
    public boolean predictWinner(int[] nums) {
        int len = nums.length;
        if (len <= 2) return true;
        int[][] dp = new int[len][len];
        int p1Sum = winGame(nums, 0, len - 1, dp);
        int p2Sum = 0;
        for (int i = 0; i < len; i++) p2Sum += nums[i];
        p2Sum -= p1Sum;
        return p1Sum >= p2Sum;
    }

    private int winGame(int[] nums, int i, int j, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        int firstChoice = nums[i] + Math.min(winGame(nums, i + 2, j, dp), winGame(nums, i + 1, j - 1, dp));
        int secondChoice = nums[j] + Math.min(winGame(nums, i, j - 2, dp), winGame(nums, i + 1, j - 1, dp));
        dp[i][j] = Math.max(firstChoice, secondChoice);
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 233, 7};
        PredictTheWinner predictTheWinner = new PredictTheWinner();
        System.out.println(predictTheWinner.predictWinner(arr));
    }
}
