package exercise;

/**
 * Created by lingyanjiang on 17/3/24.
 */
public class FindHole {
    static int [] dx = new int[]{-1,1,0,0};
    static int [] dy = new int[]{0,0,-1,1};

    public static char [][] findHole(char [][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (isHole(matrix, i, j)) {
                    matrix[i][j] = 'X';
                }
            }
        }
        return matrix;
    }

    private static boolean isHole(char [][] matrix, int x, int y) {
        if (x == 0 || x == matrix.length - 1 || y == 0 || y == matrix[x].length - 1) return false;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (matrix[xx][yy] == 'X') return false;
            if (matrix[xx][yy] - matrix[x][y] > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char [][] res = findHole(new char[][]{
                {'1','1','1','2'},
                {'1','9','1','2'},
                {'1','8','9','2'},
                {'1','2','3','4'}
        });

        for (int i = 0; i < res.length;i++) {
            for (int j = 0; j < res[i].length;j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
