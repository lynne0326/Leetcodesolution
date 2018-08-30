package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 17/2/23.
 */
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(word, "", 0, 0, res);
        return res;
    }

    private void dfs(String word, String cur, int idx, int count, List<String> res) {
        if (idx == word.length()) {
            //坑:注意这里
            if (count > 0) {
                cur += count;
            }
            res.add(cur);
            return;
        }
        //如果不abbreviate跳过并计数
        dfs(word, cur, idx + 1, count + 1, res);
        //如果abbreviate加到cur里,count清零
        dfs(word, cur + (count > 0 ? count : "") + word.charAt(idx) , idx + 1, 0, res);
    }

    public static void main(String[] args) {
        GeneralizedAbbreviation g = new GeneralizedAbbreviation();
        g.generateAbbreviations("word");
    }
}
