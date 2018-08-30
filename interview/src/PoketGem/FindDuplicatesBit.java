package PoketGem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 17/3/3.
 */
//https://mydevelopedworld.wordpress.com/2012/10/06/duplicate-entries-with-4kb-constraint-bit-array-is-the-solution/
    //前提是需要在4kb的内存下找到, 且N <= 32000
    //4kb = 4 * 8 * 1024 ~= 32000
    //用 32000/32 = 1000 个int来表示,
    //每个int 可以表示32个值, 有1000个int, so 32000个
public class FindDuplicatesBit {
    public static List<Integer> findDuplicates(int [] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int [] bytes = new int[1000];
        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i] / 32;
            int innerIdx = nums[i] % 32;
            if ((bytes[idx] & (1 << innerIdx)) != 0) {
                res.add(nums[i]);
            }
            bytes[idx] |= (1 << innerIdx);
        }
        for(int r: res) {
            System.out.println(r);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,9,4,2000,25000,6,2000,9};
        System.out.println(findDuplicates(nums));
    }
}
