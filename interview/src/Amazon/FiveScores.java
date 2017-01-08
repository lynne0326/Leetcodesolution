package Amazon;

import java.util.*;

/**
 * Created by lingyanjiang on 16/12/22.
 */
class Record {
    int id;
    int score;
    public Record(int id, int score) {
        this.id = id;
        this.score = score;
    }
}

public class FiveScores {
    public static Map<Integer, Double> highestFiveScores(List<Record> scores) {
        Map<Integer, Double> map = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>>  tmp = new HashMap<>();
        for (Record record: scores) {
            int id = record.id;
            int score = record.score;
            if (!tmp.containsKey(id)) {
                tmp.put(id, new PriorityQueue<Integer>(5, new Comparator<Integer>(){
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                }));
            }
            PriorityQueue<Integer> queue = tmp.get(id);
            queue.add(score);
        }
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry: tmp.entrySet()) {
            int key = entry.getKey();
            PriorityQueue<Integer> q = entry.getValue();
            int count = 0;
            int sum = 0;
            while (!q.isEmpty() && count < 5) {
                sum += q.poll();
                count++;
            }
            System.out.println(sum);
            map.put(key, (double)sum/(count));
        }
        return map;
    }

    public static void main(String[] args) {
        List<Record> scores = new ArrayList<>();
        scores.add(new Record(1, 10));
        scores.add(new Record(1, 60));

        scores.add(new Record(1, 90));
        scores.add(new Record(1, 80));
        scores.add(new Record(1, 90));
        scores.add(new Record(1, 70));
        scores.add(new Record(1, 90));

        scores.add(new Record(2, 80));
        scores.add(new Record(2, 60));
        scores.add(new Record(2, 100));
        scores.add(new Record(2, 80));
        scores.add(new Record(2, 90));
        scores.add(new Record(2, 70));
        scores.add(new Record(2, 65));
        Map<Integer, Double> map = highestFiveScores(scores);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}
