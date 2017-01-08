import java.util.*;

/**
 * Created by lingyanjiang on 16/8/21.
 */
public class DicesSum {
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        List<Map.Entry<Integer, Double>> list = new ArrayList<Map.Entry<Integer, Double>>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int [] dies = new int[n];
        for (int i = 0; i < n - 1; i++) {
            dies[n - 1] = 1;
        }
        for (int i=0; i < n; i++) {
            for(int j = 1; j<7;j++) {
                dies[i] = j;
                int sum = 0;
                for(int num:dies) {
                    sum += num;
                }
                if(map.get(sum) != null) {
                    map.put(sum,map.get(sum) + 1);
                } else {
                    map.put(sum,1);
                }
            }
        }
        double base = 6*n - n;
        System.out.println(base);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
//            list.add(new AbstractMap.SimpleEntry<Integer, Double>(entry.getKey(), entry.getValue()/base));
            System.out.println(entry.getKey() + "," + entry.getValue() + "," + entry.getValue()/base);
        }
        return list;
    }

    public static void main(String [] args) {
        new DicesSum().dicesSum(2);
    }
}
