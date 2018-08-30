package PoketGem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lingyanjiang on 17/2/22.
 */
public class PalindromePair {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        //Initiate map
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            //j 可以取等于length的时候
            for (int j = 0; j <= cur.length(); j++) {
                String preffix = cur.substring(0, j);
                String suffix = cur.substring(j);
                //if preffix is palindrome, judge if suffix in map
                if (isPalindrome(preffix)) {
                    String tmp = new StringBuilder(suffix).reverse().toString();
                    if (map.containsKey(tmp) && map.get(tmp) != i) {
                        List l = new ArrayList<>();
                        //先插后面的单词再前面
                        l.add(map.get(tmp));
                        l.add(i);
                        res.add(l);
                    }
                }

                //if suffix is palindrome, judge if suffix in map
                if (isPalindrome(suffix)) {
                    String tmp = new StringBuilder(preffix).reverse().toString();
                    //suffix的长度如果等于0那么就会出现多的状况
                    if (map.containsKey(tmp) && map.get(tmp) != i && suffix.length() != 0) {
                        List l = new ArrayList<>();
                        //先插前面的单词再后面
                        l.add(i);
                        l.add(map.get(tmp));
                        res.add(l);
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        String sb = new StringBuilder(s).reverse().toString();
        return sb.equals(s);
    }
}
