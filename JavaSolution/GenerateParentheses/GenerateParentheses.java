import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 16/12/30.
 */

public class GenerateParentheses {
    //Backtracing DFS, 简单暴力, 记得index要加着走
    List<String> res = new ArrayList<>();
    final static String brackets = "()";

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        dfs(0, n, new StringBuilder(), 0);
        return res;
    }

    private void dfs(int index, int n, StringBuilder sb, int numLeft) {
        if (numLeft < sb.length() - numLeft || numLeft > n) {
            return;
        }
        if (sb.length() == n*2) {
            res.add(sb.toString());
            return;
        }

        for (int i = index; i < 2*n; i++) {
            for (int j = 0; j < brackets.length(); j++) {
                sb.append(brackets.charAt(j));
                dfs(i+1, n, sb, j == 0 ? numLeft+1: numLeft);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
