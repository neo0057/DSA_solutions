package practice.array;

// https://www.hackerrank.com/challenges/encryption/problem?isFullScreen=true
public class Encryption {
    public static String encryption(String s) {
        s = s.replaceAll(" ", "");
        int l = s.length();
        double sqrt = Math.sqrt(l);
        int mn = (int) Math.floor(sqrt);
        int mx = (int) Math.ceil(sqrt);
        int maxArea = mx * mx;
        int row = mx, col = mx;
        for (int i = mn; i <= mx; i++) {
            for (int j = mn; j <= mx; j++) {
                if (i * j < l) continue;
                if (i * j < maxArea) {
                    maxArea = i * j;
                    row = i;
                    col = j;
                }
            }
        }
        char[][] dp = new char[row][col];
        int i = 0;
        while (i < l) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (i == l) break;
                    dp[j][k] = s.charAt(i);
                    i++;
                }
                if (i == l) break;
            }
        }
        StringBuilder res = new StringBuilder();
        int c = l;
        for (int j = 0; j < col; j++) {
            for (int k = 0; k < row; k++) {
                if (c == 0) break;
                res.append(dp[k][j]);
                c--;
            }
            if (c == 0) break;
            res.append(" ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(encryption("feedthedog"));
    }
}
