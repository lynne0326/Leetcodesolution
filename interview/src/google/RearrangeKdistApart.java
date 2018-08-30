package google;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by lingyanjiang on 17/2/24.
 */
public class RearrangeKdistApart {
    //贪心, 每次取最多的那个数,并且保证k distance
    //方法一: pq, key在于用waitlist set来存k范围内已访问过的元素
    //方法二:两个数组,valid数组用来纪录char[j]要valid所需要在的index
    class Node {
        char val;
        int count;
        public Node(char val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) return s;
        PriorityQueue<Node> pq = new PriorityQueue<>(10, new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                return n2.count - n1.count;
            }
        });
        Queue<Node> waitList = new LinkedList<>();
        int [] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                pq.add(new Node((char)i, map[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            sb.append(cur.val);
            cur.count--;
            waitList.add(cur);
            if (waitList.size() >= k) {
                Node next = waitList.poll();
                if (next.count > 0) pq.add(next);
            }
        }
        return sb.length() != s.length() ? "" : sb.toString();
    }

    // public String rearrangeString(String s, int k) {
    //     if (s == null || s.length() == 0) return s;
    //     int [] counts = new int[26];
    //     int [] valid = new int[26];//store position
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < s.length(); i++) {
    //         counts[s.charAt(i) - 'a']++;
    //     }

    //     for (int i = 0; i < s.length(); i++) {
    //         int candidate = getNext(counts, valid, i);
    //         if (candidate == -1) {
    //             return "";
    //         }
    //         sb.append((char) (candidate +'a'));
    //         counts[candidate]--;
    //         valid[candidate] = i + k;
    //     }
    //     return sb.toString();
    // }

    // private int getNext(int [] counts, int [] valid, int j) {
    //     int max = 0, res = -1;
    //     for (int i = 0; i < counts.length; i++) {
    //         if (counts[i] > max && j >= valid[i]) {
    //             res = i;
    //             max = counts[i];
    //         }
    //     }
    //     return res;
    // }
}
