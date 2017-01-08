public class RemoveDuplicates2 {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public static int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[size]) {
                count++;
            } else {
                if (count >= 2) {
                    nums[size+1] = nums[size];
                    size = size + 2;
                    nums[size] = nums[i];
                    count = 0;
                } else {
                    nums[size+1] = nums[size];
                    size = size + 2;
                    nums[size] = nums[i];
                }
            }
        }
        return size;
    }

    public static void main(String [] args) {
        int [] nums = {-14,-14,-14,-14,-14,-14,-14,-13,-13,-13,-13,-12,-11,-11,-11,-9,-9,-9,-7,-7,-7,-6,-6,-5,-5,-5,-4,-4,-4,-3,-3,-3,-2,-2,-2,-1,-1,0,0,0,0,1,1,1,2,2,2,2,3,3,3,3,3,4,4,4,5,5,6,6,6,7,7,7,7,8,8,8,8,9,9,10,10,11,11,11,11,11,12,12,12,12,13,13,13,13,14,14,15,16,17,18,18,18,20,20,21,21,21,21,21,22,22,22,22,23,24,24,25};
        removeDuplicates(nums);
    }
}