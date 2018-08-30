package PoketGem;

/**
 * Created by lingyanjiang on 17/3/7.
 */
import java.util.*;

class Node2{
    char val;
    Set<Node2> neighbors;
    public Node2(char val) {
        this.val = val;
        this.neighbors = new HashSet<>();
    }
}

public class WordSearch {
    public List<List<Node2>> findString(Set<Node2> nodes, String s) {
        List<List<Node2>> res = new ArrayList<>();
        if (nodes == null || nodes.size() == 0) return res;
        helper(nodes, s, 0, res, new ArrayList<Node2>(), new HashSet<Node2>());
        return res;
    }

    private void helper(Set<Node2> candidates, String s, int idx, List<List<Node2>> res, List<Node2> tmp, Set<Node2> visited) {
        if (idx == s.length()) {
            res.add(new ArrayList<Node2>(tmp));
            return;
        }
        if (candidates.size() == 0) return;
        for (Node2 c : candidates) {
            if (visited.contains(c) || c.val != s.charAt(idx)) continue;
            visited.add(c);
            tmp.add(c);
            helper(c.neighbors, s, idx + 1, res, tmp, visited);
            visited.remove(c);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Node2 n1 = new Node2('l');
        Node2 n2 = new Node2('u');
        Node2 n3 = new Node2('c');
        Node2 n4 = new Node2('k');
        n1.neighbors.add(n2);
        n1.neighbors.add(n3);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n2.neighbors.add(n4);
        n3.neighbors.add(n1);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n2);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        Set<Node2> set = new HashSet<>();
        set.add(n1);
        set.add(n2);
        set.add(n3);
        set.add(n4);
        List<List<Node2>> res = new WordSearch().findString(set, "luck");
        for (List<Node2> path: res) {
            for (Node2 p: path) {
                System.out.println(p.val);
            }
        }
    }
}