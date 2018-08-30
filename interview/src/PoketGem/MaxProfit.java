package PoketGem;

/**
 * Created by lingyanjiang on 17/2/18.
 */
public class MaxProfit {


    public static int getMaxProfit(int n) {
        int max = 0;
        int dRemain = n % 5;
        int capacity = n * n;
        //calculate most diamond can fit
        max += n/5 == 0 ? 0: (n / 5) * 50;
        capacity -= max == 0 ? 0 : n / 5;
        if (dRemain > 2) {
            capacity--;
            max += dRemain * 10;
            dRemain = 0;
        }
        if (capacity <= n) {
            max += dRemain <= 2 ? 25 * capacity : 25 * (capacity - 1) + dRemain * 10;
            return max;
        } else {
            max += 25 * n;
            capacity -= n;
            if (capacity <= n/5) {
                max += dRemain <= 2 ? 25 * capacity : 25 * (capacity - 1) + dRemain * 10;
            } else {
                max += dRemain * 10 + n * 5;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getMaxProfit(4));
    }
}
