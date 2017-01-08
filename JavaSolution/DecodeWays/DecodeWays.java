/**
 * Created by lingyanjiang on 16/12/31.
 */
public class DecodeWays {
    //坑: 判断valid的时候01, 02, 0开头的要return false

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int [] f = new int [s.length()+1];
        f[0] = f[1] = 1;
        if (s.charAt(0) - '0' == 0) {
            return 0;
        }
        for (int i = 2; i < f.length; i++) {
            if (s.charAt(i-1) - '0' != 0) {
                f[i] += f[i-1];
            }
            if (valid(s, i)) {
                f[i] += f[i-2];
            }
        }
        return f[f.length -1];
    }

    private boolean valid(String s, int i) {
        int t = s.charAt(i-1) - '0';
        int st = s.charAt(i-2) - '0';
        if (st == 0) {
            return false;
        }
        if (st*10 + t <= 26 && st*10 + t > 0 ) {
            return true;
        }
        return false;
    }
}
