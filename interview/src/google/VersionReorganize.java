package google;

/**
 * Created by lingyanjiang on 17/2/9.
 */
public class VersionReorganize {
    public static String solution(String s, int k) {
        if (s == null || s.length() == 0) return "";
        char [] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '-') continue;
            sb.append(chars[i]);
            count++;
            //坑在这,当count = 0 到第一个时不能加-
            if (count == k && i != 0) {
                sb.append("-");
                count = 0;
            }
        }
        return sb.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        String res = VersionReorganize.solution("2-4A0r7-4k", 9);
        System.out.println(res);
    }
}
