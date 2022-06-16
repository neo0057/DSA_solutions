package practice.bitwise;

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length - 1; i++) {
            int mask1 = 0;
            for (char ch : words[i].toCharArray()) mask1 |= (1L << (ch - 'a'));
            for (int j = i + 1; j < words.length; j++) {
                int mask2 = 0;
                for (char ch : words[j].toCharArray()) mask2 |= (1L << (ch - 'a'));
                if ((mask1 & mask2) == 0) res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        MaximumProductOfWordLengths maximumProductOfWordLengths = new MaximumProductOfWordLengths();
        System.out.println(maximumProductOfWordLengths.maxProduct(words));
    }
}
