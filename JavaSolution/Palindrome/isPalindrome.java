/**
 * Created by lingyanjiang on 16/5/29.
 */
public class isPalindrome {
    public static boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        long a = x;
        String s = String.valueOf(Math.abs(a));
        for(int i=0;i<Math.ceil(s.length()/2);i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }
}
