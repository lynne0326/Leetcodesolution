import java.util.*;

/**
 * Created by lingyanjiang on 18/8/3.
 */
public class SequenceReconstruction {

    //正确做法是用两个map,可以避免tle
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for(int[] seq: seqs) {
            if(seq.length == 1) {
                if(!map.containsKey(seq[0])) {
                    map.put(seq[0], new HashSet<>());
                    indegree.put(seq[0], 0);
                }
            } else {
                for(int i = 0; i < seq.length - 1; i++) {
                    if(!map.containsKey(seq[i])) {
                        map.put(seq[i], new HashSet<>());
                        indegree.put(seq[i], 0);
                    }

                    if(!map.containsKey(seq[i + 1])) {
                        map.put(seq[i + 1], new HashSet<>());
                        indegree.put(seq[i + 1], 0);
                    }

                    if(map.get(seq[i]).add(seq[i + 1])) {
                        indegree.put(seq[i + 1], indegree.get(seq[i + 1]) + 1);
                    }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
            if(entry.getValue() == 0) queue.offer(entry.getKey());
        }

        int index = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(size > 1) return false;
            int curr = queue.poll();
            if(index == org.length || curr != org[index++]) return false;
            for(int next: map.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if(indegree.get(next) == 0) queue.offer(next);
            }
        }
        return index == org.length && index == map.size();
    }

    //TLE
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> cnts = new HashMap<>();
        for (List<Integer> li:seqs) {
            if (li.size() == 1) {
                map.putIfAbsent(li.get(0), new HashSet<>());
            }
            for (int i = 0; i < li.size() - 1; i++) {
                int from = li.get(i);
                int to = li.get(i + 1);
                if (!map.containsKey(from)) map.put(from, new HashSet<>());
                if (!map.containsKey(to)) map.put(to, new HashSet<>());
                map.get(to).add(from);
            }
        }

        //如果seq不包含所有seq有的数字那肯定不是
        if (org.length != map.size()) return false;
        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
            if (entry.getValue().size() == 0) q.offer(entry.getKey());
        }
        int idx = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (size > 1) return false;
            int cur = q.poll();
            if (cur != org[idx]) return false;
            //注意啊，因为后面要iterate map看空集，所以现在要及时删掉这个空集
            map.remove(cur);
            for (Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
                if (entry.getValue().contains(cur)) {
                    entry.getValue().remove(cur);
                }
                if (entry.getValue().isEmpty()) {
                    q.offer(entry.getKey());
                }
            }
            idx++;
        }
        //最后应该判断idx是不是走到底
        return idx == org.length;
    }
}
