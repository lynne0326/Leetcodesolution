package google;

/**
 * Created by lingyanjiang on 17/2/21.
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int j = num.length() - 1;
        for (int i = 0; i <= j; i++) {
            if ("  00 11 88 696". indexOf(num.charAt(i) + "" + num.charAt(j)) == -1) return false;
            j--;
        }
        return true;
    }

}
