package practice.array;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        Comparator<int[]> comparator = Comparator.comparingInt(p -> (p[0] * p[0] + p[1] * p[1]));
        Arrays.sort(points, comparator);
        for (int i = 0; i < k; i++) res[i] = points[i];
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int k2 = 2;
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        System.out.println(Arrays.deepToString(kClosestPointsToOrigin.kClosest(points, k)));
        System.out.println(Arrays.deepToString(kClosestPointsToOrigin.kClosest(points2, k2)));
    }
}
