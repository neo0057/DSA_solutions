package practice.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationIterator {
    String chars;
    int len;
    int id;
    List<String> combinations;

    public CombinationIterator(String characters, int combinationLength) {
        char[] sortedChars = characters.toCharArray();
        Arrays.sort(sortedChars);
        chars = new String(sortedChars);
        len = combinationLength;
        id = 0;
        combinations = new ArrayList<>();
        List<Character> currCombo = new ArrayList<>();
        generateLexicographicallySortedSequenceRec(chars, currCombo, 0);
    }

    private void generateLexicographicallySortedSequenceRec(String chars, List<Character> currCombo, int id) {
        if (currCombo.size() == len) {
            StringBuilder combo = new StringBuilder();
            for (int i = 0; i < len; i++) combo.append(currCombo.get(i));
            combinations.add(combo.toString());
            return;
        }
        for (int i = id; i < chars.length(); i++) {
            currCombo.add(chars.charAt(i));
            generateLexicographicallySortedSequenceRec(chars, currCombo, i + 1);
            currCombo.remove(currCombo.size() - 1);
        }
    }

    public String next() {
        return combinations.get(id++);
    }

    public boolean hasNext() {
        return (id < combinations.size());
    }

    public static void main(String[] args) {
        CombinationIterator itr = new CombinationIterator("abc", 2);
        System.out.println(itr.next());
        ;    // return "ab"
        System.out.println(itr.hasNext()); // return True
        System.out.println(itr.next());    // return "ac"
        System.out.println(itr.hasNext()); // return True
        System.out.println(itr.next());    // return "bc"
        System.out.println(itr.hasNext()); // return False
    }
}
