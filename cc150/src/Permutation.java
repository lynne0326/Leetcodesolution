import java.util.HashMap;

/**
 * Created by lingyanjiang on 16/11/16.
 */
public class Permutation {

    static int count = 0;

    static void permutations(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                count++;
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutations(rem, prefix + str.charAt(i));
            }
        }
    }


    public static boolean isPermutation(String a, String b) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
            } else {
                map.put(a.charAt(i), 1);
            }
        }

        for (int i = 0; i < b.length(); i++) {
            if (!map.containsKey(b.charAt(i))) {
                return false;
            }
            if (map.get(b.charAt(i)) - 1 < 0) {
                return false;
            } else {
                map.put(b.charAt(i), map.get(b.charAt(i)) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(Permutation.isPermutation("abcdf", "fbbacd"));
        permutations("abc", "");

    }
}
