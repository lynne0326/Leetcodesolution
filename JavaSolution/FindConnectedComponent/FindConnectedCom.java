import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lingyanjiang on 16/12/20.
 */

class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };
 
public class FindConnectedCom {
    private void connect(UndirectedGraphNode s, UndirectedGraphNode t, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (!map.containsKey(s) && !map.containsKey(t)) {
            map.put(s, s);
            map.put(t, s);
        }
        else if (map.containsKey(s) && !map.containsKey(t)) {
            UndirectedGraphNode parent = map.get(s);
            UndirectedGraphNode cur = s;
            while (parent != cur) {
                cur = parent;
                parent = map.get(parent);
            }
            map.put(s, parent);
            map.put(t, parent);
        }
        else if (!map.containsKey(s) && map.containsKey(t)) {
            UndirectedGraphNode parent = map.get(t);
            UndirectedGraphNode cur = t;
            while (parent != cur) {
                cur = parent;
                parent = map.get(parent);
            }
            map.put(s, parent);
            map.put(t, parent);
        }
        else {
            map.put(t, map.get(s));
        }
    }
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> resf = new ArrayList<List<Integer>>();
        if (nodes == null) {
            return resf;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode node: nodes) {
            ArrayList<UndirectedGraphNode> neighbors = node.neighbors;
            for (UndirectedGraphNode neighbor: neighbors) {
                connect(node, neighbor, map);
            }
        }
        Map<UndirectedGraphNode, List<Integer>> res = new HashMap<>();
        for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry: map.entrySet()) {
            UndirectedGraphNode key = entry.getKey();
            UndirectedGraphNode value = entry.getValue();
            if (res.containsKey(key)) {
                List<Integer> tmp = res.get(key);
                tmp.add(value.label);
            } else {
                List<Integer> tmp = new ArrayList<>();
                res.put(key, tmp);
                tmp.add(value.label);
            }
        }
        for(List list:res.values()) {
            resf.add(list);
        }
        return resf;
    }
}
