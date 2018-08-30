import java.util.HashMap;
import java.util.Map;

/**
 * Created by lingyanjiang on 18/7/19.
 */

class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }

class Pair {
    double k;
    double b;

    public Pair (double k, double b) {
        this.k = k;
        this.b = b;
    }

    @Override
    public boolean equals(Object p) {
        return this.k == ((Pair)p).k && this.b == ((Pair)p).b;
    }

    @Override
    public int hashCode() {
        return (int)this.k * 103 + (int)this.b;
    }

}

public class MaxPointInAline {
    public int maxPoints(Point[] points) {
        // write your code here
        //(k=slope, b=interception)
        if (points == null || points.length == 0) return 0;
        Map<Pair, Integer> cnt = new HashMap<>();
        int max = 0;
        for (int i = 0; i < points.length ; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j].x - points[i].x;
                int dy = points[j].y - points[i].y;
                double k = dx == 0 ? Integer.MAX_VALUE : dy * 1.0 / dx;
                double b = dx == 0 ? points[j].x : points[j].y - k * points[j].x;
                Pair pair = new Pair(k, b);
                cnt.put(pair, cnt.getOrDefault(pair, 0) + 1);
                max = Math.max(cnt.get(pair), max);

            }
        }
        return max;
    }

    public static void main(String[] args) {
         new MaxPointInAline().maxPoints(new Point[]{new Point(1,2), new Point(3,6), new Point(0,0), new Point(1,3)});
    }
}
