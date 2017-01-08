public class LongestPalindromString {
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        char [] chars = s.toCharArray();
        while (l <= r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    int max = Integer.MIN_VALUE;
    String res = "";
    public String longestPalindrome(String s) {
        dfs(s);
        return res;
    }

    private void dfs(String s) {

        if (isPalindrome(s)) {
            if (s.length() > res.length()) {
                res = s;
            }
        }
        if (s.length() == 0) {
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i+1);
            if (isPalindrome(sub)) {
                if (sub.length() > res.length()) {
                    res = sub;
                }
            }
        }
        dfs(s.substring(1));

    }

    public static void main(String[] args) {
        LongestPalindromString sb = new LongestPalindromString();
        sb.longestPalindrome("eabcb");
    }
}