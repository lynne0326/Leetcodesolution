package Lyft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by lingyanjiang on 16/12/5.
 */
class Interval {
    double start;
    double end;
    String driverId;
    public Interval(double start, double end, String driverId) {
        this.start = start;
        this.end = end;
        this.driverId = driverId;
    }
}

public class FindMostDriversInterval {

    class Point {
        double time;
        boolean isStart;
        public Point(double time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }
    int mostDriversInterval(List<Interval> data) {
        List<Point> points = new ArrayList<>();
        for (Interval d: data) {
            points.add(new Point(d.start, true));
            points.add(new Point(d.end, false));
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(10, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.time == o2.time) {
                    if (o1.isStart) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
                return o1.time - o2.time <= 0 ? -1 : 1;
            }
        });

        int count = 0;
        int max = 0;
        double maxTime = 0;
        for (Point point:points) {
            pq.add(point);
        }
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (cur.isStart) {
                count++;
            } else {
                count--;
            }
            if (count >= max) {
                max = count;
                maxTime = cur.time;
            }
        }
        return (int)Math.floor(maxTime);
    }

    public static void main(String[] args) {
        List<Interval> data = new ArrayList<>();
        data.add(new Interval(0.5, 1.5, "1"));
        data.add(new Interval(1, 1.5, "1"));
        data.add(new Interval(1.25, 2.5, "1"));
        data.add(new Interval(2.4, 3, "1"));
        data.add(new Interval(2.4, 3.5, "1"));
        data.add(new Interval(1, 3, "1"));
        data.add(new Interval(1.25, 3.5, "1"));
        data.add(new Interval(0, 1.5, "1"));
        FindMostDriversInterval findMostDriversInterval = new FindMostDriversInterval();
        System.out.println(findMostDriversInterval.mostDriversInterval(data));
    }
}
