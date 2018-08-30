import java.util.*;

/**
 * Created by lingyanjiang on 18/7/31.
 */
//time complexity f(n) = n*(n-1)*... *1=n^n.
public class WordPatternii {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();//pattern a represent the string
        Set<String> set = new HashSet<>();
        return isMatch(str, 0, pattern, 0, map, set);
    }

    private boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map,
                            Set<String> set){
        //base case
        if(i == str.length() && j == pat.length()) return true;
        if(j == str.length() || j == pat.length()) return false;

        char c = pat.charAt(j);

        if(map.containsKey(c)){
            String s = map.get(c);

            //check if we can use it to match str[i,..., i+s.length()]
            //startWith: begin at i, start with s
            if(!str.startsWith(s, i)) return false;

            return isMatch(str, i+s.length(), pat, j+1, map, set);
        }

        // pattern character does not exist in the map
        for(int k = i; k<str.length(); k++){
            String p = str.substring(i, k+1);
            if(set.contains(p)) continue;

            //create or update it
            map.put(c, p);
            set.add(p);

            // continue to match the rest
            if(isMatch(str, k+1, pat, j+1, map, set)) return true;

            map.remove(c);
            set.remove(p);
        }

        return false;
    }
}
