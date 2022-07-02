package practice.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {
    private int index;
    private final List<Integer> elements;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.elements = new ArrayList<>();
        this.index = 0;
        while (iterator.hasNext()) elements.add(iterator.next());
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return elements.get(index);
    }

    @Override
    public Integer next() {
        return elements.get(index++);
    }

    @Override
    public boolean hasNext() {
        if (elements.size() == 0) return false;
        return index < elements.size();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PeekingIterator peekingIterator = new PeekingIterator(list.iterator());
        System.out.println(peekingIterator.next());    // return 1, the pointer moves to the next element [1,2,3].
        System.out.println(peekingIterator.peek());    // return 2, the pointer does not move [1,2,3].
        System.out.println(peekingIterator.next());    // return 2, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.next());    // return 3, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.hasNext());
        ; // return False
    }
}
