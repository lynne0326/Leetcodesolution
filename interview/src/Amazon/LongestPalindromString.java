package Amazon;

/**
 * Created by lingyanjiang on 16/12/15.
 */
public class LongestPalindromString {
    //initiate n+1
    public String longestPalindrom(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return null;
        }
        String res = null;
        int longest = 0;
        int n = sentence.length();
        boolean [][] f = new boolean[n+1][n+1];
        for (int i = 0; i < n + 1; i++) {
            f[i][i] = true;
        }
        for (int j = 1; j < n + 1; j++) {
            for (int i = 1; i <= j ; i++) {
                if (sentence.charAt(i-1) == sentence.charAt(j-1) && (j - i <= 2|| f[i+1][j-1] )) {
                    f[i][j] = true;
                    if (j - i + 1 >= longest) {
                        longest = j - i + 1;
                        res = sentence.substring(i-1, j);
                    }
                }
            }
        }
        return res;
    }

    //initiate n
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        boolean [][] f = new boolean[n][n];
        int max = 0;
        String res = "";
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <=2 || f[i+1][j-1])) {
                    f[i][j] = true;
                    max = Math.max(max, j - i + 1);
                    if (j - i + 1 == max) {
                        res = s.substring(i, j+1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestPalindromString longestPalindromString = new LongestPalindromString();
        System.out.println(longestPalindromString.longestPalindrom("ababbbbb"));
    }

}
