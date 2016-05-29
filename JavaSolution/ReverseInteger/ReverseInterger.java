/**
 * Created by lingyanjiang on 16/5/29.
 */
public class ReverseInterger {
    public int reverse(int x) {
        if(x == 0) return 0;
        int sign = 1;
        if(x < 0) sign = -1;
        long num = Math.abs((long)x), sum = 0L;
        while(num != 0) {
            sum = sum*10 + num%10;
            num /= 10;
        }
        if((sign > 0 && sum > Integer.MAX_VALUE) || (sign < 0 && sum < Integer.MIN_VALUE))
            return 0;
        return sign * (int)sum;
    }
}
