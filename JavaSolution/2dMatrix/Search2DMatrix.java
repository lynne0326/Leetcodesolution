/**
 * Created by lingyanjiang on 17/1/8.
 */
public class Search2DMatrix {
    //binary search o(mn)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m*n - 1;
        if (n == 0) {
            return false;
        }
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            int row = mid/n;
            int col = mid%n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[start/n][start%n] == target || matrix[end/n][end%n] == target) {
            return true;
        }
        return false;
    }


    //two pointers 只在排好序的时候有效 o(m+n)
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
