package practice.lld;

import java.util.LinkedHashSet;
import java.util.Set;

public class LRUCache2 {
    Set<Integer> cache;
    int capacity;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashSet<>();
    }

    public boolean get(int page) {
        if (!cache.contains(page)) return false;
        cache.remove(page);
        cache.add(page);
        return true;
    }

    public void put(int page) {
        if (cache.size() == this.capacity) {
            Integer firstPage = cache.iterator().next();
            cache.remove(firstPage);
        }
        cache.add(page);
    }

    public void refer(int page) {
        if (!get(page)) put(page);
    }

    public void displayCache() {
        Object[] cacheArray = this.cache.toArray();
        for (int i = cacheArray.length - 1; i >= 0; i--) System.out.println(cacheArray[i]);
    }

    public static void main(String[] args) {
        LRUCache2 ca = new LRUCache2(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.displayCache();
    }

}
