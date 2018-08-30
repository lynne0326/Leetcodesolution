package PoketGem;

/**
 * Created by lingyanjiang on 17/3/1.
 */
public class FindLeftMost {

    //从右上角开始往左走到1,
    //向下走,如果遇到1,则继续向左走,不然继续向下走 O(M+N)
    
    public int [] findLeftMost(int [][] matrix) {
        if (matrix == null || matrix.length == 0) return null;

        int m = matrix.length;
        int n = matrix[0].length;

        int [] res = new int [2];//rows, cols

        res[0] = 0;
        res[1] = n - 1;

        for (int i = 0; i < m; i++) {
            while (res[1] - 1>= 0 && matrix[i][res[1] - 1] == 1) {
                res[1]--;
                res[0] = i;
            }
        }
        System.out.println(res[0] + " " + res[1]);
        return res;

    }

    public static void main(String[] args) {
        int [][] matrix = new int[][]{
                {0,0,0,0,1,1},
                {0,0,0,1,1,1},
                {0,0,0,0,1,1},
                {0,0,1,1,1,1},
                {0,0,0,1,1,1},
                {0,0,0,1,1,1}
        };
        FindLeftMost findLeftMost = new FindLeftMost();
        findLeftMost.findLeftMost(matrix);
    }
}
