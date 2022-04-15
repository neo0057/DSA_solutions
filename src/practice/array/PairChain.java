package practice.array;

import java.util.Arrays;
import java.util.Comparator;

public class PairChain {
    public int findLongestChain(int[][] pairs) {
        Comparator<int[]> comp = Comparator.comparing(a -> a[0]);
        Arrays.sort(pairs, comp);
        int res = 1;
        int currLen = 1;
        int[] prv = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > prv[1]) {
                currLen++;
                prv = pairs[i];
            }
            else currLen = 1;
            res = Math.max(res, currLen);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{2,3},{3,4}};
        int[][] arr1 = {{1,2},{7,8},{4,5}};
        PairChain pairChain = new PairChain();
        System.out.println(pairChain.findLongestChain(arr));
    }
}
