/**
 * Created by lingyanjiang on 18/8/29.
 */
public class BurstBalloons {
//    打气球，我觉得dp很不容易写对，可以divide conuer，用递归+memo，其实等同于dp，
//    注意这层关系，在start和end之间遍历，找到一个k，使得递归左边的max+递归右边的max+nums[start-1]*nus[k]*nums[end+1]最大，并存到memo里，
//    dp[i][j] = max(dp[i][j], nums[i - 1]*nums[k]*nums[j + 1] + dp[i][k - 1] + dp[k + 1][j])             	( i ≤ k ≤ j )
    class Solution {
        public int maxCoins(int[] nums) {
            int[][] memo = new int[nums.length][nums.length];
            return helper(nums, 0, nums.length - 1, memo);
        }

        private int helper(int[] nums, int start, int end, int[][] memo) {
            if(start > end) return 0;
            if(memo[start][end] != 0) return memo[start][end];
            int max = 0;
            for(int i = start; i <= end; i++) {
                int res = helper(nums, start, i - 1, memo) + helper(nums, i + 1, end, memo);
                res += get(nums,start-1)*nums[i]*get(nums, end+1);
                max = Math.max(max, res);
            }
            memo[start][end] = max;
            return max;
        }

        private int get(int[] nums, int idx) {
            if(idx == -1 || idx == nums.length) return 1;
            return nums[idx];
        }
    }

}
