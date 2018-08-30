package PoketGem;

/**
 * Created by lingyanjiang on 17/3/7.
 */
public class ThreeIncreasingNumber {
    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                System.out.println(first);
                System.out.println(second);
                System.out.println(nums[i]);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] test = new int []{10,15,2,3,9};
        System.out.println(increasingTriplet(test));

    }
}
