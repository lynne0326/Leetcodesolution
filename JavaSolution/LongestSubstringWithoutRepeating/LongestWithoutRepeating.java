import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lingyanjiang on 16/12/30.
 */
public class LongestWithoutRepeating {
    //方法1, brute force 问题在于,当一个substring(i,j),j走到头的时候都没有重复的时候,也要更新一下max,这里的话就用flag作为标志
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            boolean flag = false;
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    max = Math.max(max, j - i);
                    flag = true;
                    break;
                }
                set.add(s.charAt(j));
            }
            if (!flag) {
                max = Math.max(max, s.length() - i);
            }
        }
        return max;
    }

    //方法2
    //two pointers i先走,j在i走到重复的时候去更新j,其他时候每一次都更新一下max
    //注意,j更新的时候,要取max(j, 重复char的上一个位置+1)
    //然后更新重复char的位置,再更新max
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    //方法3
    //用charset代替hashmap,并且init成-1,最后可以省略判断是否存在,-1+1就是0
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int [] map = new int[256];

        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }

        for (int i = 0, j = 0; i < s.length(); i++) {
            // if (map[s.charAt(i)] != -1) {
            j = Math.max(j, map[s.charAt(i)]+1);
            // }
            map[s.charAt(i)] = i;
            max = Math.max(i - j + 1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring2("abcabcabc");
    }
}
