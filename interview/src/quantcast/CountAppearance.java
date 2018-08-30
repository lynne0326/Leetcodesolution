package quantcast;

import java.util.*;

/**
 * Created by lingyanjiang on 17/3/20.
 */
public class CountAppearance {
    public static List<Integer> countCharacter(String s, int n) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;

        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!map.containsKey(cur)) map.put(cur, new ArrayList<Integer>());
            map.get(cur).add(i);
        }

        for (char key: map.keySet()) {
            if (map.get(key).size() >= n) {
                res.addAll(map.get(key));
            }
        }
        return res;
    }


    public static void main(String[] args) {
        List<Integer> list = countCharacter("11122333", 4);
        for(int i:list) System.out.print(i + " ");
    }

}
