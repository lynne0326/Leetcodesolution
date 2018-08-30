package google;

import java.util.Iterator;

/**
 * Created by lingyanjiang on 17/2/20.
 */
public class PeekingIterator {
    //用iterator next来保存,用null来表示,记得这里是Integer 不是int, 因为有null

    private Integer next = null;
    private Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext())
            next = iter.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    public Integer next() {
        Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
    }

    public boolean hasNext() {
        return next != null;
    }
}
