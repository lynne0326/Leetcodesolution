package google;

import java.util.*;

/**
 * Created by lingyanjiang on 17/2/19.
 */
public class OilStation {

    class Interval {
        double start;
        double end;
        double len;

        public Interval(double start, double end) {
            this.start = start;
            this.end = end;
            this.len = this.end - this.start;
        }
    }

    public List<Double>  minMaxDist(List<Double> positions, int k) {
        List<Double> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>(k, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.len == o2.len) return 0;
                return o1.len > o2.len ? -1 : 1;
            }
        });
        for (int i = 0; i < positions.size() - 1; i++) {
            pq.add(new Interval(positions.get(i), positions.get(i+1)));
        }
        while (k > 0 && !pq.isEmpty()) {
            Interval cur = pq.poll();
            double curLen = cur.len;
            int count = 1;
            //pq is empty for only one interval
            while (k > 0 && (pq.isEmpty() || curLen/count >= pq.peek().len)) {
                count++;
                k--;
            }
            double updateLen = curLen/count;
            for (int j = 0; j < count; j++) {
                pq.add(new Interval(cur.start + j * updateLen, cur.start + (j + 1) * updateLen));
                if (j != count - 1) {
                    res.add(cur.start + (j + 1) * updateLen);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Double [] d = new Double[]{0d,5d,6d,7d,8d};
        List<Double> test = Arrays.asList(d);
        OilStation oilStation = new OilStation();
        for (double l :oilStation.minMaxDist(test, 2)) {
            System.out.println(l);
        }
    }

}

