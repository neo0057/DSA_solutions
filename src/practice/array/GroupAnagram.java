package practice.array;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String str = String.valueOf(charArr);
            if (map.containsKey(str)) {
                List<String> list = map.get(str);
                list.add(strs[i]);
                map.put(str, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(str, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) res.add(entry.getValue());
        return res;
    }

    public static void main(String[] args) {
        GroupAnagram groupAnagram = new GroupAnagram();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = groupAnagram.groupAnagrams(strs);
        for (List<String> list : res) {
            for (String str : list) System.out.print(str + " ");
            System.out.println();
        }
    }
}
