import java.util.PriorityQueue;

/**
 * Created by lingyanjiang on 18/8/27.
 */
public class MinMaxGasStation {

//    Minimize Max Distance to Gas Station. 正常可以想到pq，
// 正确做法是binary search，在区间范围0-10^8做bs枚举interval的possible范围,
// 每次对一个mid遍历stations中的gaps看每个区间gaps中能插入多少个stations，
// 如果小于k，说明区间取得太大了，根本没得插，缩小区间范围，把end update，
// 反之start update， 凭空想容易错，最好举例子就容易什么update什么了。O(NlogW),  W = 10^14 W~[10^-6,10^8].
    public double minmaxGasDist(int[] stations, int K) {
        double start = 0;
        double end = Math.pow(10, 8);
        while(end - start > Math.pow(10, -6)) {
            double mid = start + (end - start) / 2;
            double prev = stations[0];
            int cnt = 0;
            for(int i = 1; i < stations.length; i++) {
                cnt += (stations[i] - prev) / mid;
                prev = stations[i];
            }
            if(cnt <= K) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }

    //heap solutions O(KlogN), O(N)
    public double minmaxGasDistHeap(int[] stations, int K) {
        int N = stations.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) ->
                (double)b[0]/b[1] < (double)a[0]/a[1] ? -1 : 1);
        for (int i = 0; i < N-1; ++i)
            pq.add(new int[]{stations[i+1] - stations[i], 1});

        for (int k = 0; k < K; ++k) {
            int[] node = pq.poll();
            node[1]++;
            pq.add(node);
        }

        int[] node = pq.poll();
        return (double)node[0] / node[1];
    }
}
