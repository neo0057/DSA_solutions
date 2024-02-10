package practice.data_structure;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Integer> cacheKey;
    int capacity;

    public LRUCache(int capacity) {
        cacheKey = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cacheKey.containsKey(key)) return -1;
        int val = cacheKey.get(key);
        cacheKey.remove(key);
        cacheKey.put(key, val);
        printCache();
        return val;
    }

    public void put(int key, int value) {
        if (capacity <= 0) cacheKey.remove(cacheKey.entrySet().iterator().next());
        cacheKey.remove(key);
        cacheKey.put(key, value);
        printCache();
        capacity++;
    }

    private void printCache() {
        for (Integer key : cacheKey.keySet()) {
            System.out.println("key: " + key + ", value: " + cacheKey.get(key));
        }
    }
}
