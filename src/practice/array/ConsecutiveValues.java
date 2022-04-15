package practice.array;

import java.util.Arrays;

public class ConsecutiveValues {

    public int getMaximumConsecutive(int[] coins) {
        int res = 0;
        Arrays.sort(coins);
        for (int coin : coins) {
            if (res + 1 >= coin) res += coin;
        }
        return res + 1;
    }

    public static void main(String[] args) {
        int[] coins = {1, 3};
        ConsecutiveValues consecutiveValues = new ConsecutiveValues();
        System.out.println(consecutiveValues.getMaximumConsecutive(coins));
    }
}
