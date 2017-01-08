/**
 * Created by lingyanjiang on 17/1/2.
 */
public class ContainerWithMaxWater {
    //以矮的边为准, 另外一边再高都不会比它多
    //two pointers 更新max
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            max = Math.max(max, Math.min(leftHeight, rightHeight) * (right - left));
            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
