import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 17/1/2.
 */
public class FindNumbersDisappeard {
    //遍历数组nums，记当前元素为n，令nums[abs(n) - 1] = -abs(nums[abs(n) - 1])

    //再次遍历nums，将正数对应的下标+1返回即为答案，因为正数对应的元素没有被上一步骤标记过。

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[Math.abs(nums[i]) - 1];
            if (val > 0) {
                nums[Math.abs(nums[i]) - 1] = - nums[Math.abs(nums[i]) - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }
}
