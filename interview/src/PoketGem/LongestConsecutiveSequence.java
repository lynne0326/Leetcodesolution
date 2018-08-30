package PoketGem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lingyanjiang on 17/2/22.
 */
public class LongestConsecutiveSequence {
    public static boolean longestConsecutive(int k, int [] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                int left = map.containsKey(array[i] - 1) ? map.get(array[i] - 1) : 0;
                int right = map.containsKey(array[i] + 1) ? map.get(array[i] + 1) : 0;
                int len = left + 1 + right;
                if (len >= k) {
                    return true;
                }
                map.put(array[i] - left, len);
                map.put(array[i] + right, len);
                map.put(array[i], len);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(4, nums));
    }
}
