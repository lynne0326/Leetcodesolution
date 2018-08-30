package PoketGem;

import java.util.*;

/**
 * Created by lingyanjiang on 17/2/23.
 */
public class ShortestPath {
    class Point {
        int x;
        int y;
        Point prev;
        Set<Character> keys;
        //We need to track the status with keys
        //Also we need to track its parent, because finally we need to return the whole path
        public Point(int x, int y, Point prev) {
            this.x = x;
            this.y = y;
            this.prev = prev;
            this.keys = new HashSet<Character>();
        }

        @Override
        public int hashCode() {
            return keys.hashCode() + 31 * this.x + this.y;
        }

        @Override
        public boolean equals(Object object) {
            //Equals only if keys and x , y all the same
            if (object instanceof Point) {
                Point p = (Point) object;
                return this.x == p.x && this.y == p.y && this.keys.equals(p.keys);
            }
            return false;
        }

        @Override
        public String toString() {
            return this.x +" " + this.y;
        }

    }

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    public List<Point> findShortestPath(String[] map) {
        List<Point> res = new ArrayList<>();// Store result
        //Corner case when map is null
        if (map == null || map.length == 0) return res;
        //Then we need a queue to conduct bfs
        Queue<Point> q = new LinkedList<>();
        //Also important is the visited set to track the point or
        // (should be status here) using hashset.
        Set<Point> visited = new HashSet<Point>();


        //First we need to find the start point and put into queue
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length(); j++) {
                if (map[i].charAt(j) == '2') {
                    Point p = new Point(i, j, null);
                    q.offer(p);
                }
            }
        }

        //We will also need to track the end point
        Point end = null;
        //When q is not empty, we keep poll out the point in queue
        while (!q.isEmpty()) {
            Point cur = q.poll();
            //if it is visited then we continue
            if (visited.contains(cur)) continue;
            char curVal = map[cur.x].charAt(cur.y);
            //If it's the end point, we jump out the loop
            // also keep record of current end
            if (curVal == '3') {
                end = cur;
                break;
            } else if (curVal >= 'a' && curVal <= 'z') {
                //If current point is a key
                //add key to this point status
                cur.keys.add(curVal);
            } else if (curVal >= 'A' && curVal <= 'Z') {
                //If it's the capital, the gate, then we need
                // to check if it contains the corresponding key
                if (!cur.keys.contains(Character.toLowerCase(curVal))) {
                    continue;
                }
                //If we have the key, we can throw it since we already found the door
                cur.keys.remove(curVal);
            }
            //add current point to visited set
            visited.add(cur);
            for (int i = 0; i < 4; i++) {
                //Then we traverse through four direction and put the eligible point to queue
                int xx = cur.x + dx[i];
                int yy = cur.y + dy[i];
                if (xx < 0 || xx >= map.length || yy < 0 || yy >= map[xx].length() || map[xx].charAt(yy) == '0')
                    continue;
                Point tmp = new Point(xx, yy, cur);
                //容易掉,要把所有的keys都加回去
                tmp.keys.addAll(cur.keys);
                q.offer(tmp);
            }
        }

        //If no solutions return empty list
        if (end == null) return res;

        while (end != null) {
            res.add(0, end);
            end = end.prev;
        }
        return res;
    }

    public static void main(String[] args) {
        ShortestPath shortestPath = new ShortestPath();
//        String[] map = new String[]{
//                "02111",
//                "01001",
//                "01003",
//                "01001",
//                "01111"};

        String[] map = {
			"02a11",
			"0100A",
			"01003",
			"01001",
			"01111"
		};

        List<Point> paths = shortestPath.findShortestPath(map);
        for (Point p : paths) {
            System.out.println(p.toString());
        }
    }
}
