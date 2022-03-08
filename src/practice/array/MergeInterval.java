package practice.array;

import java.util.Arrays;
import java.util.Comparator;

public class MergeInterval {

    public static void mergeIntervals(Interval[] arr) {
        Comparator<Interval> comparator = Comparator.comparingInt((Interval i) -> i.start);
        Arrays.sort(arr, comparator);
        int index = 0;
        for(int i = 1; i < arr.length; i++) {
            if (arr[index].end >= arr[i].start) {
                arr[index].end = Math.max(arr[index].end, arr[i].end);
            } else {
                index++;
                arr[index] = arr[i];
            }
        }
        System.out.print("merged intervals are: ");
        for (int i = 0; i <= index; i++) System.out.print("[" + arr[i].start + "," + arr[i].end + "]");
        System.out.println();
    }

    public static void main(String[] args) {
        Interval[] arr =new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
    }
}
