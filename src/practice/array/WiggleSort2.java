package practice.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class WiggleSort2 {
    public void wiggleSort(int[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : arr) priorityQueue.add(n);
        for (int i = 1; i < arr.length; i += 2) arr[i] = priorityQueue.poll();
        for (int i = 0; i < arr.length; i += 2) arr[i] = priorityQueue.poll();
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        WiggleSort2 wiggleSort2 = new WiggleSort2();
        wiggleSort2.wiggleSort(nums);
    }
}
