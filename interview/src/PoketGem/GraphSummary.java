package PoketGem;

/**
 * Created by lingyanjiang on 17/3/3.
 */
public class GraphSummary {

    //什么时候用bfs,什么时候用dfs,
    //取决于data strcuture, 如果搜索的点离root 近, 那就bfs, 如果远,那就dfs
    //If finding shortest path, might use bfs, first found is the shortest, dfs not sure, has to traverse to find all
    //bfs memory consuming, dfs not necessarily memory consuming
//    求最小生成树：
//    Krustal, prim
//    最小生成树保证所有点联通的路径和最小, 不保证两点之间路径最短


//    求A到B路径最短：
//    Dijkstra（对负数不管用）,
//    Bellman-ford（priorityQueue, dp）


    // Dijkstra algorithm, Greedy algorithm, find shortest path O(V + E)
    // 找A->B 最短路径先把A到所有点initiate成infinity,
    // 在把起点initiate成0, 全部vertices存到heap里,
    // 每次把heap里cost最小的poll出来u, 加入到visited set S
    // 遍历这个u的所有邻节点vertices, v
    // update 距离,如果 w(u, v) + d(u) < d(v), d(v) = w(u,v) + d(u) 如果从u走到v的距离小于此时source到v的距离, 就update
    // 不断重复直到找到 target v

    //for v in A.neighbors:
    //  update distance if current(A, v) < d(A, v)
    //      //distanceThroughU < v.minDistance update
    //  add A to visited
    //选择当前cost最小的那个点,
    //重复以上动作
    //直到最后到达B

}
