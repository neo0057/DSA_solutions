package practice.string;

public class HighestValuePalindrome {
    public static String highestValuePalindrome(String s, int n, int k) {
        if (k == 0) return isPalindrome(s) ? s : "-1";
        String copy = new String(s);
        char[] sArr = s.toCharArray();
        int len = s.length();
        int l = 0, r = len - 1;
        while (l <= r && k > 1) {
            int leftVal = sArr[l] - 'a';
            int rightVal = sArr[r] - 'a';
            if (leftVal == rightVal && leftVal == 9) continue;
            if (leftVal == 9) {
                sArr[r] = '9';
                k--;
            } else if (rightVal == 9) {
                sArr[l] = '9';
                k--;
            } else {
                sArr[l] = '9';
                sArr[r] = '9';
                k -= 2;
            }
            l++;
            r--;
        }
        if (k > 0) {
            if (len % 2 == 1) sArr[len / 2] = '9';
            else {
                int m = len / 2;
                int leftVal = sArr[m - 1] - 'a';
                int rightVal = sArr[m] - 'a';
                if (leftVal != rightVal) {

                }
            }
        }
        return copy;// change this with answer
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}
