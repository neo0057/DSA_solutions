package practice.array;

import java.util.HashMap;
import java.util.Map;

public class ReduceArraySizeHalf {
    public int minSetSize(int[] arr) {
        int[] freqArr = new int[arr.length + 1];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) freq.put(num, freq.getOrDefault(num, 0) + 1);
        for (Integer key : freq.keySet()) freqArr[freq.get(key)]++;
        int res = 0;
        int count = arr.length;
        for (int i = arr.length; i >= 1; i--) {
            while (count > (arr.length / 2) && freqArr[i] > 0) {
                count -= i;
                freqArr[i]--;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        int[] arr2 = {7, 7, 7, 7, 7, 7};
        ReduceArraySizeHalf reduceArraySizeHalf = new ReduceArraySizeHalf();
        System.out.println(reduceArraySizeHalf.minSetSize(arr));
        System.out.println(reduceArraySizeHalf.minSetSize(arr2));
    }
}
