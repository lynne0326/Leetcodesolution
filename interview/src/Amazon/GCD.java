package Amazon;

/**
 * Created by lingyanjiang on 16/12/20.
 */
public class GCD {
    public static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(10,20));
    }
}
