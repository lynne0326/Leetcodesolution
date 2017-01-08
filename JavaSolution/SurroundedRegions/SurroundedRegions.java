import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by lingyanjiang on 16/12/27.
 */
public class SurroundedRegions {
    //bfs AC solution
    class Node {
        int row;
        int col;
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public boolean equals(Object node) {
            if (node instanceof Node) {
                Node cur = (Node) node;
                if (this.row == cur.row && this.col == cur.col) {
                    return true;
                }
            }
            return false;
        }
        //equals和hashcode方法一定要写不然不能过
        @Override
        public int hashCode(){
            final int prime = 31;
            int result = 1;
            result = prime * result + this.row;
            result = prime * result + this.col;
            return result;
        }

    }

    public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    flip(board, i, j);
                }
            }
        }
    }

    private void flip(char [][] board, int x, int y) {
        //用hashset来装visited过的node
        int [] dx = new int []{-1,1,0,0};
        int [] dy = new int []{0,0,1,-1};
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (visited.contains(cur)) {
                continue;
            }
            int row = cur.row;
            int col = cur.col;
            for (int i = 0; i < 4; i++) {
                int nx = row + dx[i];
                int ny = col + dy[i];
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[nx].length) {
                    if (board[nx][ny] == 'O') {
                        q.add(new Node(nx,ny));
                    }
                } else {
                    return;
                }
            }
            visited.add(cur);
        }
        for (Node node: visited) {
            board[node.row][node.col] = 'X';
        }
    }
}
