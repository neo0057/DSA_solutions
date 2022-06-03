package practice.array;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) max = Math.max(max, piles[i]);
        int low = 1, high = max;
        while (low < high) {
            long hourTaken = 0;
            int k = (low + high) / 2;
            for (int pile : piles) hourTaken += (int) Math.ceil((double) pile / k);
            if (hourTaken > h) low = k + 1;
            else high = k;
        }
        return high;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int[] piles2 = {30, 11, 23, 4, 20};
        int[] piles3 = {332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        System.out.println(kokoEatingBananas.minEatingSpeed(piles, 8));
        System.out.println(kokoEatingBananas.minEatingSpeed(piles2, 5));
        System.out.println(kokoEatingBananas.minEatingSpeed(piles3, 823855818));
    }
}
