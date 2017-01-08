import java.util.HashSet;

/**
 * Created by lingyanjiang on 16/11/16.
 */
public class UniqueCharacter {

    public static boolean isUnique(String s) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            } else {
                set.add(s.charAt(i));
            }
        }
        return true;
    }
    public static void main(String [] args) {
        System.out.println(UniqueCharacter.isUnique("abcdr"));
    }
}
