package practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        solutionRec(candidates, combination, result, 0, target, 0);
        return result;
    }

    private static void solutionRec(int[] candidates, List<Integer> combination, List<List<Integer>> result, int currSum, int target, int index) {
        if (currSum == target) {
//            if (!duplicateCombination(result, combination)) result.add(new ArrayList<>(combination).stream().sorted().collect(Collectors.toList()));
            result.add(new ArrayList<>(combination));
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && candidates[i - 1] == candidates[i] && index < i) continue;
            if (currSum + candidates[i] > target) break;
            combination.add(candidates[i]);
            solutionRec(candidates, combination, result, currSum + candidates[i], target, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    private static boolean duplicateCombination(List<List<Integer>> result, List<Integer> combination) {
        for (List<Integer> resultCombination : result) {
            if (resultCombination.size() != combination.size()) continue;
            int i = 0;
            while (i < resultCombination.size() && resultCombination.get(i).equals(combination.get(i))) i++;
            if (i == resultCombination.size()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = CombinationSum2.combinationSum2(arr, target);
        System.out.println("result: ");
        for (List<Integer> list : result) {
            System.out.print(list);
            System.out.println();
        }
    }
}
