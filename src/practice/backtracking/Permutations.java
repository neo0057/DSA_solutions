package practice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) arr.add(nums[i]);
        permuteRec(arr, 0, res);
        return res;
    }

    private void permuteRec(List<Integer> nums, int index, List<List<Integer>> res) {
        if (index == nums.size()) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            Collections.swap(nums, i, index);
            permuteRec(nums, index + 1, res);
            Collections.swap(nums, index, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Permutations permutations = new Permutations();
        List<List<Integer>> res = permutations.permute(arr);
        for (List<Integer> list : res) {
            for (Integer i : list) System.out.print(i + " ");
            System.out.println();
        }
    }
}
