package Amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lingyanjiang on 16/12/20.
 */

public class FindKNearest {
    public Point[] Solution(Point[] array, final Point origin, int k) {
        if (array == null) {
            return null;
        }
        PriorityQueue<Point> queue = new PriorityQueue<>(k, new Comparator<Point>(){
            @Override
            public int compare(Point point1, Point point2) {
                return (int) (calcDistance(point1, origin) - calcDistance(point2, origin));
            }
        });
        for (int i = 0; i <array.length; i++) {
            queue.add(array[i]);
        }
        int count = 0;
        Point [] points = new Point[k];
        while (count < k - 1) {
            points[count++] = queue.poll();
        }
        return points;
    }

    private double calcDistance(Point point, Point origin) {
        return Math.sqrt(Math.pow(point.row - origin.row,2) + Math.pow(point.col - origin.col,2));
    }

    public static void main(String[] args) {
        FindKNearest fdk = new FindKNearest();
    }
}
