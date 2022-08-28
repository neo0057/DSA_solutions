package practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        if (expression.length() == 1 || expression.length() == 2) {
            result.add(Integer.parseInt(expression));
            return result;
        }
        for (int i = 0; i < expression.length(); i++) {
            char currOperator = expression.charAt(i);
            if (currOperator == '+' || currOperator == '-' || currOperator == '*') {
                List<Integer> leftResult = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightResult = diffWaysToCompute(expression.substring(i + 1));
                // compute all possible results from left and right sub-results
                for (Integer leftValue : leftResult) {
                    for (Integer rightValue : rightResult) {
                        switch (currOperator) {
                            case '*' -> result.add(leftValue * rightValue);
                            case '+' -> result.add(leftValue + rightValue);
                            case '-' -> result.add(leftValue - rightValue);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses waysToAddParentheses = new DifferentWaysToAddParentheses();
        System.out.println(waysToAddParentheses.diffWaysToCompute("2*3-4*5"));
    }
}
