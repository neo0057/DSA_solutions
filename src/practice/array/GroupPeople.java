package practice.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 */
public class GroupPeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> freq = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> groups = (freq.containsKey(groupSizes[i])) ? freq.get(groupSizes[i]) : new ArrayList<>();
            groups.add(i);
            freq.put(groupSizes[i], groups);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Integer key : freq.keySet()) {
            List<Integer> groups = freq.get(key);
            int startIndex = 0;
            while (startIndex < groups.size()) {
                List<Integer> currGroup = groups.subList(startIndex, startIndex + key);
                res.add(currGroup);
                startIndex += key;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        GroupPeople groupPeople = new GroupPeople();
        List<List<Integer>> res = groupPeople.groupThePeople(groupSizes);
        for (List<Integer> group : res) {
            for (Integer people : group) System.out.print(people + " ");
            System.out.println();
        }
    }
}
