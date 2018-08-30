package quantcast;
import java.util.*;

/**
 * Created by lingyanjiang on 17/3/28.
 */
public class LFUCache {
    Map<Integer,Integer> vals;
    Map<Integer, Integer> freq;
    Map<Integer, LinkedHashSet<Integer>> freqList;
    int capacity;
    int min = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.vals = new HashMap<>();
        this.freq = new HashMap<>();
        this.freqList  = new HashMap<>();
    }

    public int get(int key) {
        if (!vals.containsKey(key)) return -1;
        int res = vals.get(key);
        int tmpcnt = freq.get(key);
        freq.put(key, tmpcnt + 1);
        freqList.get(tmpcnt).remove(new Integer(key));
        if (freqList.get(tmpcnt).size() == 0 && min == tmpcnt) min++;
        if (!freqList.containsKey(tmpcnt + 1)) {
            freqList.put(tmpcnt + 1, new LinkedHashSet<Integer>());
        }
        freqList.get(tmpcnt + 1).add(key);
        return res;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if (vals.size() == capacity) {
            int rm = freqList.get(min).iterator().next();
            vals.remove(rm);
            freqList.get(min).remove(new Integer(rm));
            freq.remove(rm);
        }
        vals.put(key, value);
        min = 1;
        freq.put(key, 1);
        if (!freqList.containsKey(min)) {
            freqList.put(1, new LinkedHashSet<>());
        }
        freqList.get(min).add(key);
    }

    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.get(3);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}

