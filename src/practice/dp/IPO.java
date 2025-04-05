package practice.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) arr[i] = new int[] {profits[i], capital[i]};
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;
        while (k > 0) {
            while (i < n && w >= arr[i][1]) {
                priorityQueue.add(arr[i][0]);
                i++;
            }
            if (priorityQueue.size() != 0) w += priorityQueue.remove();
            k--;
        }
        return w;
    }

    public static void main(String[] args) {
        IPO ipo = new IPO();
        int res = ipo.findMaximizedCapital(3, 0, new int[] {1,2,3}, new int[] {0,1,2});
        System.out.println("raised capital: " + res);
    }
}
