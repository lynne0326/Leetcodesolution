import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 二位sliding window
 */
public class MinSubarray {
    public static int[][] minSubarray(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return null;
        int m = matrix.length;
        int n = matrix[0].length;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> tmp = new ArrayList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                if (pq.size() == k) {
                    tmp.add(pq.peek());
                    pq.remove(matrix[i][j-k]);
                }
                pq.add(matrix[i][j]);
            }
            pq.remove(matrix[i][matrix[0].length - k - 1]);
            tmp.add(pq.peek());
            lists.add(tmp);
        }
        //比竖项
        int[][] res = new int[m - k + 1][n - k + 1];
        for (int l = 0; l <= n - k ; l++) {
            for (int i = 0; i <= m - k; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = i; j < i + k; j++) {
                    min = Math.min(min, lists.get(j).get(l));
                }
                res[i][l] = min;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        minSubarray(new int[][]{{1,2,3,4},{4,5,6,100},{7,8,9,2}}, 2);
    }

}
