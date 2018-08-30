package google;

/**
 * Created by lingyanjiang on 17/2/18.
 */
public class MaxSumInArray {
    public int maxSum(int [] array) {
        if (array == null || array.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            if (array[i] == max) {
                idx = i;
            }
        }
        int res = max;

        for (int i = 0; i < array.length; i++) {
            if (i == idx || i == idx - 1 || i == idx + 1) continue;
            res = Math.max(max + array[i], res);
        }
        return res;
    }

}
