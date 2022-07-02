package practice.string;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for (char ch : s.toCharArray()) if (Character.isLetterOrDigit(ch)) str.append(ch);
        s = str.toString().toLowerCase();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) if (chars[i] != chars[chars.length - i - 1]) return false;
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
