import java.util.HashSet;
import java.util.Set;

/**
 * Created by lingyanjiang on 18/8/26.
 */
public class BricksFallingWhenHit {

    //DFS: TLE
    //brute force, 每个hit的时候,把hit本身砸掉,再dfs四个方向,如果和顶部相连就不砸,顶部不连着就砸掉
    //要用dfs很多次,还要保存visited,因为当和顶部不连着的时候要for 一遍全部变成0
    // 4^(m + n)
    class Solution1 {
        int m,n;
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};

        public int[] hitBricks(int[][] grid, int[][] hits) {
            if(grid.length == 0) return new int[]{};
            m = grid.length;
            n = grid[0].length;
            int idx = 0;
            int[] res = new int[hits.length];
            for(int[] h: hits) {
                res[idx++] = hit(h[0], h[1], grid);
            }
            return res;
        }

        private int hit(int x, int y, int[][] grid) {
            if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) return 0;
            grid[x][y] = 0;
            int cnt = 0;
            for(int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx == 0 ||xx < 0 || xx >= m || yy < 0 || yy >= n) continue;
                if(grid[xx][yy] == 0) continue;
                Set<int[]> visited = new HashSet<>();
                int tmp = dfs(xx, yy, grid, visited);
                // System.out.println(tmp);
                cnt += tmp == -1 ? 0 : tmp;
            }
            return cnt;
        }

        private int dfs(int x, int y, int[][] grid, Set<int[]> visited) {
            if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) return 0;
            if(x == 0) return -1;
            grid[x][y] = 0;
            visited.add(new int[]{x, y});
            int res = 1;
            for(int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                int tmp = dfs(xx, yy, grid, visited);
                if(tmp == -1) {
                    res = -1;
                    break;
                }
                res += tmp;
            }
            if(res == -1) {
                grid[x][y] = 1;
                for(int[] v: visited) {
                    grid[v[0]][v[1]] = 1;
                }
            }
            return res;
        }
    }


    // dfs o(mn)
    // reverse traversal dfs
    // 1. 先遍历hit,把hit到空(0)的变成-1, 把hit到zhuan(1)的先扣掉
    // 2. 把最top那层的连接到的砖都遍历一遍, mark成2, 后面要用到
    // 3. 从最后一个hit开始向前走, 如果hit的地方是0(即之前是有砖的1后来hit变化了之后变成0的地方) , 把它填回1,
    //    然后检查一下是不是和top 联通,
    //    如果 不和 top 联通, 那代表这里没有砖块会掉, 要么之前就被hit掉了 要么根本没有砖
    //    如果和 top 联通, 那就dfs找联通的路上为1的砖块全部都敲掉!!!
    // 可解 o(mn), 主要节约在找connected上, 只用找上下左右4块砖是不是 联通到top的
    class Solutionii {
        int m,n;
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};

        public int[] hitBricks(int[][] grid, int[][] hits) {
            if(grid.length == 0) return new int[]{};
            m = grid.length;
            n = grid[0].length;
            int idx = 0;
            int[] res = new int[hits.length];

            //o(len(hits))
            markAllHits(hits, grid);
            //o(mn)
            dfsTopLayer(grid);
            //o(mn)
            for(int i = hits.length - 1; i >= 0; i--) {
                //key, 对于－1或者2的，原来就是block或者连接到top的，跳过，只做＝＝0的
                if(grid[hits[i][0]][hits[i][1]] != 0) continue;
                if(!isConnected(hits[i][0], hits[i][1], grid)) {
                    grid[hits[i][0]][hits[i][1]] = 1;
                    res[i] = 0;
                } else {
                    //exclude itself
                    grid[hits[i][0]][hits[i][1]] = 1;
                    res[i] = search(hits[i][0], hits[i][1], grid) - 1;
                }
            }
            return res;
        }

        private void printGrid(int[][] grid) {
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    System.out.print(grid[i][j] + ",");
                }
                System.out.println();
            }
        }

        private boolean isConnected(int x ,int y, int[][] grid) {
            if(x < 0 || x >= m || y < 0 || y >= n) return false;
            if(x == 0) return true;
            for(int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx < 0 || xx >= m || yy < 0 || yy >= n) continue;
                if(grid[xx][yy] == 2) return true;
            }
            return false;
        }

        private int search(int x, int y, int[][] grid) {
            if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) return 0;
            grid[x][y] = 2;
            int res = 1;
            for(int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                res += search(xx, yy, grid);
            }
            return res;
        }

        private void markAllHits(int[][] hits, int[][] grid) {
            for(int[] hit: hits) {
                //if empty will become -1,
                //if hit brick will becom 0, empty
                grid[hit[0]][hit[1]]--;
            }
        }

        private void dfsTopLayer(int[][] grid) {
            for(int i = 0; i < n; i++) {
                if(grid[0][i] == 1) {
                    dfs(0, i, grid);
                }
            }
        }

        private void dfs(int x, int y, int[][] grid) {
            if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) return;
            grid[x][y] = 2;
            for(int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                dfs(xx, yy, grid);
            }
        }

    }
}
