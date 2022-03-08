package practice.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = Comparator.comparingInt(a -> a);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator.reversed());
        for (int i = 0; i < k; i++) priorityQueue.add(nums[i]);
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        int id = k;
        for (int i = 0; i < nums.length - k; i++) {
            if (!priorityQueue.isEmpty()) res[j++] = priorityQueue.peek();
            priorityQueue.remove(nums[i]);
            priorityQueue.add(nums[id++]);
        }
        if (!priorityQueue.isEmpty()) res[j] = priorityQueue.peek();
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
        System.out.println(Arrays.toString(slidingWindowMax.maxSlidingWindow(arr, 3)));
    }
}
