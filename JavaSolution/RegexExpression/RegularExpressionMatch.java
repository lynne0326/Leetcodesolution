public class RegularExpressionMatch {
    public static boolean isMatch(String s, String p) {
        // write your code here
        if (s.length() == 0 && p.length() == 0) return true;
        if (s.length() == 0 || p.length() == 0) return false;
        if (p.length() >= 2 && p.charAt(1) == '*') {
            char cur = p.charAt(0);
            int i = 0;
            for (; i < s.length(); i++) {
                if (cur == '.' || s.charAt(i) == cur) {
                    if (isMatch(s.substring(i), p.substring(2))) {
                        return true;
                    }
                } else {
                    break;
                }
            }
            if (isMatch(s.substring(i), p.substring(2))) {
                return true;
            }
            return false;
        }
        if (p.charAt(0) != '.' && (s.charAt(0) != p.charAt(0))) return false;
        return isMatch(s.substring(1), p.substring(1));
    }

    public static void main(String[] args) {
//        System.out.println(isMatch("aab", "c*a*b"));
//        System.out.println(isMatch("aab", "a*b"));
//        System.out.println(isMatch("ab", ".*c"));
//        System.out.println(isMatch("acaabbaccbbacaabbbb"
//                ,"a*.*b*.*a*aa*a*"));
        System.out.println(isMatch("aaaaabcgdhdhjajajajawababaw"
                ,"..........................."));
    }
}
