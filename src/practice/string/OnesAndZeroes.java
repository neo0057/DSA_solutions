package practice.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnesAndZeroes {
    int res = 0;
    public int findMaxForm(String[] strs, int m, int n) {
        res = 0;
        int len = strs.length;
        int[] zeros = new int[len];
        int[] ones = new int[len];
        int[] dp = new int[len];
        for(int i = 0; i < len; i++) {
            String s = strs[i];
            int c1 = 0, c2 = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') c1++;
                if (s.charAt(j) == '1') c2++;
            }
            zeros[i] = c1;
            ones[i] = c2;
        }
        Arrays.sort(zeros);
        Arrays.sort(ones);
        for (int i = 1; i < len; i++) {
            zeros[i] += zeros[i - 1];
            ones[i] += ones[i - 1];
        }
//        findMaxFormRec(zeros, ones, new ArrayList<>(), 0, len, 0, 0, m, n);
        findMaxFormV2(zeros, ones, len, m, n);
        return res;
    }

    private void findMaxFormV2(int[] zeros, int[] ones, int len, int m, int n) {
        int l = 0, r = len - 1;
        int z, o;
        while (l < r) {
            z = zeros[r] - zeros[l];
            o = ones[r] - ones[l];
            if (z <= m && o <= n) {
                res = Math.max(res, r - l + 1);
                l++;
                r--;
            }
            if (z > m && o > n) {
                l++;
                r--;
            }
            else if (z > m) l++;
            else r--;
        }
    }

    private void findMaxFormRec(int[] zeros, int[] ones, List<Integer> list, int id, int len, int currZeros, int currOnes, int m, int n) {
        if (currZeros <= m && currOnes <= n) res = Math.max(res, list.size());
        for (int i = id; i < len; i++) {
            if (currZeros + zeros[i] > m || currOnes + ones[i] > n) continue;
            list.add(i);
            findMaxFormRec(zeros, ones, list, i + 1, len, currZeros + zeros[i], currOnes + ones[i], m, n);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        String[] strs2 = {"10","0","1"};
        OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
        System.out.println(onesAndZeroes.findMaxForm(strs, 5, 3));
//        System.out.println(onesAndZeroes.findMaxForm(strs2, 1, 1));
    }
}
