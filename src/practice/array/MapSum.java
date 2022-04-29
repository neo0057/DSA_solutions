package practice.array;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    Map<String, Integer> map;

    public MapSum() {
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int res = 0;
        for (String key : map.keySet()) if (key.startsWith(prefix)) res += map.get(key);
        return res;
    }
}
