import java.util.HashMap;

/**
 * Created by lingyanjiang on 16/5/29.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement))
                return new int []{(int)map.get(complement),i};
            map.put(nums[i],i);
        }
        return null;
    }
}

