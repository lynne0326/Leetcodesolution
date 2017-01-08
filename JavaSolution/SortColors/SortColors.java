

public class SortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void swap(int [] nums, int i,int  j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null) {
            return;
        }
        int i = 0, r = 0, b = nums.length - 1;
        while (i <= b) {
            if (nums[i] == 0) {
                swap(nums, i, r);
                r++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, b);
                b--;
            }else {
                i++;
            }
        }
    }
}