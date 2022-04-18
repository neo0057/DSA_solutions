package practice.string;

import java.util.Arrays;

public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        String[] arr = s.split("\\|");
        int[][] splitArray = new int[arr.length][2];
        int start = arr[0].length(), end = -1, id = 0;
        int totalLen = 0;
        if (s.charAt(0) == '|') {
            start = 0;
            end = arr[0].length() + 1;
            splitArray[id][0] = start;
            splitArray[id][1] = end;
            start = end;
            totalLen += end + 1;
            id++;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (end != -1) {
                totalLen += arr[i + 1].length();
                splitArray[id][0] = end;
                splitArray[id][1] = totalLen;
                start = totalLen;
                id++;
            } else {
                totalLen += ((id == 0) ? 0 : splitArray[i - 1][1]) + arr[i + 1].length();
                end = totalLen;
                splitArray[id][0] = ((id == 0) ? 0 : splitArray[id - 1][1]) + arr[i].length();
                splitArray[id][1] = end;
                start = end;
                id++;
            }
        }
        System.out.println(arr.length);
        return res;
    }

    public static void main(String[] args) {
        String s = "**|**|***|";
        int[][] queries = {{2, 5}, {5, 9}};
        PlatesBetweenCandles platesBetweenCandles = new PlatesBetweenCandles();
        System.out.println(Arrays.toString(platesBetweenCandles.platesBetweenCandles(s, queries)));
    }
}
