package PoketGem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lingyanjiang on 17/3/3.
 */
public class SubarraySumZero {
    public static List<int []> sumToZero(int [] nums) {
        List<int []> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        map.put(sum, new ArrayList<>());
        map.get(sum).add(-1);
        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) res.add(new int[]{i, i});
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, new ArrayList<Integer>());
            } else {
                for (int idx: map.get(sum)) {
                    res.add(new int[]{idx + 1, i});
                }
            }
            map.get(sum).add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        List<int [] > res = sumToZero(new int[]{1,2,-2,-1,0,5});
        for (int [] n: res) {
            System.out.println(n[0]+" "+n[1]);
        }

    }
}
