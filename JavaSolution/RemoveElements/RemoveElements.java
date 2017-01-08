/**
 * Created by lingyanjiang on 16/6/11.
 */
public class RemoveElements {

    //Note, i<=j
    //rejudge if val == nums[i]
    public int removeElement(int[] nums, int val) {
        int i=0,j=nums.length-1;
        while(i<=j) {
            if(nums[i] == val) {
                nums[i] = nums[j];
                j--;
                continue;
            }
            i++;
        }
        return i;
    }
}
