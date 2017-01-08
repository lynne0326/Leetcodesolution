import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by lingyanjiang on 16/12/1.
 */
public class NQueen {
    /**
     * Get all distinct N-Queen solutions
     *
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<Integer>> res;
    ArrayList<ArrayList<String>> result;

    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        result = new ArrayList<ArrayList<String>>();
        if (n == 0) {
            return result;
        }
        res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        HashSet<Integer> visitedCol = new HashSet<>();
        dfs(n, 0, tmp, visited, visitedCol);
        for (ArrayList<Integer> array : res) {
            ArrayList<String> temp = new ArrayList<>();
            for (int j : array) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (i != j) {
                        sb.append(".");
                    } else {
                        sb.append("Q");
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
        }
        return result;
    }

    private void dfs(int n, int row, ArrayList<Integer> tmp, boolean[][] visited, HashSet<Integer> visitedCol) {

        if (row == n) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (visited[row][j] || visitedCol.contains(j) || isInDiags(row, j, tmp)) {
                continue;
            }
            visitedCol.add(j);
            tmp.add(j);
            dfs(n, row + 1, tmp, visited, visitedCol);
            tmp.remove(tmp.size() - 1);
            visitedCol.remove(j);
        }
    }

    private boolean isInDiags(int i, int j, ArrayList<Integer> tmp) {
        for (int row = 0; row < tmp.size(); row++) {
            int col = tmp.get(row);
            if (Math.abs(i - row) == Math.abs(j - col)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        NQueen nq = new NQueen();
        nq.solveNQueens(5);

    }
}
