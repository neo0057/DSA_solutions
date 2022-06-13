package practice.array;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = n;
        for (int i = 1; i < n; i++) {
            // centre case:
            int j = i - 1, k = i + 1;
            while (j >= 0 && k < n && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
                res++;
            }
            // left case
            j = i - 1;
            k = i;
            while (j >= 0 && k < n && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        System.out.println(palindromicSubstrings.countSubstrings("abc"));
        System.out.println(palindromicSubstrings.countSubstrings("aaa"));
        System.out.println(palindromicSubstrings.countSubstrings("aa"));
    }
}
