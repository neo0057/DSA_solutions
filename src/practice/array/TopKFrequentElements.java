package practice.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        int index = 0;
        int[][] freqArr = new int[n][2];
        for (Integer key : freqMap.keySet()) {
            freqArr[index][0] = key;
            freqArr[index][1] = freqMap.get(key);
            index++;
        }
        Comparator<int[]> comparator = Comparator.comparingInt(a1 -> a1[1]);
        Arrays.sort(freqArr, comparator);
        int[] res = new int[k];
        int id = 0;
        for (int i = n - 1; i > n - k - 1; i--) {
            res[id++] = freqArr[i][0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, k)));
    }
}
