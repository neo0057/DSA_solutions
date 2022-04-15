package interviews.OlaElectric;

import java.util.HashMap;
import java.util.Map;

// Interviewer: Bhargav Khamar
public class R1 {
    /*
    1. we have a grid of n rows and m cols.
Initially all cells in the grid is empty except 1 cell

t=0
0 0 0 0
2 1 0 0
3 0 0 0
4 5 0 0

In every unit of time each bacteria will grow in 4 directions. Up left bottom right
In each cell max there can be one bacteria

Find the min time when grid will be filled

2. we have string of 1-9 digits

8982342343249332344234324

maximum value palindrome which can be created


78988899

98989

7 -> 1
8 -> 4, 2,0
9 -> 3 , 1


a=988
b=889

res = a + hightest + b;
     */

    public String longestPalindromeFormation(String num) {
        int[] f = new int[10];
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            f[n]++;
        }
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (f[i] > 1) {
                a.append(Character.forDigit(i, 10));
                b.insert(0, Character.forDigit(i, 10));
                f[i] -= 2;
            }
        }
        for (int i = 9; i >= 0; i--) if (f[i] > 0) return a.toString() + Character.forDigit(i, 10) + b;
        return a + b.toString();
    }

    public static void main(String[] args) {
        String s = "78988897000";
        R1 r1 = new R1();
        System.out.println(r1.longestPalindromeFormation(s));
    }
}
