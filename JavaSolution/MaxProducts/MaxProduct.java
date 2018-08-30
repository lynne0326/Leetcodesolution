/**
 * Created by lingyanjiang on 17/1/10.
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        //只在三个数中产生
        //上一个negMax*nums[i], nums[i], posMa*nums[i]
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int posMax = nums[0];
        int negMax = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = posMax;
            posMax = Math.max(negMax*nums[i], Math.max(posMax*nums[i], nums[i]));
            negMax = Math.min(negMax*nums[i], Math.min(tmp*nums[i], nums[i]));
            if (posMax > res) {
                res = posMax;
            }
        }
        return res;
    }
}
