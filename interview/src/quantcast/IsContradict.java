package quantcast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lingyanjiang on 17/3/20.
 */

//并查集 复杂度
//并查集的空间复杂度为O(N)，构建一个集合的时间复杂度为O(N)；
// 压缩后的查找复杂度是一个很小的常数
public class IsContradict {
    public char getParent(Map<Character, Character> map, char c) {
        char p = map.get(c);
        while (map.get(p) != p) {
            p = map.get(p);
        }
        return p;
    }

    public boolean isContradict(String[] input) {
        if (input == null || input.length == 0) return false;
        Map<Character, Character> map = new HashMap<>();
        for (String pair : input) {
            char p1 = pair.charAt(0);
            char p2 = pair.charAt(pair.length() - 1);

            char prt1 = map.containsKey(p1) ?  getParent(map, p1) : p1;
            char prt2 = map.containsKey(p2) ?  getParent(map, p2) : p2;
            if (pair.indexOf("!=") != -1) {
                if (prt1 == prt2) return true;
            } else {
                if (!map.containsKey(p1) && !map.containsKey(p2)) {
                    map.put(p1, p2);
                    map.put(p2, p2);
                } else if (!map.containsKey(p1)) {
                    map.put(p1, p2);
                } else if (!map.containsKey(p2)) {
                    map.put(p2, p1);
                } else {
                    if (prt1 != prt2) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> tmp = new ArrayList<>();
        tmp.toArray(new Integer [3]);
//        System.out.println(new IsContradict().isContradict(new String[]{"a=b", "c=d", "a!=c"}));
        System.out.println(new IsContradict().isContradict(new String[]{"a=b", "c=d", "a=c","e=f","f=a","e!=a"}));
    }
}
