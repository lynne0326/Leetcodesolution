package Lyft;

/**
 * Created by lingyanjiang on 17/1/19.
 */
public class ProcessURL {
    public static void main(String[] args) {
        String s1 = "hot";
        String s2 = "hit";
        byte [] b = new byte[26];
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            res ^= s1.charAt(i);
            res ^= s2.charAt(i);
        }
        System.out.println((res & (res - 1)));
    }
}
