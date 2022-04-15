package practice.dp;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        Map<Integer, Integer> daysMap = new HashMap<>();
        for (int i = 0; i < days.length; i++) daysMap.put(days[i], i);
        int[] dp = new int[367];
        for (int day = 365; day >= 1; day--) {
            if (!daysMap.containsKey(day)) {
                dp[day] = dp[day + 1];
                continue;
            }
            dp[day] = costs[0] + dp[day + 1];
            dp[day] = Math.min(dp[day], costs[1] + dp[Math.min(day + 7, 366)]);
            dp[day] = Math.min(dp[day], costs[2] + dp[Math.min(day + 30, 366)]);
        }
        return dp[1];
    }

    public static void main(String[] args) {
        MinimumCostForTickets minimumCostForTickets = new MinimumCostForTickets();

        int[] days = {1, 4, 6, 7, 8, 20}, costs = {2, 7, 15};
        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, costs2 = {2, 7, 15};

        System.out.println(minimumCostForTickets.mincostTickets(days, costs));
        System.out.println(minimumCostForTickets.mincostTickets(days2, costs2));
    }
}
