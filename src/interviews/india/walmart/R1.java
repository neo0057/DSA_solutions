package interviews.india.walmart;

import java.util.Stack;

public class R1 {
    /*
    expression  = 1+2+3-6+5
    expression  = 1+2*3-6*5 = 1+6-30 = -23
    exp = -2*-4;
    +, -, single digits
     */

    public static int evaluate(String expression) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            stack.push(expression.charAt(i) + "");
        }
        int res = 0;
        while (!stack.isEmpty()) {
            String num2 = stack.pop();
            String op = stack.pop();
            String num1 = stack.pop();
            if (!stack.isEmpty()) {
                String op2 = stack.pop();
                if (op2.equals("-")) {
                    num1 = "-" + num1;
                    if (!stack.isEmpty()) stack.push("+");
                } else stack.push(op2);
            }
            res = calculate(num1, op, num2);
            if (!stack.empty()) stack.push(String.valueOf(res));
        }
        return res;
    }

    public static int evaluate2(String expression) {
        String[] arr = expression.split("\\*/");
        for (int i = 0; i < arr.length - 1; i++) {
            int l = arr[i].length();
            String num1 = (l > 1 && arr[i].charAt(l - 2) == '-') ? arr[i].charAt(l - 2) + "" + arr[i].charAt(l - 1) + "" : arr[i].charAt(l - 1) + "";
            String num2 = (arr[i + 1].charAt(0) == '-') ? arr[i + 1].charAt(0) + arr[i + 1].charAt(1) + "" : arr[i + 1].charAt(0) + "";
            int res = Integer.parseInt(num1) * Integer.parseInt(num2);
            boolean isNegative = (l > 1 && arr[i].charAt(l - 2) == '-');
            String n1 = arr[i].substring(0, (isNegative) ? l - 2 : l - 1);
            if (res < 0) arr[i] = n1 + String.valueOf(res);
            else arr[i] = n1 + "+" + String.valueOf(res);
            isNegative = (arr[i + 1].charAt(0) == '-');
            arr[i + 1] = arr[i + 1].substring((isNegative) ? 2 : 1);
        }
        String finalExpression = "";
        for (int i = 0; i < arr.length; i++) finalExpression += arr[i];
        return evaluate(finalExpression);
    }

    private static int calculate(String num1, String op, String num2) {
        if (op.equals("+")) return Integer.parseInt(num1) + Integer.parseInt(num2);
        return Integer.parseInt(num1) - Integer.parseInt(num2);
    }

    public static void main(String[] args) {
        String exp = "1+2+3-6+5"; // 5
        String exp2 = "-1+2-3";
        String exp3 = "1-2*3+4*2";
        System.out.println(evaluate2(exp3));

        /*
        exp = 1-2*3+4*2
        [] = [1-2, 3+4, 2]
        1 + -6 + 6

         */
    }
}
