package practice.dp;

public class OnesAndZeroes {
    private int[][][] dp;

    public int findMaxForm(String[] arr, int m, int n) {
        dp = new int[m + 1][n + 1][arr.length];
        return helper(arr, m, n, 0);
    }

    private int helper(String[] arr, int zeros, int ones, int index) {
        if (index == arr.length || zeros + ones == 0) return 0;
        if (dp[zeros][ones][index] > 0) return dp[zeros][ones][index];
        int[] count = count(arr[index]);
        int consider = 0;
        if (zeros >= count[0] && ones >= count[1]) consider = 1 + helper(arr, zeros - count[0], ones - count[1], index + 1);
        int skip = helper(arr, zeros, ones, index + 1);
        int max = Math.max(consider, skip);
        dp[zeros][ones][index] = max;
        return max;
    }

    private int[] count(String s) {
        int[] counts = new int[2];
        for (char c : s.toCharArray()) counts[c - '0']++;
        return counts;
    }

    public static void main(String[] args) {
        String[] arr = {"10", "0001", "111001", "1", "0"};
        OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
        System.out.println(onesAndZeroes.findMaxForm(arr, 5, 3));
    }
}
