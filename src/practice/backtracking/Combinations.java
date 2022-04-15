package practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();
        combineRec(res, n, k, 1, combo);
        return res;
    }

    private void combineRec(List<List<Integer>> res, int n, int k, int num, List<Integer> combo) {
        if (combo.size() == k) {
            res.add(new ArrayList<>(combo));
            return;
        }
        for (int i = num; i <= n; i++) {
            combo.add(i);
            combineRec(res, n, k, i + 1, combo);
            combo.remove(combo.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> res = combinations.combine(1, 1);
        for (List<Integer> list : res) {
            for (Integer i : list) System.out.print(i + " ");
            System.out.println();
        }
    }
}
