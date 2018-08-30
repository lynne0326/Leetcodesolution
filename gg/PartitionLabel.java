import java.util.*;

/**
 * Created by lingyanjiang on 18/8/12.
 */
public class PartitionLabel {
    //方法一: merge interval 的做法
    public List<Integer> partitionLabels(String S) {
        List<int[]> ranges = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            if (visited.contains(S.charAt(i))) continue;
            for (int j = S.length() - 1; j >= i; j--) {
                if (S.charAt(i) != S.charAt(j)) continue;
                ranges.add(new int[]{i, j});
                visited.add(S.charAt(i));
                break;
            }
        }
        List<Integer> res = new ArrayList<>();
        Collections.sort(ranges, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] tmp = null;
        for (int[] range: ranges) {
            if (tmp == null) {
                tmp = range;
                continue;
            }
            if (range[0] > tmp[1]) {
                res.add(tmp[1] - tmp[0] + 1);
                tmp = range;
            } else {
                tmp[1] = Math.max(tmp[1], range[1]);
            }
        }
        if (tmp != null) {
            res.add(tmp[1] - tmp[0] + 1);
        }
        return res;
    }

    //方法二: Greedy!!
    public List<Integer> partitionLabels2(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
