/**
 * Created by lingyanjiang on 16/6/11.
 */
public class RemoveDuplicates {
    //Tail as mark
    //Whenever current num not equal to the latest updated tail
    //reverse
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int tail = 0;
        for(int num:nums) {
            if(num != nums[tail]) {
                nums[++tail] = num;
            }
        }
        return tail+1;
    }

    public int strStr(String source, String target) {
        //write your code here
        return source.indexOf(target) >=0?target.indexOf(source):-1;
    }
}
