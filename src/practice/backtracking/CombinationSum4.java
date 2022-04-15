package practice.backtracking;

import java.util.*;

public class CombinationSum4 {
    int res;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> combination = new ArrayList<>();
        res = 0;
        solutionRec(nums, combination, 0, target, 0);
        return res;
    }

    private void solutionRec(int[] candidates, List<Integer> combination, int currSum, int target, int index) {
        if (currSum == target) {
            res += getUniquePermutationsCount(combination);
            for (Integer e : combination) System.out.print(e + " ");
            System.out.println();
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (currSum + candidates[i] > target) break;
            currSum += candidates[i];
            combination.add(candidates[i]);
            solutionRec(candidates, combination, currSum, target, i);
            currSum -= combination.get(combination.size() - 1);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        CombinationSum4 combinationSum4 = new CombinationSum4();
        System.out.println(combinationSum4.combinationSum4(arr, 4));
    }

    private int getUniquePermutationsCount(List<Integer> arr) {
        int n = arr.size();
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
        int[] prod = new int[n + 1];
        for (int i = 2; i <= n; i++) prod[i] = i;
        for (int i = n - 1; i >= 0; i--) sortedMap.put(arr.get(i), sortedMap.getOrDefault(arr.get(i), 0) + 1);
        Set<Integer> keySet = sortedMap.keySet();
        List list = new ArrayList(keySet);
        Collections.sort(list, Collections.reverseOrder());
        Set<Integer> sortedSet = new LinkedHashSet(list);
        for (Integer key : sortedSet) {
            if (prod[key] == 0) {
                for (int i = n; i >= 2; i--) {
                    if (i % key == 0) {
                        prod[i] = i / key;
                        break;
                    }
                }
            } else {
                for (int j = key; j >= 2; j--) prod[j] = 1;
            }
        }
        int res = 1;
        for (int i = n; i >= 2; i--) res *= prod[i];
        return res;
    }
}
