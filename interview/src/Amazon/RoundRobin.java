package Amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lingyanjiang on 16/12/16.
 */

class Process {
    int arrive;
    int process;
    public Process(int arrive, int process) {
        this.arrive = arrive;
        this.process = process;
    }
}

public class RoundRobin {
    public float RoundRobin(int [] arrTime, int [] procTime, int q) {
        int curTime = 0;
        int totalWaitTime = 0;
        int index = 0;

        Queue<Process> queue = new LinkedList<>();

        while (index < arrTime.length || !queue.isEmpty()) {
            if (queue.isEmpty()) {
                queue.add(new Process(arrTime[index], procTime[index]));
                index++;
            } else {
                Process curProcess = queue.poll();
                totalWaitTime += (curTime - curProcess.arrive > 0 ? curTime - curProcess.arrive : 0);
                curTime += Math.min(curProcess.process, q);
                for (int i = index; i < arrTime.length && arrTime[i] <= curTime; i++) {
                    queue.add(new Process(arrTime[i],procTime[i]));
                    index++;
                }
                if (curProcess.process > q) {
                    queue.add(new Process(curTime, curProcess.process - q));
                }
            }
        }
        System.out.println((((float) totalWaitTime)/arrTime.length));
        return ((float) totalWaitTime)/arrTime.length;
    }

    public static void main(String[] args) {
        RoundRobin rb = new RoundRobin();
        rb.RoundRobin(new int []{0,1,4}, new int []{5,2,3}, 3);
    }
}
