package google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by lingyanjiang on 17/2/19.
 * 经典算法sweep line, 不停更新candidate, 先按x sort
 * 然后排除掉所有distance >= min 的点
 * 然后再在+-y范围内找
 */
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double distance(Point p) {
        return (p.x - this.x)*(p.x - this.x) + (p.y - this.y)*(p.y - this.y);
    }
}

public class ClosePair {

    public static Point[] closestPair(Point[] points) {
        Point[] closestPair = new Point[2];

        //When we start the min distance is the infinity
        double crtMinDist = Double.POSITIVE_INFINITY;

        //Get the points and sort them
        Point[] sorted = Arrays.copyOf(points, points.length);
        Arrays.sort(sorted, HORIZONTAL_COMPARATOR);

        //When we start the left most candidate is the first one
        int leftMostCandidateIndex = 0;

        //Vertically sorted set of candidates
        SortedSet<Point> candidates = new TreeSet<Point>(VERTICAL_COMPARATOR);

        //For each point from left to right
        for (Point current : sorted) {
            //Shrink the candidates
            while ( current.x - sorted[leftMostCandidateIndex].x >= crtMinDist){
                candidates.remove(sorted[leftMostCandidateIndex]);
                leftMostCandidateIndex++;
            }

            //Compute the y head and the y tail of the candidates set
            Point head = new Point(current.x, (int) (current.y - crtMinDist));
            Point tail = new Point(current.x, (int) (current.y + crtMinDist));

            //We take only the interesting candidates in the y axis
            for (Point point : candidates.subSet(head, tail)) {
                double distance = current.distance(point);

                //Simple min computation
                if (distance < crtMinDist) {
                    crtMinDist = distance;

                    closestPair[0] = current;
                    closestPair[1] = point;
                }
            }

            //The current point is now a candidate
            candidates.add(current);
        }

        return closestPair;
    }

    private static final Comparator<Point> VERTICAL_COMPARATOR = new Comparator<Point>() {
        @Override
        public int compare(Point a, Point b) {
            if (a.y < b.y) {
                return -1;
            }
            if (a.y > b.y) {
                return 1;
            }
            if (a.x < b.x) {
                return -1;
            }
            if (a.x > b.x) {
                return 1;
            }
            return 0;
        }
    };

    private static final Comparator<Point> HORIZONTAL_COMPARATOR = new Comparator<Point>() {
        @Override
        public int compare(Point a, Point b) {
            if (a.x < b.x) {
                return -1;
            }
            if (a.x > b.x) {
                return 1;
            }
            if (a.y < b.y) {
                return -1;
            }
            if (a.y > b.y) {
                return 1;
            }
            return 0;
        }
    };
}
