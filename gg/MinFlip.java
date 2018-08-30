/**
 * Created by lingyanjiang on 18/7/23.
 */
public class MinFlip {
    public int minFlip(int[] array) {
        if (array == null || array.length == 0) return 0;
        int[] cnts = new int[array.length];
        int cnt0 = 0;
        for (int i = 0 ; i < array.length; i++) {
            if (array[i] == 0) cnt0++;
            cnts[i] = cnt0;
        }
        int cnt1 = array.length - cnt0;
        int minFlip = Integer.MAX_VALUE;
        for (int i = 0; i < cnts.length; i++) {
            int flipLeft = i - cnts[i] + 1;
            int flipRight = cnt0 - cnts[i];
            minFlip = Math.min(minFlip, flipLeft + flipRight);
        }
        return minFlip;
    }
}
