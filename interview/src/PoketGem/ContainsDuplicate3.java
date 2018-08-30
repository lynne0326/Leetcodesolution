package PoketGem;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by lingyanjiang on 17/2/22.
 */
public class ContainsDuplicate3 {
    //Binary Search Tree时间复杂度是O(nlongk), 每次取subset的复杂度是log(k)

    //As a result maintaining the tree of size k will
    // result in time complexity O(N lg K). In order to
    // check if there exists any value of range abs(nums[i] - nums[j])
    // to simple queries can be executed both of time complexity O(lg K)
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1 || t < 0) return false;
        TreeSet<Long> tree = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            //左闭右开
            long left = (long)nums[i] - t;
            long right = (long)nums[i] + t + 1;
            Set<Long> subset = tree.subSet(left, right);
            if (!subset.isEmpty()) return true;
            tree.add((long)nums[i]);
            if (i >= k) {
                tree.remove((long)nums[i-k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) return false;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (Math.abs((long) nums[j] - cur) <= t) return true;
            }
        }
        return false;
    }

}
