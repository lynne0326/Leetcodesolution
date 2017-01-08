import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lingyanjiang on 16/12/27.
 */
public class PerfectSqure {
    //bfs, memory limit
    class Node {
        int val;
        int diff;
        int level;
        public Node(int val, int diff, int level) {
            this.val = val;
            this.diff = diff;
            this.level = level;
        }
    }

    private int findLargest(int num) {
        return (int)Math.sqrt(num);
    }

    public int numSquares(int n) {
        // Write your code here
        if (n < 0) {
            return -1;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, n, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.diff == 0) {
                return cur.level;
            }
            int num = findLargest(cur.diff);
            for (int i = 1; i <= num; i++) {
                q.add(new Node(num, cur.diff - i*i, cur.level + 1));
            }
        }
        return -1;
    }
    //dp
    public int numSquares2(int n) {
        if (n <= 0) {
            return 0;
        }

        int [] f = new int[n+1];
        Arrays.fill(f, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; ++i) {
            f[i * i] = 1;
        }

        for (int i = 0; i < n+1; i++) {
            for (int j = 1; i+j*j < n+1; j++) {
                f[i+j*j] = Math.min(f[i]+1, f[i+j*j]);
            }
        }
        return f[n];
    }

}
