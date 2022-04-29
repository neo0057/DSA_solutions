package practice.array;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int mod = (int) (1e9 + 7);

        for (int val : deliciousness) {
            int power = 1;
            for (int i = 0; i < 22; i++) {
                if (map.containsKey(power - val)) {
                    res += map.get(power - val);
                    res %= mod;
                }
                power *= 2;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] deliciousness = {1, 3, 5, 7, 9};
        int[] deliciousness2 = {1, 1, 1, 3, 3, 3, 7};
        CountGoodMeals countGoodMeals = new CountGoodMeals();
        System.out.println(countGoodMeals.countPairs(deliciousness));
        System.out.println(countGoodMeals.countPairs(deliciousness2));
    }
}
