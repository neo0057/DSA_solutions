package practice.array;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalSolution {
    public int[][] mergeIntervals(int[][] intervals) {
        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[0]);
        Arrays.sort(intervals, comparator);
        int id = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (currInterval[0] <= intervals[id][1] && currInterval[1] <= intervals[id][1]) continue;
            if (currInterval[0] <= intervals[id][1]) intervals[id][1] = currInterval[1];
            else {
                ++id;
                intervals[id][0] = currInterval[0];
                intervals[id][1] = currInterval[1];
            }
        }
        return Arrays.stream(intervals, 0, id + 1).toArray(int[][]::new);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int[][] intervalsCopy = new int[len + 1][2];
        for (int i = 0; i < len; i++) intervalsCopy[i] = intervals[i];
        intervalsCopy[len] = newInterval;
        return mergeIntervals(intervalsCopy);
    }

    public static void main(String[] args) {
        int[][] intervalArray = {{1,3}, {2,6}, {5,10}, {15,18}};
        int[][] intervalArray2 = {{1,3}, {6, 9}};
        IntervalSolution intervalSolution = new IntervalSolution();
        int[][] res = intervalSolution.insert(intervalArray2, new int[]{2, 5});
        for (int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
