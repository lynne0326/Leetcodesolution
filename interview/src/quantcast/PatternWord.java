package quantcast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 17/3/24.
 */
public class PatternWord {
    public static List<Integer> findPattern(String s, int n) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        int slow = 0;
        int fast = 0;
        while (fast < s.length()) {
            while (fast < s.length() && s.charAt(fast) == s.charAt(slow)) {
                fast++;
            }
            if (fast - slow >= n) {
                for (int i = slow; i <= fast - n; i++) {
                    res.add(i);
                }
            }
            slow = fast;
            fast++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = findPattern("866666", 5);
        for (int r : res) {
            System.out.println(r);
        }
    }
}
