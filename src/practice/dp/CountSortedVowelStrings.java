package practice.dp;

public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 5;
        if (n <= 1) return dp[n];
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] * (dp[i - 1] + 1)) / 2;
            System.out.println(dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        CountSortedVowelStrings countSortedVowelStrings = new CountSortedVowelStrings();
        System.out.println(countSortedVowelStrings.countVowelStrings(2));
        System.out.println(countSortedVowelStrings.countVowelStrings(33));
    }
}
