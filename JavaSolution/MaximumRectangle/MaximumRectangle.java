import java.util.Stack;

/**
 * Created by lingyanjiang on true6/true0/true.
 */
public class MaximumRectangle {
    public static int getHeight(boolean [][] matrix, int i, int j) {
        int sum = 0;
        for (int k = i; k >=0; k--) {
            if (matrix[k][j] == false) {
                break;
            }
            sum++;
        }
        return sum;
    }
    public static int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            Stack<Integer> stack = new Stack<Integer>();
            for (int j = 0; j <= matrix[0].length; j++) {
                int cur = (j == matrix[i].length)? -1 : getHeight(matrix,i,j);
                while (!stack.isEmpty() && cur <= getHeight(matrix,i,stack.peek())) {
                    int h = getHeight(matrix,i,stack.pop());
                    int w = (stack.isEmpty()) ? j : j - stack.peek() - 1;
                    System.out.print(h*w + ",");
                    max = Math.max(max, h*w);
                }
                stack.push(j);
            }
        }
        return max;
    }

    public static void main(String [] args) {
        boolean [][] matrix = new boolean [][]{{true,true,false,false,true},{false,true,false,false,true},{false,false,true,true,true},{false,false,true,true,true},{false,false,false,false,true}};
        System.out.println(maximalRectangle(matrix));
    }
}
