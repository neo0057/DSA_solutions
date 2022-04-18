package practice.dp;

import java.util.Arrays;

public class SumOfSubArrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        long MOD = (long) (1e9 + 7);
        Arrays.sort(arr);
        int n = arr.length;
        long total = ((arr.length & 1) == 0) ? (long) (n / 2) * (n + 1) : (long) n * ((n + 1) / 2);
        int res = (int) (total / 2 + 1);
        total -= res;
        for (int i = 1; i < n; i++) {
            if (total > 1) res = (int) ((res + arr[i] * (total / 2) + ((total % 2 == 0) ? 0 : 1)) % MOD);
            else res = (int) ((res + arr[i]) % MOD);
            total -= total / 2;
        }
        return (int) ((int) res % MOD);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int[] arr2 = {11, 81, 94, 43, 3};
        SumOfSubArrayMinimums sumOfSubArrayMinimums = new SumOfSubArrayMinimums();
        System.out.println(sumOfSubArrayMinimums.sumSubarrayMins(arr));
        System.out.println(sumOfSubArrayMinimums.sumSubarrayMins(arr2));
    }
}
