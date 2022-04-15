package practice.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) charMap.put(s.charAt(i), i);
        int max = 0;
        int prv = -1;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, charMap.get(s.charAt(i)));
            if (max == i) {
                res.add(max - prv);
                prv = max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels(s));
    }
}
