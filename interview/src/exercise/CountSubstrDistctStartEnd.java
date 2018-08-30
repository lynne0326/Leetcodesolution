package exercise;

/**
 * Created by lingyanjiang on 17/3/24.
 */
public class CountSubstrDistctStartEnd {

//    public int countSubstr(String s) {
//        if (s == null || s.length() == 0) return 0;
//        int count = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            int cur = s.charAt(i);
//            for (int j = i; j < s.length(); j++) {
//                if (cur == s.charAt(j)) count++;
//            }
//        }
//        return count;
//    }
    public static int countSubstr(String s) {
        int [] cnts = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i  < cnts.length; i++) {
            res += cnts[i] * (cnts[i] + 1) / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countSubstr("abcab"));
    }
}
