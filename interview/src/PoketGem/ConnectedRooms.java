package PoketGem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lingyanjiang on 17/3/1.
 */
class Room {
    int x;
    int y;
    int h;
    int w;

    public Room(int x, int y, int h, int w) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
    }
}

public class ConnectedRooms {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    public boolean isConnected(Room[] rooms, int m, int n) {
        if (rooms == null || rooms.length == 0) return false;
        boolean[][] grid = new boolean[m][n];
        int area = 0;
        //prepare boolean grid
        for (Room room : rooms) {
            int x = room.x;
            int y = room.y;
            for (int i = x; i < x + room.h; i++) {
                for (int j = y; j < y + room.w; j++) {
                    grid[i][j] = true;
                }
            }
            area += room.h * room.w;
        }

        //bfs
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{rooms[0].x, rooms[0].y});
        int sum = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (!grid[cur[0]][cur[1]]) continue;
            grid[cur[0]][cur[1]] = false;
            sum++;
            for (int i = 0; i < 4; i++) {
                int xx = cur[0] + dx[i];
                int yy = cur[1] + dy[i];
                if (xx < 0 || yy < 0 || xx >= m || yy >= n || !grid[xx][yy]) continue;
                q.add(new int[]{xx, yy});
            }
        }
        return sum == area;
    }

    public static void main(String[] args) {
        Room[] rooms = new Room[]{
                new Room(0, 0, 3, 3),
                new Room(2, 3, 3, 3),
                new Room(0, 6, 3, 2),
                new Room(4, 6, 2, 2),
        };
        boolean res = new ConnectedRooms().isConnected(rooms, 6, 8);
        System.out.println(res);
    }
}

