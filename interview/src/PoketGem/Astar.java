package PoketGem;

/**
 * Created by lingyanjiang on 17/3/6.
 */
import java.util.*;
class Node {
    int x;
    int y;
    int gcost;
    int hcost;
    Node prev;
    public Node(int x , int y, Node prev) {
        this.x = x;
        this.y = y;
        this.hcost = -1;
        this.gcost = -1;
        this.prev = prev;
    }

    @Override
    public int hashCode() {
        return this.x * 31 + this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Node) {
            return this.x == ((Node) o).x && this.y == ((Node) o).y;
        }
        return false;
    }
}

public class Astar {
    //blank is 0, block is 1, source is 2, target is 3
    int [] dx = new int[]{-1,1,0,0};
    int [] dy = new int[]{0,0,-1,1};

    public List<Node> getPath(int [][] matrix) {
        List<Node> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        Node start = null;
        Node end = null;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 2) {
                    start = new Node(i, j, null);
                }
                if (matrix[i][j] == 3) {
                    end = new Node(i, j, null);
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        boolean [][] visited = new boolean[matrix.length][matrix[0].length];
        q.add(start);

        while (q.isEmpty()) {
            Node cur = q.poll();
            if (visited[cur.x][cur.y]) continue;
            if (cur.equals(end)) {
                end = cur;
                break;
            }
            visited[cur.x][cur.y] = true;
            int min = Integer.MAX_VALUE;
            Node next = null;
            for (int i = 0; i < 4; i++) {
                int xx = cur.x + dx[i];
                int yy = cur.y + dy[i];
                if (xx < 0 || xx >= matrix.length  || yy < 0 || yy >= matrix[0].length || matrix[xx][yy] == 1 || visited[xx][yy]) continue;
                int curGcost = cur.gcost + 1;
                int hCost = getHcost(xx, yy, end);
                if (curGcost + hCost < min) {
                    min = curGcost + hCost;
                    next = new Node(xx, yy, cur);
                }
            }
            if (next != null) {
                q.add(next);
            }
        }

        while (end != null) {
            res.add(end);
            end = end.prev;
        }
        return res;
    }

    private int getHcost(int x, int y, Node end) {
        return Math.abs(end.x - x) + Math.abs(end.y - y);
    }

    public static void main(String[] args) {

    }
}
