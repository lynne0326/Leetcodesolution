import java.util.Stack;

/**
 * Created by lingyanjiang on 16/10/1.
 */
public class LargestRectangle {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public static int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i <= height.length; i++) {
            int curHeight = (i == height.length) ? -1:height[i];
            while (!stack.isEmpty() && curHeight <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i :i - stack.peek() - 1;
                max = Math.max(h*w, max);
            }
            stack.push(i);
        }
        return max;
    }
    public static void main(String [] args) {
        int [] height = new int[]{2,1,5,6,2,3};
        largestRectangleArea(height);
    }
}
