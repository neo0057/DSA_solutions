package practice.array;

public class FirstMissingPositiveNumber {
    public int firstMissing(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int num : arr) {
            if (num > n || num < 0) continue;
            dp[num] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (dp[i] == 0) return i;
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 1};
        int[] arr2 = {2, -9, 5, 11, 1, -10, 7};
        FirstMissingPositiveNumber firstMissingPositiveNumber = new FirstMissingPositiveNumber();
        System.out.println(firstMissingPositiveNumber.firstMissing(arr));
        System.out.println(firstMissingPositiveNumber.firstMissing(arr2));
    }
}
