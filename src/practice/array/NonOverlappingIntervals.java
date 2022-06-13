package practice.array;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Comparator<int[]> comparator = (a1, a2) -> (a1[0] != a2[0]) ? a1[0] - a2[0] : a1[1] - a2[1];
        Arrays.sort(intervals, comparator);
        int res = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if (currStart < prevEnd) {
                res++;
                prevEnd = Math.min(prevEnd, currEnd);
            } else prevEnd = currEnd;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(intervals));
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(intervals2));
    }
}
