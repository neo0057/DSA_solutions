package practice.backtracking;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        numTilePossibilitiesRec(tiles, "", set, visited);
        return set.size() - 1;
    }

    private void numTilePossibilitiesRec(String tiles, String combination, Set<String> set, boolean[] visited) {
        set.add(combination);
        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                numTilePossibilitiesRec(tiles, combination + tiles.charAt(i), set, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String s = "ABCD";
        LetterTilePossibilities possibilities = new LetterTilePossibilities();
        System.out.println(possibilities.numTilePossibilities(s));
    }
}
