package google;

/**
 * Created by lingyanjiang on 17/2/19.
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        //找到第一个不是palindrome的indx, longest preffix = longest suffix
        int j = 0;
        for (int i = s.length(); i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        //如果j等于s的长度直接返回s
        if (j == s.length()) {
            return s;
        }
        //suffix等于不匹配的后缀,j之后的都不匹配
        String suffix = s.substring(j);
        //reverse得到preffix
        String preffix = new StringBuilder(suffix).reverse().toString();
        //recursively find 中间的最长的palindrome
        String mid = shortestPalindrome(s.substring(0, j));
        return preffix + mid + suffix;
    }
}
