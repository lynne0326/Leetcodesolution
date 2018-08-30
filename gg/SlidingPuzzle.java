import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by lingyanjiang on 18/8/26.
 */
public class SlidingPuzzle {

    // bfs, mn!
    // Time Complexity: O(R * C * (R * C)!)O(R∗C∗(R∗C)!),
    // where R, CR,C are the number of rows and columns in board.
    // There are O((R * C)!)O((R∗C)!) possible board states.
    class Solution {
        int m,n;
        public int slidingPuzzle(int[][] board) {
            if(board.length == 0) return 0;
            m = board.length;
            n = board[0].length;
            String initialState = toString(board);
            Queue<String> q = new LinkedList<>();
            String target = "123450";
            q.offer(initialState);
            int res = 0;
            Set<String> visited = new HashSet<>();

            int[] dir = new int[]{-1,1,-n,n};
            while(!q.isEmpty()) {
                int size = q.size();
                for(int i = 0; i < size; i++) {
                    String cur = q.poll();
                    if(visited.contains(cur)) continue;
                    if(cur.equals(target)) return res;
                    visited.add(cur);
                    // bfs possible swap
                    int zero = cur.indexOf("0");
                    char[] chars = cur.toCharArray();
                    for(int k = 0; k < dir.length; k++) {
                        int idx = zero + dir[k];
                        if(idx < 0 || idx >= m * n || idx == 3 && zero == 2 || zero == 3 && idx == 2) continue;
                        chars[zero] = chars[idx];
                        chars[idx] = '0';
                        q.offer(new String(chars));
                        chars[idx] = chars[zero];
                        chars[zero] = '0';
                    }
                }
                res++;
            }
            return -1;
        }

        private String toString(int[][] board) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
            }
            return sb.toString();
        }
    }
}
