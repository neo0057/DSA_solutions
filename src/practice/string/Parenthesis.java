package practice.string;

public class Parenthesis {
    public void printBalanceParenthesis(int n) {
        char[] str = new char[n*2];
        generateBalanceParenthesisRec(str, 0, 0, 0, n);
    }

    private void generateBalanceParenthesisRec(char[] str, int index, int open, int close, int n) {
        if (close == n) System.out.println(str);
        else {
            if (open < n) {
                str[index] = '(';
                generateBalanceParenthesisRec(str, index + 1, open + 1, close, n);
            }
            if (close < n && close < open) {
                str[index] = ')';
                generateBalanceParenthesisRec(str, index + 1, open, close + 1, n);
            }
        }
    }

    public static void main(String[] args) {
        Parenthesis parenthesis = new Parenthesis();
        parenthesis.printBalanceParenthesis(5);
    }
}
