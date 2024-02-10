package practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] arr1, int[] arr2, int k) {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0, j = 0, id = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) arr[id++] = arr1[i++];
            else arr[id++] = arr2[j++];
        }
        while (i < arr1.length) arr[id++] = arr1[i++];
        while (j < arr2.length) arr[id++] = arr2[j++];
        List<List<Integer>> res = new ArrayList<>();
        for (i = 0; i < arr1.length + arr2.length - 1; i++) {
            for (j = i + 1; j < arr1.length + arr2.length; j++) {
                if (k == 0) break;
                res.add(Arrays.asList(arr[i], arr[j]));
                k--;
            }
            if (k == 0) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11}, nums2 = {2, 4, 6};
        int k = 3;
        FindKPairsWithSmallestSums kPairsWithSmallestSums = new FindKPairsWithSmallestSums();
        System.out.println(kPairsWithSmallestSums.kSmallestPairs(nums1, nums2, k));
        System.out.println(kPairsWithSmallestSums.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
    }
}
