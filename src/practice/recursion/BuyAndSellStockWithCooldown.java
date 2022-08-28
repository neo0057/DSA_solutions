package practice.recursion;

import java.util.Arrays;

public class BuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return maxProfitRec(prices, 1, 0, dp);
    }

    private int maxProfitRec(int[] prices, int buy, int index, int[][] dp) {
        if (index >= prices.length) return 0;
        if (dp[index][buy] != -1) return dp[index][buy];
        if (buy == 1) {
            int buyNow = maxProfitRec(prices, 0, index + 1, dp) - prices[index];
            int doNotBuyNow = maxProfitRec(prices, 1, index + 1, dp);
            dp[index][buy] = Math.max(buyNow, doNotBuyNow);
            return Math.max(buyNow, doNotBuyNow);
        }
        // else
        int sellNow = maxProfitRec(prices, 1, index + 2, dp) + prices[index];
        int doNotSellNow = maxProfitRec(prices, 0, index + 1, dp);
        dp[index][buy] = Math.max(sellNow, doNotSellNow);
        return Math.max(sellNow, doNotSellNow);
    }

    public static void main(String[] args) {
        BuyAndSellStockWithCooldown buyAndSellStockWithCooldown = new BuyAndSellStockWithCooldown();
        System.out.println(buyAndSellStockWithCooldown.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
