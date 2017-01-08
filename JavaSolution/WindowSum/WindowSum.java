import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lingyanjiang on 16/11/15.
 */
public class WindowSum {
    public static List<Integer> GetSum(List<Integer> A, int k) {
        List<Integer> rs = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);

            if (i >= k - 1) {
                if (i - k > -1) {
                    sum -= A.get(i - k);
                }
                rs.add(sum);
            }
        }
        return rs;
    }

    public static void main(String [] args) {
        Integer [] array = new Integer[] {1,2,3,4,5,6,7};
        List<Integer> list = new ArrayList<Integer>(array.length);
        Collections.addAll(list, array);
        List<Integer> ls = WindowSum.GetSum(list,3);
        System.out.println(ls);
    }
}
