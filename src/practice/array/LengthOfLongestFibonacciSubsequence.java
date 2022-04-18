package practice.array;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (int i = 0; i < n; i++) arrMap.put(arr[i], i);
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int n1 = arr[i];
            for (int j = i + 1; j < n; j++) {
                int n2 = arr[j];
                int count = 2;
                int sum = n1+n2;
                while (arrMap.containsKey(sum)) {
                    count++;
                    n1 = n2;
                    n2 = sum;
                    sum = n1 + n2;
                }
                res = Math.max(res, count);
            }
        }
        return res > 2 ? res : 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50};
        LengthOfLongestFibonacciSubsequence length = new LengthOfLongestFibonacciSubsequence();
        //System.out.println(length.lenLongestFibSubseq(arr));
        System.out.println(length.lenLongestFibSubseq(arr2));
    }
}
