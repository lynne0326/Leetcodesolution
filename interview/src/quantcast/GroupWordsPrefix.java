package quantcast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lingyanjiang on 17/3/20.
 */
class Trie {
    char val;
    Map<Character, Trie> children;
    boolean isEnd;

    public Trie(char val) {
        this.val = val;
        children = new HashMap<>();
    }

    public void insert(String s) {
        Map<Character, Trie> tmp = this.children;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!tmp.containsKey(c)) {
                tmp.put(c, new Trie(c));
            }
            if (i == s.length() - 1) {
                tmp.get(c).isEnd = true;
            }
            tmp = tmp.get(c).children;
        }
    }
}

public class GroupWordsPrefix {

    public String getPrefixString(String [] words) {
        if (words == null || words.length == 0) return "";
        Trie root = new Trie('-');
        for (String word: words) {
            root.insert(word);
        }
        return dfs(root);
    }

    private String dfs(Trie root) {
        if (root == null) return null;
        if (root.children.size() == 0) return root.val+"";
        List<String> collect = new ArrayList<>();
        for (char c: root.children.keySet()) {
            Trie next = root.children.get(c);
            StringBuilder sb = new StringBuilder();
            String tmp = dfs(next);
            if (next.children.size() != 0) sb.append(c);
            if(tmp == null || tmp.isEmpty()) continue;
            sb.append(tmp);
            collect.add(sb.toString());
        }
        if (collect.size() == 1) return collect.get(0);
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < collect.size(); i++) {
            sb.append(collect.get(i)).append("|");
        }
        sb.deleteCharAt(sb.length()-1).append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = new GroupWordsPrefix().getPrefixString(new String[]{"fooa","foob","efg","egh"});
        System.out.println(res);
    }
}
