package PoketGem;

import java.util.*;

/**
 * Created by lingyanjiang on 17/3/1.
 */
public class OrderCharAt {

    //Time Complexity: The first step to create a graph takes O(n + m) time where n
    // is number of given words and n is number of characters in given alphabet.
    // Next is also topological sorting. Note that there would be alpha vertices and at-most (n-1) edges in the graph.
    // The time complexity of topological sorting is O(V+E) which is O(n + m) here.
    // So overall time complexity is O(n + m) + O(n + m) which is O(n + m).

    //Create a graph of characters!!!!
    //Building up one map called children, store the Edges, store as parent -- Children sets(neighbors/vertices pointing to)
    //Building up the indegree map, record how many vertices pointing to this vertics
    public static String getOrder(String [] strings) {
        Map<Character, Set<Character>> children = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String s: strings) {
            for (int i = 0; i < s.length() - 1; i++) {
                char first = s.charAt(i);
                char second = s.charAt(i + 1);
                if (first == second) continue;

                //deal with children map
                if (!children.containsKey(first)) {
                    children.put(first, new HashSet<Character>());
                }
                if (!children.get(first).contains(second)) {
                    indegree.put(second, indegree.getOrDefault(second, 0) + 1);
                    children.get(first).add(second);
                }
                //deal with indegree map
                if (!indegree.containsKey(first)) {
                    indegree.put(first, 0);
                }
            }
        }

        //BFS topological sort
        Queue<Character> q = new LinkedList<>();
        //Initiate
        for (char key: indegree.keySet()) {
            if (indegree.get(key) == 0) {
                q.add(key);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);
            if (children.get(cur) == null) continue;
            for (char child: children.get(cur)) {
                indegree.put(child, indegree.get(child) - 1);
                if (indegree.get(child) == 0) {
                    q.add(child);
                }
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        String res = getOrder(new String[]{"abb", "cabd", "bg"});
//        String res2 = getOrderOfChar(new String[]{"abb", "cabd", "bg"});
        System.out.println(res);
//        System.out.println(res2);
    }
}
