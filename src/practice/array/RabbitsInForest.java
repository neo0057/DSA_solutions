package practice.array;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> answerMap = new HashMap<>();
        int res = 0;
        for (int ans : answers) {
            if (ans == 0) res++;
            else if (!answerMap.containsKey(ans)) {
                answerMap.put(ans, ans);
                res += ans + 1;
            } else {
                answerMap.put(ans, answerMap.get(ans) - 1);
                if (answerMap.get(ans) == 0) answerMap.remove(ans);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] answers = {1, 1, 2};
        int[] answers2 = {10, 10, 10};
        int[] answers3 = {1, 2, 4, 2, 2};
        RabbitsInForest rabbitsInForest = new RabbitsInForest();
        System.out.println(rabbitsInForest.numRabbits(answers));
        System.out.println(rabbitsInForest.numRabbits(answers2));
        System.out.println(rabbitsInForest.numRabbits(answers3));
    }
}
