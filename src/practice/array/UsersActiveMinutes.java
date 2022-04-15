package practice.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UsersActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Arrays.sort(logs, (a1, a2) -> (a1[0] != a2[0]) ? a1[0] - a2[0] : a1[1] - a2[1]);
        Map<Integer, Integer> map = new HashMap<>();
        int currUser = logs[0][0];
        int currUserMinute = logs[0][1];
        int userMinCount = 1;
        for (int i = 1; i < logs.length; i++) {
            if (logs[i][0] == currUser) {
                if (currUserMinute == logs[i][1]) continue;
                currUserMinute = logs[i][1];
                userMinCount++;
            } else {
                map.put(userMinCount, map.getOrDefault(userMinCount, 0) + 1);
                currUser = logs[i][0];
                currUserMinute = logs[0][1];
                userMinCount = 1;
            }
        }
        map.put(userMinCount, map.getOrDefault(userMinCount, 0) + 1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = map.getOrDefault(i + 1, 0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] logs1 = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        int[][] logs2 = {{1, 1}, {2, 2}, {2, 3}};
        int[][] logs3 = {{269637274, 14874}, {269637278, 14877}, {269637275, 14876}, {269637278, 14875}, {269637278, 14875}, {269637277, 14875}};
        int k1 = 5;
        int k2 = 4;
        int k3 = 7;
        UsersActiveMinutes usersActiveMinutes = new UsersActiveMinutes();
        System.out.println(Arrays.toString(usersActiveMinutes.findingUsersActiveMinutes(logs1, k1)));
        System.out.println(Arrays.toString(usersActiveMinutes.findingUsersActiveMinutes(logs2, k2)));
        System.out.println(Arrays.toString(usersActiveMinutes.findingUsersActiveMinutes(logs3, k3)));
    }
}
