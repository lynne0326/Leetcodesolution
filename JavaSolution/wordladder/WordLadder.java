import java.util.*;

public class WordLadder {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
//    int min = Integer.MAX_VALUE;
//
//    private Set<Character> cadt(int i, Set<String> dict) {
//        Set<Character> set = new HashSet<Character>();
//        for (String dt:dict) {
//            set.add(dt.charAt(i));
//        }
//        return set;
//    }
//    public int ladderLength(String start, String end, Set<String> dict) {
//        // write your code here
//        if (start.equals(end)) {
//            return 0;
//        }
//        ArrayList<String> list = new ArrayList<String>();
//        Set<String> visited = new HashSet<String>();
//        dict.add(start);
//        dict.add(end);
//        list.add(start);
//        // List<List<String>> res = new ArrayList<List<String>>();
//        helper(start, end, dict, list, visited);
//        return min;
//    }
//
//    private void helper(String s, String e, Set<String> dict, List<String> tmp, Set<String> visited) {
//        if (s.equals(e)) {
//            tmp.add(e);
//            tmp.remove(tmp.size()-1);
//            min = Math.min(tmp.size(), min);
//            for(String a:tmp) {
//                System.out.print(a);
//            }
//            System.out.println();
//            return;
//        }
//        char [] string = s.toCharArray();
//        for (int i = 0; i < string.length; i++) {
//            Set<Character> candidate = cadt(i, dict);
//            for (char c:candidate) {
//                string[i] = c;
//                String cur = new String(string);
//                if (!dict.contains(cur)) {
//                    string[i] = s.charAt(i);
//                    continue;
//                }
//                if (visited.contains(cur)) {
//                    string[i] = s.charAt(i);
//                    continue;
//                }
//                visited.add(cur);
//                tmp.add(cur);
//                helper(cur, e, dict, tmp, visited);
//                string[i] = s.charAt(i);
//                tmp.remove(tmp.size()-1);
//                visited.remove(cur);
//            }
//        }
//    }


    class Node {
        String val;
        Node prev;
        Node next;
        public Node(String val) {
            this.val = val;
        }
        public Node(String val, Node prev) {
            this.val = val;
            this.prev = prev;
        }
    }

    public String getPath(String begin, String end, Set<String> wordList) {
        if (begin.equals(end)) return begin;
        if (wordList.size() == 0) return "";
        wordList.add(end);
        Set<String> visited = new HashSet<>();

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin));
        Node endnode = null;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.val.equals(end)) {
                endnode = cur;
                break;
            }
            visited.add(cur.val);
            Set<String> candidates = getNextSets(cur.val, wordList);
            for (String candidate: candidates) {
                if (visited.contains(candidate)) continue;
                q.offer(new Node(candidate, cur));
            }
        }
        if (endnode == null) return "";
        return getPath(endnode);
    }

    private Set<String> getNextSets(String cur, Set<String> wordList) {
        char [] chars = cur.toCharArray();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            char tmp = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == tmp) continue;
                chars[i] = c;
                String word = new String(chars);
                if (wordList.contains(word)) {
                    res.add(word);
                }
            }
            chars[i] = tmp;
        }
        return res;
    }


    private String getPath(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.insert(0, node.val+" ");
            node = node.prev;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dog");
        dict.add("dot");
        dict.add("lot");
        dict.add("log");
        WordLadder wd = new WordLadder();
//        System.out.println(wd.ladderLength("hit","cog",dict));
        System.out.println(wd.getPath("hit","cog",dict));
    }

}