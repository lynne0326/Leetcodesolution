/**
 * Created by lingyanjiang on 17/1/7.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        resort(nums, i);
    }
    private void swap(int [] nums, int i, int index) {
        int tmp = nums[i];
        nums[i] = nums[index];
        nums[index] = tmp;
    }
    private void resort(int [] nums, int index) {
        int i = index+1;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
