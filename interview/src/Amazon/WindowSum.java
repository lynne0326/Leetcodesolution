package Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 16/12/16.
 */
public class WindowSum {
    public List<Integer> windowSum(int [] array, int k) {
        List<Integer> res = new ArrayList<>();

        if (array == null || array.length == 0 || k <= 0) {
            return res;
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                sum += array[i];
            } else {
                res.add(sum);
                sum = sum - array[i - k] + array[i];
            }
        }
        res.add(sum);
        return res;
    }

    public static void main(String[] args) {
        WindowSum windowSum = new WindowSum();
        windowSum.windowSum(new int[]{0,1,2,3}, 3);
    }
}
