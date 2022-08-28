package practice.data_structure;

import java.util.Stack;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else if (ch == '*') count++;
            else if (!stack.isEmpty()) stack.pop();
            else count--;
        }
        if (count == 0) return stack.isEmpty();
        return count >= stack.size();
    }

    public static void main(String[] args) {
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        System.out.println(validParenthesisString.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
}
