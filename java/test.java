import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 16/9/19.
 */
public class test {

    public List<String> subsets(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        char [] chars = s.toCharArray();
        dfs(0, chars, res, new StringBuilder());
        return res;
    }

    private void dfs(int index, char [] chars, List<String> res, StringBuilder sb) {
        if (index > chars.length) {
            return;
        }
        res.add(sb.toString());

        for (int i = index; i < chars.length; i++) {
            sb.append(chars[i]);
            dfs(i+1, chars, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String [] args) {
//        test  t = new test();
//        List<String> res = t.subsets("abc");
//        for (String s: res) {
//            System.out.println(s);
//        }
        List<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(2);
        l.add(2);
        l.add(1);
        l.add(1);
        l.add(1);
        l.remove(new Integer(1));
        System.out.println(l);
    }

}
