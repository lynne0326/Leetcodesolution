/**
 * Created by lingyanjiang on 16/11/16.
 */
public class MaxMinPath {
    public static int maxMinPath(int [][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int [][] f = new int[m][n];
        f[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = Math.min(matrix[i][0],f[i-1][0]);
        }
        for (int j = 1; j < n; j++) {
            f[0][j] = Math.min(matrix[0][j], f[0][j-1]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.max(Math.min(f[i-1][j], matrix[i][j]), Math.min(f[i][j-1],matrix[i][j]));
            }
        }
        return f[m-1][n-1];
    }

    public static void main (String [] args) {
        int [][] m = new int [][]{
                {8,4,7},
                {6,5,9}
        };
        System.out.println(MaxMinPath.maxMinPath(m));
    }
}
