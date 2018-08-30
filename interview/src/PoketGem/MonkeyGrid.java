package PoketGem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by lingyanjiang on 17/3/1.
 */
public class MonkeyGrid {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return this.x * 31 + this.y;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point p = (Point) o;
                return p.x == this.x && p.y == this.y;
            }
            return false;
        }
    }

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    public int accessable(int k) {
        if (k < 0) return 0;
        Queue<Point> q = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        q.add(new Point(0, 0));
        int sum = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (visited.contains(cur)|| getDigit(cur.x) + getDigit(cur.y) > k) continue;
            visited.add(cur);
            for (int i = 0; i < 4; i++) {
                int xx = cur.x + dx[i];
                int yy = cur.y + dy[i];
                Point tmp = new Point(xx, yy);
                if (visited.contains(tmp) || getDigit(xx) + getDigit(yy) > k) continue;
                q.add(tmp);
            }
        }
        System.out.println(visited.size());
        return visited.size();
    }

    private int getDigit(int x) {
        x = Math.abs(x);
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        MonkeyGrid monkeyGrid = new MonkeyGrid();
        monkeyGrid.accessable(10);
    }
}
