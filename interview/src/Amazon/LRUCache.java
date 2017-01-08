package Amazon;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by lingyanjiang on 16/12/15.
 */
public class LRUCache {
    LinkedList<Integer> keys;
    HashMap<Integer, Integer> cache;
    int count;
    int max;

    public LRUCache(int max) {
        this.keys = new LinkedList<>();
        this.cache = new HashMap<>();
        this.count = 0;
        this.max = max;
    }

    protected int get(int key) {
        if (cache.containsKey(key)) {
            //put to list end
            keys.remove(new Integer(key));
            keys.add(key);
            stdout();
            return cache.get(key);
        } else {
            //miss count++
            count++;
        }
        stdout();
        return -1;
    }

    protected void set(int key, int value) {
        if (cache.containsKey(key)) {
            keys.remove(new Integer(key));
            keys.add(key);
            cache.put(key, value);
        } else {
            if (keys.size() >= max) {
                keys.remove(0);
                cache.remove(key);
            }
            //if key not contains in map
            keys.add(key);
            cache.put(key, value);
        }
        stdout();
    }

    private void stdout() {
        StringBuilder sb = new StringBuilder();
        for (Integer key : keys) {
            sb.append(key).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.set(1,1);
        lruCache.set(2,1);
        lruCache.set(3,1);
        lruCache.set(4,1);
        lruCache.set(5,1);
        lruCache.set(4,1);
        lruCache.set(1,1);
    }

}

class LRUCache2 {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;
    int count;

    public LRUCache2(final int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    protected void set(int key, int value) {
        cache.put(key, value);
    }

    protected int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            count++;
            return -1;
        }
    }

    public static void main(String[] args) {
        LRUCache2 lruCache2 = new LRUCache2(5);
        lruCache2.set(1,1);
        lruCache2.set(2,1);
        lruCache2.set(3,1);
        lruCache2.set(4,1);
        lruCache2.set(5,1);
        lruCache2.set(4,1);
        lruCache2.set(1,1);
    }
}