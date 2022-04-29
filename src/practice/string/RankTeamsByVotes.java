package practice.string;

import java.util.*;

public class RankTeamsByVotes {
    static class TeamRank implements Comparable<TeamRank> {
        Character teamName;
        int[] ranks;

        public TeamRank(Character teamName) {
            this.teamName = teamName;
            this.ranks = new int[27];
        }

        @Override
        public int compareTo(TeamRank teamRank) {
            int i = 1;
            while (i < 27 && this.ranks[i] == teamRank.ranks[i]) i++;
            if (i == 27) return this.teamName.compareTo(teamRank.teamName);
            int diff = this.ranks[i] - teamRank.ranks[i];
            if (diff > 0) return 0;
            return 1;
        }
    }

    public String rankTeams(String[] votes) {
        Map<Character, TeamRank> rankMap = new HashMap<>();
        for (String vote : votes) {
            int rank = 1;
            for (Character teamName : vote.toCharArray()) {
                TeamRank teamRank = (rankMap.containsKey(teamName)) ? rankMap.get(teamName) : new TeamRank(teamName);
                teamRank.ranks[rank]++;
                rankMap.put(teamName, teamRank);
                rank++;
            }
        }
        List<TeamRank> teamRankList = new ArrayList<>(rankMap.values());
        Collections.sort(teamRankList);
        StringBuilder ranks = new StringBuilder();
        for (TeamRank teamRank : teamRankList) ranks.append(teamRank.teamName);
        return ranks.toString();
    }

    public static void main(String[] args) {
        String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        String[] votes2 = {"WXYZ", "XYZW"};
        String[] votes3 = {"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"};
        RankTeamsByVotes rankTeamsByVotes = new RankTeamsByVotes();
        System.out.println(rankTeamsByVotes.rankTeams(votes));
        System.out.println(rankTeamsByVotes.rankTeams(votes2));
        System.out.println(rankTeamsByVotes.rankTeams(votes3));
    }
}
