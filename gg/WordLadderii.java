/**
 * Created by lingyanjiang on 18/7/30.
 */
public class WordLadderii {
//    bfs tracking with node, tle/mle
//    class Node {
//        Node prev;
//        String val;
//        Set<String> parents;
//        public Node(String val) {
//            this.val = val;
//            this.parents = new HashSet<>();
//        }
//    }
//
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> res = new ArrayList<>();
//        Set<String> list = new HashSet<>(wordList);
//        Queue<Node> q = new LinkedList<>();
//        q.offer(new Node(beginWord));
//        boolean isFound = false;
//        List<Node> tmpList = new ArrayList<>();
//        while (!q.isEmpty()) {
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                Node cur = q.poll();
//                if (cur.val.equals(endWord)) {
//                    isFound = true;
//                    tmpList.add(cur);
//                    continue;
//                }
//                Set<String> visited = cur.parents;
//                char[] chars = cur.val.toCharArray();
//                for (int j = 0; j < chars.length; j++) {
//                    char tmp = chars[j];
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        chars[j] = c;
//                        String s = new String(chars);
//                        if (!list.contains(s)) continue;
//                        if (visited.contains(s) || s.equals(cur.val)) continue;
//                        Node node = new Node(s);
//                        node.prev = cur;
//                        node.parents = new HashSet<>(cur.parents);
//                        node.parents.add(cur.val);
//                        q.offer(node);
//                    }
//                    chars[j] = tmp;
//                }
//            }
//            if (isFound) break;
//        }
//        for (Node n:tmpList) {
//            List<String> l = new ArrayList<>();
//            while (n != null) {
//                l.add(0, n.val);
//                n = n.prev;
//            }
//            res.add(l);
//        }
//        return res;
//    }

}
