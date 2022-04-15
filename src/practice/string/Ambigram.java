package practice.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ambigram {

  /*
    Ambigrams: A string that when rotated 180 degrees, looks the same
https://upload.wikimedia.org/wikipedia/commons/2/2a/YeahAmbigram.gif
Examples: yeah -> yeah, pod -> pod

Given a list of words, return the words that are ambigrams
Example input: [car, house, abc, yeah, computer]
Output:[yeah]

// a -> e
// b -> q
// c ->
// d -> p
// e -> a

Example mapping: a-e, b-q, d-p, h-y, i-i, l-l, m-w, n-u, o-o, s-s, x-x, z-z

*/

    List<String> getAmbigrams(List<String> arr) {
        Map<Character, Character> map = new HashMap<>();
        map.put('a', 'e');
        map.put('b', 'q');
        map.put('e', 'a');
  /*
   all mapping here
  */
        List<String> res = new ArrayList<>();
        for (String s : arr) {
            if (isAmbigram(s, map)) res.add(s);
        }
        return res;
    }

    boolean isAmbigram(String s, Map<Character, Character> map) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            Character ch1 = s.charAt(i);
            Character ch2 = s.charAt(j);
            if (map.containsKey(ch1) && map.get(ch1).equals(ch2)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
/*
    Given a
    list of
    input words, return
    the ones
    that rotate
    into any
    word in
    the input
    list
    Example input:[car,house,computer,pod,mm,ww,xyz]
    output:[pod,mm,ww]
*/

    List<String> getAmbigrams2(List<String> arr) {
        Map<Character, Character> map = new HashMap<>();
        Map<String, Boolean> strMap = new HashMap<>();
        map.put('a', 'e');
        map.put('b', 'q');
        map.put('a', 'e');
  /*
   all mapping here
  */
        List<String> res = new ArrayList<>();
        for (String s : arr) strMap.put(s, Boolean.TRUE);
        for (String s : arr) {
            if (isAmbigram(s, map) || isRotatedStringAvailable(s, map, strMap)) res.add(s);
        }
        return res;
    }

    boolean isRotatedStringAvailable(String s, Map<Character, Character> map, Map<String, Boolean> strMap) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!map.containsKey(ch)) return false;
            res.append(map.get(ch));
        }
        return strMap.containsKey(res.toString());
    }
}
