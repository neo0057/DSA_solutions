package practice.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumEarningsFromTaxi {
    public long maxTaxiEarnings(int n, int[][] rides) {
        if (rides.length == 1) return calculateEarnings(rides[0]);

        // 2. Form a map of each ride, with destination as key, and rides as values
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] ride : rides) map.compute(ride[1], (k, v) -> (v == null) ? new ArrayList<>() : v).add(ride);

        // 3. Now the intuition here is:
        // We look at each number 'n' and see if is a destination for any passenger
        // If it is so, we find the highest valued ride at that point,
        // and add any earnings from any previous destinations
        long[] dp = new long[n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1];
            if (!map.containsKey(i)) continue;
            for (int[] passenger : map.get(i)) {
//                int earning = calculateEarnings(passenger);
                // 3c. Maximise the earnings,
                // if current is higher, cool
                // else check the combination of rides from their starting point and their earn rate
                dp[i] = Math.max(dp[i], dp[passenger[0]] + calculateEarnings(passenger));
            }
        }
        return dp[n];
    }

    protected int calculateEarnings(final int[] currentRide) {
        return currentRide[1] - currentRide[0] + currentRide[2];
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] rides = {{2, 5, 4}, {1, 5, 1}};
        int n2 = 20;
        int[][] rides2 = {{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}};
        MaximumEarningsFromTaxi maximumEarningsFromTaxi = new MaximumEarningsFromTaxi();
        System.out.println(maximumEarningsFromTaxi.maxTaxiEarnings(n, rides));
        System.out.println(maximumEarningsFromTaxi.maxTaxiEarnings(n2, rides2));
    }
}
