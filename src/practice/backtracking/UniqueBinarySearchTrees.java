package practice.backtracking;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return numTreesRec(1, n, dp);
    }

    private int numTreesRec(int start, int end, int[][] dp) {
        int count = 0;
        if (start > end) return 1;
        if (dp[start][end] != 0) return dp[start][end];
        for (int i = start; i <= end; i++) {
            int leftCount = numTreesRec(start, i - 1, dp);
            int rightCount = numTreesRec(i + 1, end, dp);
            count += leftCount * rightCount;
        }
        dp[start][end] = count;
        return count;
    }

    public int numTrees2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees trees = new UniqueBinarySearchTrees();
        System.out.println(trees.numTrees(19));
    }
}
