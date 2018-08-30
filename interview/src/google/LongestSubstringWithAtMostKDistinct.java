package google;

/**
 * Created by lingyanjiang on 17/2/18.
 */
public class LongestSubstringWithAtMostKDistinct {
    public String longestSubstringWithMostK(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return null;
        int distinct = 0;
        int [] chars = new int[256];
        int j = 0, max = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars[c] == 0) {
                if (distinct < k) {
                    distinct++;
                } else {
                    while(chars[s.charAt(j)] > 0 && j < i && distinct == k) {
                        chars[s.charAt(j)]--;
                        if (chars[s.charAt(j)] == 0){
                            distinct--;
                        }
                        j++;
                    }
                    distinct++;
                }
            }
            chars[c]++;
            max = Math.max(i - j + 1, max);
            res = i - j + 1 == max ? s.substring(j, i + 1) : res;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinct k = new LongestSubstringWithAtMostKDistinct();
        k.longestSubstringWithMostK("aabbbbbbccc", 2);
    }
}
