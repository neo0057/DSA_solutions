package practice.array;

public class SuperUglyNumber {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] index = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * dp[index[j]]);
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (min == primes[j] * dp[index[j]]) index[j]++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        System.out.println("nth super ugly number: " + nthSuperUglyNumber(n, primes));
    }
}
