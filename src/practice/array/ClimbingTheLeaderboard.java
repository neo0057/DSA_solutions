package practice.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClimbingTheLeaderboard {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> ranks = new ArrayList<>();
        int currRank = 1;
        int j = 0;
        for (int i = player.size() - 1; i >= 0; i--) {
            int playerRank = player.get(i);
            while (j < ranked.size() && playerRank < ranked.get(j)) {
                j++;
                currRank++;
            }
            if (j == ranked.size()) break;
            int currScore = ranked.get(j);
            ranks.add(currRank);
            while (j < ranked.size() && currScore == ranked.get(j)) j++;
            currRank++;
        }
        Collections.reverse(ranks);
        return ranks;
    }
}
