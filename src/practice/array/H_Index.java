package practice.array;

import java.util.Arrays;

public class H_Index {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (citations[m] == n - m) return citations[m];
            else if (citations[m] > n - m) r = m - 1;
            else l = m + 1;
        }
        return n - l;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 6, 1, 5};
        H_Index hIndex = new H_Index();
        System.out.println(hIndex.hIndex(arr));
        System.out.println(hIndex.hIndex(new int[]{1, 3, 1}));
    }
}
