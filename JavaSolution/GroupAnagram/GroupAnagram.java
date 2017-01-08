import java.util.*;

/**
 * Created by lingyanjiang on 16/12/31.
 */

public class GroupAnagram {
    //方法1: 比较笨,用comparator
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            tmp.add(strs[i]);
        }
        Collections.sort(tmp, new Comparator<String>(){
            @Override
            public int compare(String n1, String n2) {
                return countDiff(n1, n2);
            }
        });
        String cur = tmp.get(0);
        List<String> current = null;
        // current.add(cur);
        for (int i = 0; i < tmp.size(); i++) {
            if (current == null) {
                cur = tmp.get(i);
                current = new ArrayList<>();
                current.add(cur);
            }
            else if (countDiff(cur, tmp.get(i)) != 0) {
                res.add(current);
                cur = tmp.get(i);
                current = new ArrayList<>();
                current.add(cur);
            } else {
                current.add(tmp.get(i));
            }
        }
        if (current.size() != 0) {
            res.add(current);
        }
        return res;
    }

    private int countDiff(String n1, String n2) {
        if (n1.length() != n2.length() ) {
            return n1.length() - n2.length();
        }
        char [] array1 = n1.toCharArray();
        char [] array2 = n2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        int countDiff = 0;
        String tmp1 = new String(array1);
        String tmp2 = new String(array2);
        return tmp1.compareTo(tmp2);
    }

    //方法二: hashmap, 用sort好的anagram的string作为key,每次都去看map里有没有
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char [] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            if (!map.containsKey(new String(tmp))) {
                map.put(new String(tmp), new ArrayList<String>());
            }
            map.get(new String(tmp)).add(strs[i]);
        }

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }


    public static void main(String[] args) {
        Deque<Integer> d = new LinkedList<>();
        d.push(1);
        d.push(5);
        System.out.println(d.peekFirst());
        System.out.println(d.peekLast());
        d.add(10);
        System.out.println();
        System.out.println(d.peekFirst());
        System.out.println(d.peekLast());
        System.out.println(d.removeFirst());
        System.out.println();
        System.out.println(d.peekFirst());
        System.out.println(d.peekLast());
//        System.out.println(d.poll());
//        System.out.println(d.poll());
//        System.out.println(d.poll());
    }
}
