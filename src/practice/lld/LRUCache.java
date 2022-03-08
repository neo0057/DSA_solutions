package practice.lld;

import java.util.*;

public class LRUCache {
    private Integer capacity;
    private Deque<Integer> deque;
    private Set<Integer> set;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.deque = new LinkedList<>();
        this.set = new HashSet<>(capacity);
    }
    public void refer(int page) {
        if (!set.contains(page)) {
            if (deque.size() == this.capacity) {
                int lastElement = deque.removeLast();
                set.remove(lastElement);
            }
        } else {
            deque.remove(page);
        }
        deque.offerFirst(page);
        set.add(page);
    }
    public void display() {
        for (Integer page : deque) System.out.print(page + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.refer(2);
        cache.refer(2);
        cache.refer(1);
        cache.display();
    }
}
