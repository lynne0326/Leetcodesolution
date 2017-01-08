import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 16/12/31.
 */
//dfs 可做, 记得index向后走三步, substring, 丢给下一个
public class RestoreIpAdress {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        dfs(0, s, new ArrayList<String>());
        return res;
    }

    private boolean isValid(String s) {
        if (Integer.parseInt(s) >= 256) {
            return false;
        }
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        return true;
    }

    private void dfs(int index, String s,List<String> tmp) {
        if (tmp.size() > 0 && !isValid(tmp.get(tmp.size()-1))) {
            return;
        }
        if (index > s.length() || tmp.size() > 4) {
            return;
        }
        if (tmp.size() == 4 && index < s.length()) {
            return;
        }
        if (tmp.size() == 4 && index >= s.length()) {
            // System.out.println("wwww" + index);
            StringBuilder sb = new StringBuilder();
            for (String t: tmp) {
                sb.append(t).append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }


        for (int j = index; j <= index+3 && j < s.length(); j++) {
            tmp.add(s.substring(index,j+1));
            dfs(j+1, s, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
