package Amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lingyanjiang on 16/12/18.
 */
class Point {
    int row;
    int col;

    public Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Maze {

    public boolean canFind(int [][] matrix) {
        int [] dx = new int[]{0,1};
        int [] dy = new int[]{1,0};

        if (matrix == null || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<Point> q = new LinkedList<>();
        if (matrix[0][0] == -1) {
            return false;
        }
        q.add(new Point(0,0));
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int row = cur.row;
            int col = cur.col;
            int val = matrix[row][col];

            if (val == 9) {
                return true;
            }
            if (val == 0) {
                for (int i = 0; i < 2; i++) {
                    int newRow = row + dx[i];
                    int newCol = col + dy[i];
                    if (newRow < m && newCol < n && newRow >= 0 && newCol >= 0) {
                        q.add(new Point(newRow, newCol));
                    }
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Maze m = new Maze();
        boolean res = m.canFind(new int[][]{
                {0,0,1,0},
                {0,1,9,0},
                {1,1,0,0},
        });
        System.out.println(res);
    }

}