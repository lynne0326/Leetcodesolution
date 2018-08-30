package PoketGem;

import java.util.List;

/**
 * Created by lingyanjiang on 17/3/4.
 */
public class WordBreak {

    //DP, O(N^2)  or O(mn) m是dict average len
    public boolean wordBreaki(String s, List<String> dict) {
        boolean [] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i < f.length; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

    //
    //dfs with memo
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, 0, new Boolean[s.length() + 1]);
    }

    private boolean helper(String s, List<String> wordDict, int start, Boolean[] visited) {
        if (start == s.length()) return true;
        if (visited[start] != null) return visited[start];
        for (int i = start + 1; i <= s.length(); i++) {
            if(wordDict.contains(s.substring(start, i)) && helper(s, wordDict, i, visited)) {
                visited[i] = true;
                return true;
            }
        }
        visited[start] = false;
        return false;
    }

}
