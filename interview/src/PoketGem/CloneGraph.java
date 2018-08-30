package PoketGem;

import java.util.*;


//The time complexity is O(V+E), V is number of vertices, E is number of edges.

class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
/**
 * Created by lingyanjiang on 17/2/18.
 */
public class CloneGraph {

    //Idea use HashMap

    public UndirectedGraphNode cloneGraphdfs(UndirectedGraphNode node) {
        if (node == null) return node;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node, head);
        dfs(node, map);
        return head;
    }

    private void dfs(UndirectedGraphNode node,  HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (node == null) return;
        for (UndirectedGraphNode neighbor: node.neighbors) {
            if (!map.containsKey(neighbor)) {
                map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                dfs(neighbor, map);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        //First We create a map to mapping the relation between the original node and the copied node
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        //Next create a new head copy and put into map
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node, head);

        //Then we implement a queue using linkedlist for bfs
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        //Bfs Starts with the original root node
        q.add(node);
        while (!q.isEmpty()) {
            //poll out the next node in the queue and now we need to iterate through its neighbors
            UndirectedGraphNode cur = q.poll();
            for (UndirectedGraphNode neighbor: cur.neighbors) {
                // If the neighbor not in the map, then means this node has never been visited,
                // We add it to the queue and put the new mapping pair into the map
                //坑，注意顺序，首先，child是一定要加的，不管map里有没有child
                //但是map里面没有child的话，说明没有访问过，于是加到q里去，并且要复制
                if (!map.containsKey(neighbor)) {
                    q.add(neighbor);
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }

                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        //At last re turn the head
        return head;
    }


}
