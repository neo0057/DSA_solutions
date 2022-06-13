package practice.array;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) ans += prices[i] - prices[i - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock2 = new BestTimeToBuyAndSellStock2();
        System.out.println(bestTimeToBuyAndSellStock2.maxProfit(prices));
        System.out.println(bestTimeToBuyAndSellStock2.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(bestTimeToBuyAndSellStock2.maxProfit(new int[]{1, 2}));
    }
}
