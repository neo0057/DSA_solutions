package practice.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LetterTilePossibilities {
    int res;
    public int numTilePossibilities(String tiles) {
        List<Character> characterList = new ArrayList<>();
        List<Character> remainingCharacterList = new ArrayList<>();
        for (int i = 0; i < tiles.length(); i++) {
            characterList.add(tiles.charAt(i));
            remainingCharacterList.add(tiles.charAt(i));
        }
        res = 0;
        numTilePossibilitiesRec(characterList, 0, tiles.length(), "");
        return res;
    }

    private void numTilePossibilitiesRec(List<Character> characterList, int id, int length, String comb) {
        if (id == length) {
            System.out.println(comb);
            res++;
        }
        else {
            for (int i = id; i < length; i++) {
                comb += characterList.get(i);
                //remainingCharacterList.remove(i);
                numTilePossibilitiesRec(characterList, i + 1, length, comb);
                comb = comb.substring(0, comb.length() - 1);
//                remainingCharacterList.add(characterList.get(characterList.size() - 1));
            }
        }
    }

    public static void main(String[] args) {
        String s = "AAB";
        LetterTilePossibilities possibilities = new LetterTilePossibilities();
        System.out.println(possibilities.numTilePossibilities(s));
    }
}
