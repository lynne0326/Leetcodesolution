import java.util.*;

/**
 * Created by lingyanjiang on 18/8/28.
 */
public class BusRoutes {

    // 用map记录, <stop, Set<经过stop的bus>>
    // bfs 按层遍历,每次遍历经过的bus,每次去找bus经过的stops里有没有target, 没有的话就加到bfs里继续
    class Solution {
        public int numBusesToDestination(int[][] routes, int S, int T) {
            if(S == T) return 0;
            Map<Integer, Set<Integer>> map = new HashMap<>();

            //stop, routes go through it
            for(int i = 0; i < routes.length; i++) {
                for(int j = 0; j < routes[i].length; j++) {
                    map.putIfAbsent(routes[i][j], new HashSet<>());
                    map.get(routes[i][j]).add(i);
                }
            }

            Queue<Integer> q = new LinkedList<>();
            q.offer(S);
            Set<Integer> visited = new HashSet<>();

            int res = 0;
            while(!q.isEmpty()) {
                int size = q.size();
                res++;
                for(int i = 0; i < size; i++) {
                    int cur = q.poll();
                    if(cur == T) return res;
                    Set<Integer> buses = map.get(cur);
                    for(int bus: buses) {
                        if(visited.contains(bus)) continue;
                        for(int stop: routes[bus]) {
                            if(stop == T) return res;
                            q.offer(stop);
                        }
                        visited.add(bus);
                    }
                }
            }

            return -1;
        }
    }
}
