/**
 * Created by lingyanjiang on 18/8/15.
 */
public class FindFriendCircleNum {
    //dfs o(n^2) o(n)
    public int findCircleNum(int[][] M) {
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 0 || M[i][j] == 2) continue;
                dfs(M, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] M, int row) {
        for (int j = 0; j < M[row].length; j++) {
            if (M[row][j] == 0 || M[row][j] == 2) continue;
            M[row][j] = 2;
            dfs(M, j);
        }
    }


}
