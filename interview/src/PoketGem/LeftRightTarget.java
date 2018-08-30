package PoketGem;

/**
 * Created by lingyanjiang on 17/2/22.
 */
public class LeftRightTarget {
    public static int leftRightTarget(int[] nums, int target) {
        // Left Total : k - 1
        // Left Equals T: x
        // Left Not Equals T: k - 1 - x
        // Right total = n - k
        // Right Equals T :T -x
        // Right Not Equals T: n - k -(T - x)
        // x = n - k - (T - x)
        // k = n - T

//        之前没看见有人报这个followup，一开始虽然直觉觉得不能，但是还是没想清楚，只想到在第二遍扫的时候有四个相关
//        的变量：xMet，nonXMet, xNotMet, nonXNotMet。其中xMet和nonXMet组成了扫过的部分，xNotMet和nonXNotMet
//        组成了未扫过的部分。
//        符合的条件则是：xMet = nonXNotMet。而这两个变量一个只能递增(xMet)，一个只能递减(nonXNotMet)，
//        而且并不能同时不变，因为如果当前index值是x，index++之后xMet也+1；如果当前的index值不是x，
//        index++之后nonXNotMet就-1。所以不能同时不变，就不能有多个符合的。

        int T = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                T++;
            }
        }
        if (n - T == 0 || n - T == n) {
            return -1;
        }
        return n - T;
    }

    public static void main(String[] args) {
        int com = leftRightTarget(new int[]{3,3,3,3,3,3,3}, 3);
//        int res = leftRightTarget(new int[]{1,3,5,9,3,7,3}, 3);
//        int res = findPartition(new int[]{3,3,5,9,1,7,5}, 3);
        System.out.println(com);
    }
}
