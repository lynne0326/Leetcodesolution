import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lingyanjiang on 18/8/11.
 */
public class AddBoldTagInString {

    // Merge interval 的延伸题
//    1. 当tmp里的都不在string里的时候sb是空的,要返回s
//    2. 当dict里的词出现很多次的时候，要合并
//    "aaabbcc"
//    ["a","b","c"]
    public String addBoldTag(String s, String[] dict) {
        if (dict.length == 0 || s.length() == 0) return s;
        List<int[]> ranges = new ArrayList<>();
        for (String d: dict) {
            for (int i = 0; i < s.length(); i++) {
                if (s.substring(i).startsWith(d)) {
                    ranges.add(new int[]{i, i + d.length() - 1});
                }
            }
        }
        Collections.sort(ranges, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] tmp = null;
        StringBuilder sb = new StringBuilder();
        for (int[] range: ranges) {
            if (tmp == null) {
                tmp = range;
                sb.append(s.substring(0, tmp[0]));
                continue;
            }
            if (range[0] > tmp[1] + 1) {
                sb.append("<b>").append(s.substring(tmp[0], tmp[1] + 1)).append("</b>").append(s.substring(tmp[1] + 1, range[0]));
                tmp = range;
            } else {
                tmp[1] = Math.max(tmp[1], range[1]);
            }
        }
        if (tmp != null) {
            sb.append("<b>").append(s.substring(tmp[0], tmp[1] + 1)).append("</b>").append(s.substring(tmp[1] + 1));
        }
        return sb.toString().length() == 0 ? s : sb.toString();
    }
}
