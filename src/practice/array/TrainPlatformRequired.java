package practice.array;

import java.util.*;

public class TrainPlatformRequired {

/*
Given arrival and departure times of all trains that reach a railway station,
the task is to find the minimum number of platforms required for the railway station so that no train waits.

Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
       dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
Explanation: There are at-most three trains at a time (time between 9:40 to 12:00)

Input: arr[] = {9:00, 9:40}
       dep[] = {9:10, 12:00}
Output: 1
Explanation: Only one platform is needed.

*/


    class TrainTime {
        public int time;
        public boolean isArrival;

        TrainTime(int time, boolean isArrival) {
            this.time = time;
            this.isArrival = isArrival;
        }
    }

    public int minimumPlatformRequired(int[] arr, int[] dep) {
        List<TrainTime> list = new ArrayList<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            TrainTime t1 = new TrainTime(arr[i], true);
            TrainTime t2 = new TrainTime(dep[i], false);
            list.add(t1);
            list.add(t2);
        }
        Comparator<TrainTime> comparator = Comparator.comparing((TrainTime t) -> t.time);
        list.sort(comparator);
        int res = 0;
        int count = 0;
        for (int i = 0; i < len * 2; i++) {
            TrainTime t = list.get(i);
            if (t.isArrival) count++;
            else count--;
            res = Math.max(res, count);
        }
        return res;
    }

    public int minimumPlatformRequiredOptimal(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int res = 0;
        int count = 0;
        int len = arr.length;
        int i = 0, j = 0;
        while (i < len && j < len) {
            if (arr[i] < dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        int[] dep = new int[n];
        for (int i = 0; i < n; i++) {
            String timeStr = scanner.nextLine();
            String[] tempArr = timeStr.split(" ");
            arr[i] = Integer.parseInt(tempArr[0]);
            dep[i] = Integer.parseInt(tempArr[1]);
        }
        TrainPlatformRequired tpr = new TrainPlatformRequired();
        int ans = tpr.minimumPlatformRequiredOptimal(arr, dep);
        // int ans = new Solution().minimumPlatformRequired(arr, dep);
        System.out.print(ans);
    }
}
