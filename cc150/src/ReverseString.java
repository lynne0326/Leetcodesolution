/**
 * Created by lingyanjiang on 16/11/16.
 */
public class ReverseString {
    public static String reverse(String s) {
        char [] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(s.length() - i - 1);
        }
        return new String(c);
    }
    public static void main(String [] args) {
        String a = ReverseString.reverse("abc");
        System.out.println(a);
    }
}
