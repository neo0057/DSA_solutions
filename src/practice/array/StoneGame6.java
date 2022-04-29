package practice.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StoneGame6 {
    static class StonePair {
        public int sum, a, b;

        public StonePair(int a, int b) {
            this.sum = a + b;
            this.a = a;
            this.b = b;
        }
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        Comparator<StonePair> stonePairComparator = (p1, p2) -> p2.sum - p1.sum;
        PriorityQueue<StonePair> queue = new PriorityQueue<>(stonePairComparator);
        for (int i = 0; i < aliceValues.length; i++) queue.offer(new StonePair(aliceValues[i], bobValues[i]));
        boolean turn = true;
        int aliceStones = 0, bobStones = 0;
        while (!queue.isEmpty()) {
            if (turn) aliceStones += queue.poll().a;
            else bobStones += queue.poll().b;
            turn = !turn;
        }
        return Integer.compare(aliceStones, bobStones);
    }

    public static void main(String[] args) {
        int[] aliceValues = {1, 3}, bobValues = {2, 1};
        StoneGame6 stoneGame6 = new StoneGame6();
        System.out.println(stoneGame6.stoneGameVI(aliceValues, bobValues));
    }
}
