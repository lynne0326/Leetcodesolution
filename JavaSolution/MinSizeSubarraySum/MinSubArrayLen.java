/**
 * Created by lingyanjiang on 17/1/10.
 */
public class MinSubArrayLen {
    //o(n) window solution
    //window sum, o(n), i和j一边加一边减一边更新min
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0,sum = 0, min = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    //o(n^2)
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                count++;
                if (sum >= s) {
                    min = Math.min(count, min);
                    flag = true;
                    break;
                }
            }
        }
        return flag ? min : 0;
    }
}
