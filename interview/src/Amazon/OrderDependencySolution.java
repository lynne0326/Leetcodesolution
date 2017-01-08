package Amazon;

import java.util.*;

/**
 * Created by lingyanjiang on 16/12/31.
 */
class Order{
    String orderName;
    public Order(String string){
        this.orderName = string;
    }
}

class OrderDependency{
    Order cur;
    Order pre;
    public OrderDependency(Order pre, Order cur){
        this.pre = pre;
        this.cur = cur;
    }
}

//步骤:1.把order mapping成 string,order
//步骤:2.做两个map(1是root-children的map 2是indegree的map,只纪录children的点+1)
//步骤:3.initiate root
//步骤:4.bfs
//步骤:5.转回order, 判断大小以确定是否有环

//坑1: mapping成children的时候一定要用list不要用set,因为会有重复的node到时候要重复减的
//坑2: 不能在initiate root的时候加到res里,会重复
public class OrderDependencySolution {

    //method convert order to string specified
    private static HashMap<String, Order> mapOrder (List<OrderDependency> orderDependencies) {
        HashMap<String, Order> map = new HashMap<String, Order>();
        for (OrderDependency orderDependency: orderDependencies) {
            String curName = orderDependency.cur.orderName;
            String preName = orderDependency.pre.orderName;
            map.put(curName, orderDependency.cur);
            map.put(preName, orderDependency.pre);
        }
        return map;
    }

    public static List<Order> solution(List<OrderDependency> orderDependencies){
        //mapping order string and order
        HashMap<String, Order> mappingOrder = mapOrder(orderDependencies);

        //k:root, v: children set
        //坑2: 一定要用list不要用set, 因为有重复的!!!!!!
        HashMap<String, List<String>> children = new HashMap<>();

        HashMap<String, Integer> indegree = new HashMap<>();
        for (OrderDependency ord: orderDependencies) {
            String cur = ord.cur.orderName;
            String pre = ord.pre.orderName;

            //put into children map
            if (!children.containsKey(pre)) {
                children.put(pre, new ArrayList<String>());
            }
            children.get(pre).add(cur);

            //put into indegree map
            //pre node
            //注意!!!!这里把root也同时往里面放,root是0, children正常+1
            if (!indegree.containsKey(pre)) {
                indegree.put(pre, 0);
            }
            //child node
            if (!indegree.containsKey(cur)) {
                indegree.put(cur, 1);
            } else {
                indegree.put(cur, indegree.get(cur) + 1);
            }
        }

        //bfs
        Queue<String> q = new LinkedList<>();
        List<String> res = new ArrayList<>();
        //initiate
        for (Map.Entry<String, Integer> entry: indegree.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            //if root, add to q
            if (value == 0) {
                //坑之1~~在这里加到q就好了,q里会add每一个去res,避免重复
                q.add(key);
            }
        }

        //bfs process
        while (!q.isEmpty()) {
            String cur = q.poll();
            res.add(cur);
            List<String> set = children.get(cur);
            if (set != null) {
                for (String child : set) {
                    //minus one when indegree
                    int tmp = indegree.get(child);
                    indegree.put(child, tmp - 1);
                    if (tmp - 1 == 0) {
                        q.add(child);
                    }
                }
            }
        }


        if (indegree.size() != res.size()) {
            //if cycle
            return null;
        }
        List<Order> result = new ArrayList<>();
        for (String s: res) {
            result.add(mappingOrder.get(s));
        }
        return result;
    }

        public static void main(String[] args) {
            Order o1 = new Order("泡面");
            Order o2 = new Order("泡面");
            Order o3 = new Order("SF");
            Order o4 = new Order("租车");
            Order o5 = new Order("SF");
            Order o6 = new Order("泡面");
            Order o7 = new Order("租车");
            Order o8 = new Order("SF");
            Order o9 = new Order("爽(每个行为只输出了一次对吧)");
            OrderDependency od1 = new OrderDependency(o1, o3);
            OrderDependency od2 = new OrderDependency(o2, o7);
            OrderDependency od3 = new OrderDependency(o3, o9);
            OrderDependency od4 = new OrderDependency(o4, o3);
            OrderDependency od5 = new OrderDependency(o6, o9);
            OrderDependency od6 = new OrderDependency(o8, o9);
            OrderDependency od7 = new OrderDependency(o2, o5);

            List<OrderDependency> list = new ArrayList<>();
            list.add(od1);
            list.add(od2);
            list.add(od3);
            list.add(od4);
            list.add(od5);
            list.add(od6);
            list.add(od7);
            //最后输出就是这种形式
            List<Order> res = solution(list);
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i).orderName);
                if (i+1 < res.size()){
                    System.out.print(" -> ");
                }
            }
        }
}
