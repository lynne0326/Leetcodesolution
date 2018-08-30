import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 17/1/14.
 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

//收尾工作要做好~~
public class InsertIntervals {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for (Interval interval:intervals) {
            if (newInterval == null || interval.end < newInterval.start) {
                res.add(interval);
            } else if (interval.start > newInterval.end) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res;
    }
}
