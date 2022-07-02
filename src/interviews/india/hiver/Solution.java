package interviews.india.hiver;

import java.util.*;
import java.util.stream.Collectors;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []




Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
*/
class Solution {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            else if(!stack.isEmpty()) {
                Character openCh = stack.pop();
                if(map.get(openCh) != ch) return false;
            } else return false;
        }
        return stack.isEmpty();
    }

    public static List<List<Integer>> solution(int[] candidates, int target) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        solutionRec(candidates, combination, result, 0, target, 0);
        return result;
    }

    public static void solutionRec(int[] candidates, List<Integer> combination, List<List<Integer>> result, int currSum, int target, int index) {
        if(currSum == target) {
            result.add(new ArrayList<>(combination).stream().sorted().collect(Collectors.toList()));
        }
        else if(currSum < target) {
            for(int i = index; i < candidates.length; i++) {
                if(currSum + candidates[i] <= target) {
                    combination.add(candidates[i]);
                    solutionRec(candidates, combination, result, currSum + candidates[i], target, i);
                    combination.remove(combination.get(combination.size() - 1));
                } else break;
            }
        }
    }
}

class Main {

    public static void main(String[] args) {
         int[] arr = {2,3,5};
         List<List<Integer>> result = Solution.solution(arr, 8);
         System.out.println("result: ");
         for(List<Integer> list : result) {
             System.out.print(list);
             System.out.println();
         }
//        String s = "()()";
//        System.out.println(Solution.isValid(s));
    }
}
