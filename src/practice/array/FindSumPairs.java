package practice.array;

import java.util.*;

public class FindSumPairs {
    int[] arr2;
    Map<Integer, Integer> arr1Map;
    Map<Integer, Integer> arr2Map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        arr2 = Arrays.copyOf(nums2, nums2.length);
        arr1Map = new HashMap<>();
        arr2Map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) arr1Map.put(nums1[i], arr1Map.getOrDefault(nums1[i], 0) + 1);
        for (int i = 0; i < nums2.length; i++) arr2Map.put(nums2[i], arr2Map.getOrDefault(nums2[i], 0) + 1);
    }

    public void add(int index, int val) {
        arr2Map.put(arr2[index], arr2Map.get(arr2[index]) - 1);
        arr2[index] += val;
        arr2Map.put(arr2[index], arr2Map.getOrDefault(arr2[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int key : arr1Map.keySet()) {
            int diff = tot - key;
            count += arr1Map.get(key)*arr2Map.getOrDefault(diff, 0);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 2, 3};
        int[] arr2 = {1, 4, 5, 2, 5, 4};
        FindSumPairs findSumPairs = new FindSumPairs(arr1, arr2);
        System.out.println(findSumPairs.count(7));
        findSumPairs.add(3, 2);
        System.out.println(findSumPairs.count(8));
        System.out.println(findSumPairs.count(4));
        findSumPairs.add(0, 1); // now nums2 = [2,4,5,4,5,4]
        findSumPairs.add(1, 1);
        System.out.println(findSumPairs.count(7));
    }
}
