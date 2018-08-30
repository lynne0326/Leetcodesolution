package Lyft;

import java.util.*;

/**
 * Created by lingyanjiang on 17/1/18.
 */
public class MeetingRooms {
    class Point {
        int time;
        boolean isStart;
        public Point(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }
    class Interval {
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public class Solution {

        public int minMeetingRooms(Interval [] intervals) {
            if (intervals == null || intervals.length == 0) return 0;
            List<Point> list = new ArrayList<>();
            for (Interval i: intervals) {
                list.add(new Point(i.start, true));
                list.add(new Point(i.end, false));
            }
            Collections.sort(list, new Comparator<Point>(){
                public int compare(Point p1, Point p2) {
                    if (p1.isStart && !p2.isStart) {
                        return -1;
                    } else if (!p1.isStart && p2.isStart) {
                        return 1;
                    } else {
                        return p1.time - p2.time;
                    }
                }
            });
            int max = 0;
            int count = 0;
            for (Point p: list) {
                if (p.isStart) count++;
                if (!p.isStart) count--;
                max = Math.max(count, max);
            }
            return max;
        }
    }
}
