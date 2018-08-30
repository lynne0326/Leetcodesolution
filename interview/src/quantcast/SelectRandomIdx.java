package quantcast;

import java.util.Random;

/**
 * Created by lingyanjiang on 17/3/27.
 */
public class SelectRandomIdx {
    //一个数的版本~~~
    //有一个很大的数组,在数组中random选中一个数,sapace(o1)
    //reservior sampling
    //证明, num[i] replace前面数的概率是1/n
    //首先,当第n个数保留,并且倒数第二个数保留并且被选中的概率
    //第n个数保留且不替换倒数第二的那个数, (n-1)/n,
    //第n个数保留的概率,只能等于0所以就是,1/(n-1)
    //所以最后概率相乘, 1/(n-1) * (n-1)/n = 1/n
    Random r = new Random();

    public int selectRandom(int[] nums) {
        int res = -1;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) res = nums[i];
            if (r.nextInt(cnt) == 0) {
                res = nums[i];
            }
            cnt++;
        }
        return res;
    }

    //原理是一样的,从stream里抽k个
    //倒数第二个数被选中 k/(n-1)
    //倒数第二个数不被倒数第一个数替换的概率 (n-1)/n, replace any number other than the n-1th one
    //乘起来k/n
    public int[] selectRandomK(int[] nums, int k) {
        int[] res = new int[k];
        int i = 0;
        for (; i < k; i++) {
            res[i] = nums[i];
        }

        for (; i < nums.length; i++) {
            int j = r.nextInt(k);
            if (j < k) {
                //replace one random numbers in res array
                res[j] = nums[i];
            }
        }
        return res;
    }
}
