package assignments.apr29.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class COMPARA_main {
    static class RandomArray implements Comparable<RandomArray> {

        public int[] rArray;

        public int[] getrArray() {
            return rArray;
        }

        public void setrArray(int[] rArray) {
            this.rArray = rArray;
        }

        public RandomArray(int arrayLength, int maxValue) {
            this.rArray = new int[arrayLength];
            Map<Integer, Boolean> visited = new HashMap<>();
            Random random = new Random();
            int randomNumber;
            int id = 0;
            while (id < arrayLength) {
                randomNumber = random.nextInt(2, maxValue + 1);
                if (randomNumber % 2 == 0 && !visited.containsKey(randomNumber)) {
                    this.rArray[id++] = randomNumber;
                    visited.put(randomNumber, true);
                }
            }
        }

        @Override
        public int compareTo(RandomArray randomArray) {
            if (this.getrArray().length <= 3 && randomArray.getrArray().length <= 3) {
                return 0;
            }
            if (this.getrArray().length > randomArray.getrArray().length && randomArray.getrArray().length >= 3) {
                return 1;
            }
            if (this.rArray.length == randomArray.rArray.length && randomArray.rArray.length >= 3) {
                int aMin = Integer.MAX_VALUE, aMax = Integer.MIN_VALUE, bMin = Integer.MAX_VALUE, bMax = Integer.MIN_VALUE;
                for (int num : this.getrArray()) {
                    aMin = Math.min(aMin, num);
                    aMax = Math.max(aMax, num);
                }
                for (int num : randomArray.getrArray()) {
                    bMin = Math.min(bMin, num);
                    bMax = Math.max(bMax, num);
                }
                int aSum = aMin + aMax;
                int bSum = bMin + bMax;
                System.out.println(aSum);
                System.out.println(bSum);
                // condition 2 of a equal to b
                if (aSum == bSum) return 0;
                // condition 2 of a greater than b
                if (aSum > bSum) return 1;
                // other case where a less than b
                return -1;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        RandomArray randomArray = new RandomArray(3, 300);
        RandomArray randomArray1 = new RandomArray(4, 10);
        System.out.println(randomArray.compareTo(randomArray1));
    }
}
