package practice.array;

import java.util.*;

public class Sum4 {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        if (arr.length < 4) return new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        Map<String, Boolean> resMap = new HashMap<>();
        int start, end, sum;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                start = i + 1;
                end = j - 1;
                while (start < end) {
                    sum = arr[i] + arr[j] + arr[start] + arr[end];
                    if (sum == target) {
                        resultSet.add(Arrays.asList(arr[i], arr[j], arr[start], arr[end]));
                        start++;
                        end--;
                    } else if (sum > target) end--;
                    else start++;
                }
            }
        }
        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int[] arr2 = {2, 2, 2, 2, 2};
        Sum4 sum4 = new Sum4();
        System.out.println(sum4.fourSum(arr, 0));
        System.out.println(sum4.fourSum(arr2, 8));
    }
}
