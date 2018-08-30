import java.util.HashMap;
import java.util.Map;

/**
 * Created by lingyanjiang on 18/8/24.
 */
public class TargetSum {

    // dfs + memo
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        return dfs(nums, S, 0, map);
    }

    private int dfs(int[] nums, int S, int idx, Map<Integer, Map<Integer, Integer>> map) {
        if(idx == nums.length && S == 0) {
            return 1;
        }
        if(map.containsKey(idx)) {
            if(map.get(idx).containsKey(S)) {
                return map.get(idx).get(S);
            }
        }
        int res = 0;
        if(idx < nums.length) {
            res += dfs(nums, S - nums[idx], idx + 1, map);
            res += dfs(nums, S + nums[idx], idx + 1, map);
        }
        map.putIfAbsent(idx, new HashMap<>());
        map.get(idx).put(S, res);
        return res;
    }

    //dp

}
