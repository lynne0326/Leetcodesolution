package PoketGem;

/**
 * Created by lingyanjiang on 17/2/22.
 */
public class LongestRepeatingCharReplace {
    public int longestCharReplacement(String s, int k) {
        int max = 0;
        int start = 0;
        int res = 0;
        char [] map = new char[256];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            max = Math.max(max, map[s.charAt(i)]);
            while (i - start + 1 - max > k) {
                map[s.charAt(start)]--;
                start++;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
//        "AABABBA"   k = 1     4
//        s = "ABAB", k = 2     4
    }
}
