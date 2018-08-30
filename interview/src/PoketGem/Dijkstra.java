package PoketGem;

import java.util.*;

/**
 * Created by lingyanjiang on 17/3/6.
 */
class Edge {
    String s;
    String t;
    int cost;

    public Edge(String s, String t, int cost) {
        this.s = s;
        this.t = t;
        this.cost = cost;
    }
}

public class Dijkstra {

    //Shortest path from source to all other nodes
    public List<String> getMinPath(Edge[] edges, String s) {
        //All the neighbors of a vertece and the cost
        Map<String, Map<String, Integer>> edgeCosts = new HashMap<>();
        //Store the distance from source to all other nodes
        Map<String, Integer> totalCosts = new HashMap<>();
        //Initiate
        for (Edge edge : edges) {
            //Initiate to infinety
            totalCosts.put(edge.s, Integer.MAX_VALUE);
            totalCosts.put(edge.t, Integer.MAX_VALUE);
            //put into edge map
            if (!edgeCosts.containsKey(edge.s)) edgeCosts.put(edge.s, new HashMap<>());
            edgeCosts.get(edge.s).put(edge.t, edge.cost);
        }

        //Soure dist to be 0 and add to the q
        totalCosts.put(s, 0);
        Queue<String> q = new LinkedList<>();
        List<String> visited = new ArrayList<>();
        q.add(s);

        while (!q.isEmpty()) {
            String cur = q.poll();
            visited.add(cur);
//            if (cur.equals(e)) break;
            int curVal = totalCosts.get(cur);
            Map<String, Integer> edgeCost = edgeCosts.get(cur);
            int min = Integer.MAX_VALUE;
            String next = null;
            if (edgeCost == null) continue;
            //Iterate through all the neighbors and update current min distance
            for (String key : edgeCost.keySet()) {
                if (visited.contains(key)) continue;
                int value = edgeCost.get(key);
                int tmp = curVal + value;
                if (tmp < totalCosts.get(key)) {
                    totalCosts.put(key, tmp);
                }
                //Update when dist(u) > dist(v, u) + dist(v) v is the fromNode
                if (totalCosts.get(key) < min) {
                    min = totalCosts.get(key);
                    next = key;
                }
            }
            if (next != null) {
                q.add(next);
            }
        }

        for (String v: visited) {
            System.out.println(v);
        }
        return visited;

    }

    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        Edge [] edges = new Edge[]{
                new Edge("A","B",10),
                new Edge("A","C",15),
                new Edge("B","D",12),
                new Edge("D","E",2),
                new Edge("C","E",10),
                new Edge("B","F",15),
                new Edge("D","F",1),
                new Edge("F","E",5)
        };
        d.getMinPath(edges, "A");
    }

}
