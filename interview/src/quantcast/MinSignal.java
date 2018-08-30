package quantcast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 17/4/3.
 */
public class MinSignal {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    public int getMinSignalStrength(int[][] grid, int sx, int sy, int ex, int ey) {
        if (grid == null || grid.length == 0) return 0;
        List<Integer> maxs = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, sx, sy, ex, ey, Integer.MIN_VALUE, maxs, visited);
        int min = Integer.MAX_VALUE;

        for (int n : maxs) {
            min = Math.min(n, min);
        }
        return min;
    }

    private void dfs(int[][] grid, int x, int y, int ex, int ey, int curMax, List<Integer> maxs, boolean[][] visited) {
        if (x == ex && y == ey) {
            maxs.add(curMax);
            return;
        }
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int xx = x + dx[k];
            int yy = y + dy[k];
            if (xx < 0 || xx >= grid.length || yy < 0 || yy >= grid[0].length || visited[xx][yy]) continue;
            int max = Math.max(curMax, Math.abs(grid[xx][yy] - grid[x][y]));
            dfs(grid, xx, yy, ex, ey, max, maxs, visited);
        }
        visited[x][y] = false;
    }

    public static void main(String[] args) {
        int min = new MinSignal().getMinSignalStrength(
                new int [][]{{1,3,6},{2,4,5},{3,1,7}
                }, 0, 0, 2, 2);
        System.out.println(min);
    }
}
