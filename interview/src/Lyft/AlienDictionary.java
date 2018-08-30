package Lyft;

import java.util.*;

/**
 * Created by lingyanjiang on 17/1/12.
 */
public class AlienDictionary {

    public static List<Character> AlienDictionary(List<String> dictionary) {
        List<Character> res = new ArrayList<>();
        Map<Character, Integer> counts = new HashMap<>();
        Map<Character, List<Character>> children = new HashMap<>();

        for (int k = 0; k < dictionary.size() - 1; k++) {
            String s1 = dictionary.get(k);
            String s2 = dictionary.get(k + 1);
            int min = Math.min(s1.length(), s2.length());
            for (int i = 0; i < min; i++) {
                char parent = s1.charAt(i);
                char child = s2.charAt(i);
                //put into childre map
                if (!children.containsKey(parent)) {
                    children.put(parent, new ArrayList<Character>());
                }

                //put into counts map
                if (!counts.containsKey(child)) {
                    counts.put(child, 0);
                }

                if (!counts.containsKey(parent)) {
                    counts.put(parent, 0);
                }
                if (child != parent) {
                    children.get(parent).add(child);
                    counts.put(child, counts.get(child) + 1);
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        //put 0 counts, root to q
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }
        while (!q.isEmpty()) {
            char cur = q.poll();
            res.add(cur);
            List<Character> list = children.get(cur);
            if (list != null) {
                for (char c : list) {
                    counts.put(c, counts.get(c) - 1);
                    if (counts.get(c) == 0) {
                        q.add(c);
                    }
                }
            }
        }
        return res.size() == counts.size() ? res : null;
    }

    public static void main(String[] args) {
        String[] t = new String[]{
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };
        List<String> tmp = Arrays.asList(t);
        List<Character> res = AlienDictionary(tmp);
        for (char r : res) System.out.println(r);
    }
}
