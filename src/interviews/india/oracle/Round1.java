package interviews.india.oracle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Round1 {

    public static void printZeroSumTriplets(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        int id = 0;
        for(Integer num : arr) {
            map.put(num, id);
            id++;
        }
        int a, b, sum;
        a = 0;
        b = arr.length - 1;
        while(a < b) {
            sum = arr[a] + arr[b];
            if (map.containsKey(-sum) && map.get(-sum) != a && map.get(-sum) != b) {
                System.out.println(arr[a] + ", " + arr[b] + ", " + (-sum));
                a++;
                b--;
            }
            else if (sum > 0) b--;
            else a++;
        }
    }

    public static void rotateArray(int[] arr, int n) {
        int[] temp = new int[n];
        int size = arr.length;
        int id = 0;
        for(int i = size - n; i < size; i++) temp[id++] = arr[i];
        id = size - 1;
        for(int i = size - n - 1; i >= 0; i--) arr[id--] = arr[i];
        for (int i = 0; i < n; i++) arr[i] = temp[i];
        for (int j : arr) System.out.print(j + " ");
    }

    public static void main(String[] args) {
     int[] arr1 = {3, -2, 5, -4, 2, 9, -5};
     printZeroSumTriplets(arr1);
//        int[] arr2 = {1,2,3,4,5,6};
//        rotateArray(arr2, 2);
    }
}
