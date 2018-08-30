package PoketGem;

import java.util.*;

/**
 * Created by lingyanjiang on 17/2/24.
 */
public class MostFrequentK {


    //bucket sort O(n) time, O(n) space
    public List<Integer> mostFrequentKBucket(int [] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || k == 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        //store counts
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(map.get(nums[i]), max);
        }

        //store into buckets
        List [] buckets = new List[max+ 1];
        for (int key:map.keySet()) {
            int val = map.get(key);
            if (buckets[val] == null) {
                buckets[val] = new ArrayList();
            }
            buckets[val].add(key);
        }

        //以下方法“最frequent k个”可以多余k,有duplicate
        // for (int i = buckets.length - 1; i >= 0; i--) {
        // 	if (buckets[i] == null) continue;
        // 	res.addAll(buckets[i]);
        // 	k--;
        // 	if (k == 0) break;
        // }

        //以下方法是“k个最frequent”,只有k
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) continue;
            for (Object num : buckets[i]) {
                res.add((int)num);
                k--;
                if (k == 0) return res;
            }
        }
        return res;
    }

    //method 2 max Heap o(nlogn) space o(n)
    public List<Integer> mostFrequentKMaxHeap(int [] nums, int k) {
        List<Integer> res = new ArrayList();
        if (nums == null || k == 0) return res;
        //store occurence counts for each elements in nums O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //next O(nlogn) 除了peek是o1，插入和删除都是logn
        PriorityQueue<int []> pq = new PriorityQueue<>(10, new Comparator<int []>(){
            public int compare(int [] c1, int [] c2) {
                //reverse order, max heap
                return c2[1] - c1[1];
            }
        });
        //Iterate through map and put into priorityQueue
        for (int key: map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
        }

        //pop k most frequent
        while (k > 0 && !pq.isEmpty()) {
            res.add(pq.poll()[0]);
            k--;
        }
        return res;
    }

    //Min heap, 最小堆 keep track of most frequent k elements, kick out the entry with smallest value (counts)
    //time O(nlogk) space O(n)
    public List<Integer> mostFrequentKMinHeap(int [] nums, int k) {
        List<Integer> res = new ArrayList();
        if (nums == null || k == 0) return res;
        //store occurence counts for each elements in nums O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //min Heap,
        PriorityQueue<int []> pq = new PriorityQueue<>(10, new Comparator<int []>(){
            public int compare(int [] c1, int [] c2) {
                return c1[1] - c2[1];
            }
        });


        for (int key: map.keySet()) {
            int val = map.get(key);
            pq.add(new int[]{key, map.get(key)});
            //let size less than k
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll()[0]);
        }
        //from small to large output
        Collections.reverse(res);
        return res;
    }

}
