/**
 * Created by lingyanjiang on 18/7/30.
 */
public class WordSearch {
    int m,n;
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(helper(board, visited, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, boolean[][] visited, String word, int x, int y, int idx) {
        if (idx == word.length() - 1 && board[x][y] == word.charAt(idx)) return true;
        if (word.charAt(idx) != board[x][y]) return false;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx < 0 || xx >= m || yy < 0 || yy >= n || visited[xx][yy]) continue;
            if (helper(board, visited, word, xx, yy, idx + 1)) return true;
        }
        visited[x][y] = false;
        return false;
    }

}
