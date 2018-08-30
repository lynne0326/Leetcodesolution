package PoketGem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 17/2/22.
 */
public class FindDuplicates {
    public static List<Integer> findDuplicates(int[] nums, int n) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length <= 1) return res;
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]);
            nums[idx] = -nums[idx];
        }
        for (int i = 0; i <= n; i++) {
            if (nums[i] > 0) {
                res.add(i);
            }
        }

        for(int num: res){
            System.out.print(num+",");
        }
        System.out.println();
        return res;
    }

    public static void main(String[] args) {
        findDuplicates(new int[]{1, 3, 3, 4, 0, 2, 1}, 4);
    }
}
