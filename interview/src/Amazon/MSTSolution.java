package Amazon;

import java.util.*;

/**
 * Created by lingyanjiang on 16/12/16.
 */
class Connection{
    String node1;
    String node2;
    int cost;
    public Connection(String a, String b, int c){
        node1 = a;
        node2 = b;
        cost = c;
    }
}

public class MSTSolution {
    public static int curNum = 0;

    public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections){
        ArrayList<Connection> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        if (connections == null || connections.size() == 0) {
            return res;
        }
        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                if (o1.cost == o2.cost) {
                    return 0;
                }
                return o1.cost < o2.cost ? -1 : 1;
            }
        });

        for (Connection conn: connections) {
            String city1 = conn.node1;
            String city2 = conn.node2;
            if (union(city1, city2, map)) {
                res.add(conn);
            }
        }

        //check if in one union
        int union = map.get(connections.get(0).node1);
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() != union) {
                return new ArrayList<>();
            }
        }
        Collections.sort(res, new Comparator<Connection>() {
            @Override
            public int compare(Connection c1, Connection c2) {
                if (c1.node1.equals(c2.node2)) {
                    return c1.node2.compareTo(c2.node2);
                }
                return c1.node1.compareTo(c2.node1);
            }
        });
        return res;
    }

    private static boolean union(String city1, String city2, Map<String, Integer> map) {
        if (!map.containsKey(city1) && !map.containsKey(city2)) {
            map.put(city1, curNum);
            map.put(city2, curNum);
            curNum++;
            return true;
        }
        if (map.containsKey(city1) && !map.containsKey(city2)) {
            map.put(city2, map.get(city1));
            return true;
        }
        if (!map.containsKey(city1) && map.containsKey(city2)) {
            map.put(city1, map.get(city2));
            return true;
        }
        if (map.containsKey(city1) && map.containsKey(city2)) {
            if (map.get(city1) == map.get(city2)) {
                return false;
            }
            for (Map.Entry<String, Integer> entry: map.entrySet()) {
                if (entry.getValue() == map.get(city2)) {
                    map.put(entry.getKey(), map.get(city1));
                }
            }
        }
        return true;
    }



    //版本二,不需要全局变量
    public static ArrayList<Connection> getLowCost2(ArrayList<Connection> connections) {
        ArrayList<Connection> result = new ArrayList<>();
        if (connections == null || connections.size() == 0) {
            return result;
        }
        Collections.sort(connections, new Comparator<Connection>(){
            @Override
            public int compare(Connection c1, Connection c2) {
                return c1.cost - c2.cost;
            }
        });

        HashMap<String, String> parents = new HashMap<>();
        for (Connection c: connections) {
            parents.put(c.node1, c.node1);
            parents.put(c.node2, c.node2);
        }

        for (Connection c: connections) {
            if (union2(c.node1, c.node2, parents)) {
                result.add(c);
            }
        }

        if (result.size() != parents.size() - 1) {
            return null;
        }
        Collections.sort(result, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                if (o1.node1.equals(o2.node1)) {
                    return o1.node2.compareTo(o2.node2);
                }
                return o1.node1.compareTo(o2.node2);
            }
        });
        return result;
    }

    private static boolean union2 (String node1, String node2, Map<String, String> parents) {
        String parent1 = find(node1, parents);
        String parent2 = find(node2, parents);
        if (parent1.equals(parent2)) {
            return false;
        }
        parents.put(parent2, parent1);
        return true;
    }

    private static String find(String node, Map<String, String> map) {
        if (node.equals(map.get(node))){
            return node;
        }
        String parent = find(map.get(node), map);
        map.put(node, map.get(map.get(node)));
        return parent;
    }


    public static void main(String[] args) {
        ArrayList<Connection> connections = new ArrayList<>();
        //下面的图是个苯环，中间加上了几根，如果想验证空表，去掉几根线就行。
        connections.add(new Connection("A","B",6));
        connections.add(new Connection("B","C",4));
        connections.add(new Connection("C","D",5));
        connections.add(new Connection("D","E",8));
        connections.add(new Connection("E","F",2));
        connections.add(new Connection("B","F",10));
        connections.add(new Connection("E","C",9));
        connections.add(new Connection("F","C",7));
        connections.add(new Connection("B","E",3));
        connections.add(new Connection("A","F",16));
        //这里就输出一下看看结果。
//        ArrayList<Connection> res = getLowCost(connections);
        ArrayList<Connection> res = getLowCost2(connections);
        for (Connection c : res){
            System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
        }
    }
}
