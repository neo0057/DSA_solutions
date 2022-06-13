package practice.array;

import java.util.Arrays;

public class ClosestSum3 {
    public int threeSumClosest(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int res = 0, sum, diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1, end = n - 1;
            while (start < end) {
                sum = arr[i] + arr[start] + arr[end];
                int currDiff = Math.abs(sum - target);
                if (currDiff < diff) {
                    res = sum;
                    diff = currDiff;
                }
                if (diff == 0) return res;
                if (sum < target) start++;
                if (sum > target) end--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};
        ClosestSum3 closestSum3 = new ClosestSum3();
        System.out.println(closestSum3.threeSumClosest(arr, 1));
    }
}
