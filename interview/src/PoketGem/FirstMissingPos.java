package PoketGem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by lingyanjiang on 17/2/21.
 */
public class FirstMissingPos {
    //O(n) time O(1) space
    public int firstMissingPositive(int [] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            //swap till find its place
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
//        int [] nums = new int[]{1,1,3};
//        int [] nums = new int[]{2,1,3};
//        int [] nums = new int[]{-1,1,3};
//        int [] nums = new int[]{-1,0,3};
//        int [] nums = new int[]{4,-1,0,3};
//        int res = new FirstMissingPos().firstMissingPositive(nums);
//        System.out.println(res);
//        String s = "abcdabcdabcd";
//        System.out.println(s.indexOf("ab",4));
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque.pollLast());
    }
}
