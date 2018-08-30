package PoketGem;

import java.util.PriorityQueue;

/**
 * Created by lingyanjiang on 17/2/22.
 */
public class MinCostCombineRod {
    //We need to combine the smaller rod as earlier as possible,
    //Because the weight of rope will appear in the next costs till the end
    //So here we can use greedy algorithm, every time we combine the smallest two rope
    public static int minCostCombineRod(int[] rods) {
        if (rods == null || rods.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: rods) {
            pq.offer(num);
        }
        int total = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int tmp = first + second;
            pq.offer(tmp);
            total += tmp;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] rods = {5,4,3,1,2};
        //1,2 -- 3,3,4,5 . 3
        //3,3 -- 4,5,6 . 6
        //4,5 -- 9,6 . 9
        //9,6 -- 15 . 15
        //3 + 6 + 9 + 15 = 33
        System.out.println(minCostCombineRod(rods));
    }
}
