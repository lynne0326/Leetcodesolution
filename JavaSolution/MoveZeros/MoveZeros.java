/**
 * Created by lingyanjiang on 16/6/4.
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int counter = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0) {
                counter++;
            } else {
                nums[i-counter] = nums[i];
            }
        }
        while(counter > 0 ) {
            nums[nums.length - counter] = 0;
            counter--;
        }
    }
}
