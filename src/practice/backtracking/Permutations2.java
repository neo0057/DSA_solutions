package practice.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] check = new boolean[nums.length];
        permuteRec(nums, check, res, curr);
        return new ArrayList<>(res);
    }

    private void permuteRec(int[] nums, boolean[] check, HashSet<List<Integer>> res, List<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (check[i]) continue;
            check[i] = true;
            curr.add(nums[i]);
            permuteRec(nums, check, res, curr);
            curr.remove(curr.size() - 1);
            check[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Permutations2 permutations = new Permutations2();
        List<List<Integer>> res = permutations.permuteUnique(arr);
        for (List<Integer> list : res) {
            for (Integer i : list) System.out.print(i + " ");
            System.out.println();
        }
    }
}
