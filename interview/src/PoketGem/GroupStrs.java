package PoketGem;

import java.util.*;

/**
 * Created by lingyanjiang on 17/2/24.
 */
public class GroupStrs {
    
    //Brute force
    public List<List<String>> groupString(String [] words) {
        List<List<String>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            if (visited.contains(cur)) continue;
            List<String> tmp = new ArrayList<>();
            tmp.add(cur);
            visited.add(words[i]);
            for (int j = i+1; j < words.length; j++) {
                if (words[j].indexOf(words[i]) != -1 && !visited.contains(words[j])) {
                    tmp.add(words[j]);
                    visited.add(words[j]);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        String [] input = new String[]{"can", "cow", "cold", "an", "co"};
//        String [] input = new String[]{"can", "cow", "cold"};
//        String [] input = new String[]{"c", "ca", "can"};
        List<List<String>> res = new GroupStrs().groupString(input);
        for (List<String> list: res) {
            for(String s: list) {
                System.out.print(s+",");
            }
            System.out.println();
        }
    }
}
