package quantcast;

import java.util.Random;

/**
 * Created by lingyanjiang on 17/3/27.
 */
public class MaxRandomIndx {
//    给你一个array，返回array里面最大数字的index，但是必须是最大数字里面随机的一个index。比如[2,1,2,1,5,4,5,5]必须返回[4,6,7]中的随机的一个数字，要求O(1)space。
//
//    出现过很多次的FB的题，naive的做法是先扫一遍，找出最大值和最大值的个数。然后从头再扫一遍即可。
//
//    用Reservoir Sampling思路做，one pass就可以了。

    public int randomMax(int [] nums) {
        int res = -1;
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        Random r = new Random();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                cnt = 1;
                res = i;
            } else if (nums[i] == max) {
                cnt++;
                res = r.nextInt(cnt) == 0 ? i : res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new MaxRandomIndx().randomMax(new int[]{2,1,2,1,5,4,5,5});
        System.out.println(res);
    }

}
