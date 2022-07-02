package practice.string;

import java.util.Stack;

public class BasicCalculator2 {
    public int calculate(String s) {
        s = s.strip();
        Stack<String> stack = new Stack<>();
        int i = 0;
        Character op = null;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') i++;
            String str = "";
            while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == ' ')) {
                if (s.charAt(i) != ' ') str = str.concat(s.charAt(i) + "");
                i++;
            }
            if (op != null && isHighOperator(op)) {
                stack.pop();
                Integer num1 = Integer.parseInt(stack.pop());
                Integer num2 = Integer.parseInt(str);
                Integer val = (op == '*') ? num1 * num2 : num1 / num2;
                stack.add(String.valueOf(val));
            } else stack.add(str);
            if (i < s.length() && (isLowOperator(s.charAt(i)) || isHighOperator(s.charAt(i)))) {
                stack.add(s.charAt(i) + "");
                op = s.charAt(i);
            }
            i++;
        }
        if (stack.size() == 1) return Integer.parseInt(stack.pop());
        while (stack.size() > 1) {
            Integer num2 = Integer.parseInt(stack.pop());
            String op1 = stack.pop();
            int num1 = Integer.parseInt(stack.pop());
            if (!stack.isEmpty() && stack.peek().equals("-")) {
                num1 = -num1;
                stack.pop();
                stack.add("+");
            }
            System.out.println(num1 + " " + op1 + " " + num2);
            int res = evaluate(num1, op1, num2);
            stack.add(String.valueOf(res));
        }
        return Integer.parseInt(stack.pop());
    }

    private int evaluate(Integer num1, String op, Integer num2) {
        if (op.equals("+")) return num1 + num2;
        return num1 - num2;
    }

    private boolean isLowOperator(Character ch) {
        return ch == '+' || ch == '-';
    }

    private boolean isHighOperator(Character ch) {
        return ch == '/' || ch == '*';
    }

    public static void main(String[] args) {
        String s = "1+1-1";
        BasicCalculator2 basicCalculator2 = new BasicCalculator2();
        System.out.println(basicCalculator2.calculate(s));
    }
}
