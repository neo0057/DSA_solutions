package interviews.india.byjus;

public class R1 {
    // Time limit exceeded
    public int numOfSubarrays(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = arr[0];
        for (int i = 1; i < len; i++) dp[i] = dp[i - 1] + arr[i];
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (dp[i] % 2 == 1) res++;
            for (int j = 0; j < i; j++) {
                if ((dp[i] - dp[j]) % 2 == 1) res++;
            }
        }
        return res;
    }
}
