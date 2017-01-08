import java.util.HashMap;
import java.util.Map;

/**
 * Created by lingyanjiang on 16/6/7.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() == 0 && t.length() == 0)
            return true;
        else if(s.length() != t.length())
            return false;
        Map<Character,Integer> map = new HashMap();
        for(int i=0;i<s.length();i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<t.length();i++) {
            if(!map.containsKey(t.charAt(i))) {
                return false;
            }
            if(map.get(t.charAt(i))-1 < 0) {
                return false;
            }
            map.put(t.charAt(i),map.get(t.charAt(i))-1);
        }
        return true;
    }
}
