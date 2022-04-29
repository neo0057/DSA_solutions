package practice.array;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winMap = new HashMap<>();
        Map<Integer, Integer> loosMap = new HashMap<>();
        SortedSet<Integer> teams = new TreeSet<>();
        for (int[] match : matches) {
            teams.add(match[0]);
            teams.add(match[1]);
            winMap.put(match[0], winMap.getOrDefault(match[0], 0) + 1);
            loosMap.put(match[1], loosMap.getOrDefault(match[1], 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> allWins = new ArrayList<>();
        List<Integer> oneMatchLosses = new ArrayList<>();
        for (Integer team : teams) {
            if (!loosMap.containsKey(team)) allWins.add(team);
            else if (loosMap.get(team) == 1) oneMatchLosses.add(team);
        }
        Collections.sort(allWins);
        Collections.sort(oneMatchLosses);
        res.add(allWins);
        res.add(oneMatchLosses);
        return res;
    }

    public static void main(String[] args) {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        FindPlayersWithZeroOrOneLosses playersWithZeroOrOneLosses = new FindPlayersWithZeroOrOneLosses();
        System.out.println(playersWithZeroOrOneLosses.findWinners(matches));
    }
}
