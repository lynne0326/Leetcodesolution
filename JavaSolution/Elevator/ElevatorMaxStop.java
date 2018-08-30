import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by lingyanjiang on 17/3/19.
 */
public class ElevatorMaxStop {
    public static int maxStopTime(int[] weight, int[] stops, int maxSize, int maxWgt) {
        Queue<Integer> wq = new LinkedList<>();
        Queue<Integer> sq = new LinkedList<>();

        for (int i = 0; i < weight.length; i++) {
            wq.offer(weight[i]);
            sq.offer(stops[i]);
        }

        int curWgt = 0;
        int curSize = 0;
        int res = 0;

        while (!wq.isEmpty()) {
            Set<Integer> curStops = new HashSet<>();
            while (curWgt <= maxWgt && curSize <= maxSize && !wq.isEmpty()) {
                if (curSize == maxSize || curWgt + wq.peek() > maxWgt) break;
                curWgt += wq.poll();
                curSize += 1;
                curStops.add(sq.poll());
            }
            res += curStops.size() + 1;
            curWgt = 0;
            curSize = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = maxStopTime(new int[]{60,80,40}, new int[]{2,3,5}, 2, 200);
        System.out.println(res);
//        try {
//            String a = "10:00";
//            String b = "13:21";
//            SimpleDateFormat f = new SimpleDateFormat("HH:mm");
//            Date d = f.parse(a);
//            Date d2 = f.parse(b);
//            int minutes = (int) ((d2.getTime() - d.getTime()) / 1000 / 60);
//            int total = 0;
//            if (minutes < 60) total = minutes * 3 + 2;
//            total = 2 + 3 + (minutes / 60 - 1) * 4 + (minutes % 60 > 0 ? 4 : 0);
//            System.out.println(total);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

}
