import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
    int min = Integer.MAX_VALUE;

    private Set<Character> cadt(int i, Set<String> dict) {
        Set<Character> set = new HashSet<Character>();
        for (String dt:dict) {
            set.add(dt.charAt(i));
        }
        return set;
    }
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start.equals(end)) {
            return 0;
        }
        ArrayList<String> list = new ArrayList<String>();
        Set<String> visited = new HashSet<String>();
        dict.add(start);
        dict.add(end);
        list.add(start);
        // List<List<String>> res = new ArrayList<List<String>>();
        helper(start, end, dict, list, visited);
        return min;
    }

    private void helper(String s, String e, Set<String> dict, List<String> tmp, Set<String> visited) {
        if (s.equals(e)) {
            tmp.add(e);
            tmp.remove(tmp.size()-1);
            min = Math.min(tmp.size(), min);
            for(String a:tmp) {
                System.out.print(a);
            }
            System.out.println();
            return;
        }
        char [] string = s.toCharArray();
        for (int i = 0; i < string.length; i++) {
            Set<Character> candidate = cadt(i, dict);
            for (char c:candidate) {
                string[i] = c;
                String cur = new String(string);
                if (!dict.contains(cur)) {
                    string[i] = s.charAt(i);
                    continue;
                }
                if (visited.contains(cur)) {
                    string[i] = s.charAt(i);
                    continue;
                }
                visited.add(cur);
                tmp.add(cur);
                helper(cur, e, dict, tmp, visited);
                string[i] = s.charAt(i);
                tmp.remove(tmp.size()-1);
                visited.remove(cur);
            }
        }
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dog");
        dict.add("dot");
        dict.add("lot");
        dict.add("log");
        WordLadder wd = new WordLadder();
        System.out.println(wd.ladderLength("hit","cog",dict));
    }
}