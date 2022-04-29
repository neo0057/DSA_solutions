package practice.array;

import java.util.Arrays;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize > 0) return false;
        int min = hand[0], max = hand[0];
        for (int num : hand) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        Arrays.sort(hand);
        if (max + min != n) return false;
        int start = hand[0];
        for (int i = 1; i < n; i++) {
            if (start + 1 != hand[i]) return false;
            start = hand[i];
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        HandOfStraights handOfStraights = new HandOfStraights();
        System.out.println(handOfStraights.isNStraightHand(hand, 3));
    }
}
