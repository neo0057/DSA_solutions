package practice.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        solutionRec(new ArrayList<>(), result, 0, k, n, 1);
        return result;
    }

    private static void solutionRec(List<Integer> combination, List<List<Integer>> result, int currSum, int setSize, int target, int currNumber) {
        if (currSum == target && combination.size() == setSize) {
            result.add(new ArrayList<>(combination).stream().sorted().collect(Collectors.toList()));
        }
        for (int i = currNumber; i <= 9; i++) {
            if (currSum + i > target) break;
            combination.add(i);
            solutionRec(combination, result, currSum + i, setSize, target, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k,n;
        k = 3;
        n = 9;
        System.out.println(combinationSum3(k, n));
    }
}
