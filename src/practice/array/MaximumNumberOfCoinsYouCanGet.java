package practice.array;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int id = piles.length - 2;
        int count = piles.length;
        int res = 0;
        while (count >= 3) {
            res += piles[id];
            id -= 2;
            count -= 3;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] piles = {2, 4, 1, 2, 7, 8};
        int[] piles2 = {9, 8, 7, 6, 5, 1, 2, 3, 4};
        MaximumNumberOfCoinsYouCanGet numberOfCoinsYouCanGet = new MaximumNumberOfCoinsYouCanGet();
        System.out.println(numberOfCoinsYouCanGet.maxCoins(piles));
        System.out.println(numberOfCoinsYouCanGet.maxCoins(piles2));
    }
}
