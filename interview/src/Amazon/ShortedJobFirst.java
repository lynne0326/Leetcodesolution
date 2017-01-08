package Amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lingyanjiang on 16/12/19.
 */

public class ShortedJobFirst {

    public static float Solution(int[] req, int[] dur) {
        if (req == null || dur == null || req.length != dur.length)
            return 0;
        int index = 0, length = req.length;
        int waitTime = 0, curTime = 0;
        PriorityQueue<Process> pq = new PriorityQueue<>(10, new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                if (p1.process == p2.process)
                    return p1.arrive - p2.arrive;
                return p1.process - p2.process;
            }
        });
        while (!pq.isEmpty() || index < length) {
            if (!pq.isEmpty()) {
                Process cur = pq.poll();
                waitTime += curTime - cur.arrive;
                curTime += cur.process;
                while (index < length && curTime >= req[index])
                    pq.offer(new Process(req[index], dur[index++]));
            }
            else {
                pq.offer(new Process(req[index], dur[index]));
                curTime = req[index++];
            }
        }
        System.out.println((float) waitTime / length);
        return (float) waitTime / length;
    }

    public static float shortedJobFirst(int [] arrTime, int [] procTime) {
        if (arrTime == null || procTime == null ) {
            return 0;
        }
        PriorityQueue<Process> queue = new PriorityQueue<>(10, new Comparator<Process>(){
            @Override
            public int compare(Process p1, Process p2) {
               if (p1.process == p2.process) {
                   return p1.arrive - p2.arrive;
               }
               return p1.process - p2.process;
           }
        });

        int curTime = 0;
        int waitTime = 0;
        int index = 0;
        while (!queue.isEmpty() || index < arrTime.length) {
            if (!queue.isEmpty()) {
                Process cur = queue.poll();
                waitTime += curTime - cur.arrive;
                curTime += cur.process;

                for (int i = index; i < arrTime.length && arrTime[i] <= curTime; i++) {
                    queue.add(new Process(arrTime[i], procTime[i]));
                    index++;
                }
            } else {
                queue.add(new Process(arrTime[index], procTime[index]));
                index++;
            }
        }
        System.out.println((float)waitTime/arrTime.length);
        return (float)waitTime/arrTime.length;
    }

    public static void main(String[] args) {
        shortedJobFirst(new int []{0,1,4}, new int []{5,2,3});
        Solution(new int []{0,1,4}, new int []{5,2,3});
    }
}
