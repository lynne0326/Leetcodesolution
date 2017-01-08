/**
 * Created by lingyanjiang on 16/9/8.
 */
public class PartitionArray {
    public static int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            while (left <= right && nums[left] < k) {
                left ++;
            }
            while (left <= right && nums[right] >= k) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
                right--;
            }
        }
        return left;
    }
    public static void main(String [] args) {
        int [] nums = new int[]{9, 6, 8, 8, 8, 8, 7, 9, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9};
        int k = 9;
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        int a = partitionArray(nums,k);
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println(a);
    }
}
