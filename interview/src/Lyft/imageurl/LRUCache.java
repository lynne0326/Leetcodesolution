package Lyft.imageurl;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lingyanjiang on 17/1/23.
 */
public class LRUCache {
    int capacity;
    LinkedHashMap<String, Image> cache;

    public LRUCache(final int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<String, Image>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public Image get(String key) {
        if (cache.containsKey(key)) return cache.get(key);
        return null;
    }

    public void set(String key, Image image) {
        cache.put(key, image);
    }
}
