/**
 * Created by lingyanjiang on 17/1/7.
 */
public class JumpGame {
    //o(n)
    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) return false;
            reach = Math.max(reach, nums[i] + i);
        }
        return true;
    }

    //dp
    public boolean canJump2(int[] nums) {
         boolean [] can = new boolean [nums.length];
         can[0] = true;
         for (int i = 1; i < nums.length; i++) {
             for (int j = i; j >= 0; j--) {
                 if (can[j] && j + nums[j] >= i) {
                     can[i] = true;
                     break;
                 }
             }
         }
         return can[nums.length-1];
    }
}
