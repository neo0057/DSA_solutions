package practice.string;

import java.util.Arrays;
import java.util.Comparator;

public class RearrangeWordsInASentence {
    public String arrangeWords(String text) {
        String[] arr = text.split(" ");
        Comparator<String> comparator = (s1, s2) -> {
            if (s1.length() != s2.length()) return s1.length() - s2.length();
            return 0;
        };
        Arrays.sort(arr, comparator);
        text = String.join(" ", arr).toLowerCase();
        char[] chars = text.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);
    }

    public static void main(String[] args) {
        String text = "To be or not to be";
        String text2 = "Keep calm and code on";
        RearrangeWordsInASentence rearrangeWordsInASentence = new RearrangeWordsInASentence();
        System.out.println(rearrangeWordsInASentence.arrangeWords(text));
        System.out.println(rearrangeWordsInASentence.arrangeWords(text2));
    }
}
