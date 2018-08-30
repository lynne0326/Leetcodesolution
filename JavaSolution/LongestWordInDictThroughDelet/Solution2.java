import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lingyanjiang on 17/2/25.
 */
public class Solution2 {
    List<String> candidate = new ArrayList<>();
    int max = 0;

    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0) return s;
        dfs(s, d, 0, "");
        Collections.sort(candidate);
        return candidate.get(0);
    }

    private void dfs(String s, List<String> d, int idx, String cur) {
        if (idx > s.length()) {return;}
        for (String cd: d) {
            if (cur.equals(cd)) {
                if(cur.length() > max) {
                    max = cur.length();
                    candidate = new ArrayList<>();
                    candidate.add(cur);
                } else if (cur.length() == max) {
                    candidate.add(cur);
                }
            }
        }

        for(int i = idx; i < s.length(); i++) {
            dfs(s, d, i + 1, cur + s.charAt(i));
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        List<String> list = Arrays.asList(new String[]{"ab","ba","a","b"});
        solution2.findLongestWord("bab", list);
    }
}
