package practice;

public class R2 {

    public int evaluate(String exp) {
        int res = 0;
        String num1 = "", num2 = "";
        char op = 0;
        num1 += exp.charAt(0);
        for (int i = 1; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (isOperator(ch) && num1.length() > 0 && num2.length() > 0) {
                res += evaluateExp(num1, op, num2);
                num1 = String.valueOf(res);
                op = '\0';
                num2 = "";
            }
            else if (isOperator(ch)) op = ch;
            else if (op == '\0') num1 += ch;
            else num2 += ch;
        }
        return res + evaluateExp(num1, op, num2);
    }
    private int evaluateExp(String num1, char op, String num2) {
    	int n1 = Integer.parseInt(num1);
      int n2 = Integer.parseInt(num2);
      if (op == '+') return n1 + n2;
      if (op == '-') return n1 - n2;
      if (op == '*') return n1 * n2;
      if (op == '/') return n1 / n2;
      return 0; // default
    }

    private boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') return true;
        return false;
    }

    public static void main(String[] args) {
        String exp = "1+5-1*3";
        R2 r2 = new R2();
        System.out.println("exp value: " + r2.evaluate(exp));
    }

}
/*
columns -> id, firstName, lastname, reportingManager, department

Option 1:
  employee -> id, firstName, lastname, reportingManagerId, department_id
  departments -> id, name

		hierarchy query -> this will provide employee hierarchy

  		WITH RECURSIVE emp_data AS (SELECT id, firstName, lastName, department_id AS level FROM employee where id = search_emp_id)
        UNION ALL
          (this.id, this.firstName, this.lastName, this.reportingManagerId, emp_data_temp_level + 1
          FROM emp_data emp_data_temp_level INNER JOIN employee this ON this.reportingManagerId = emp_data_temp_level.id
          )
          SELECT e.id, e.firstName, e.lastName, e.reportingManagerId, e.level FROM emp_data e ORDER BY e.level;


 */