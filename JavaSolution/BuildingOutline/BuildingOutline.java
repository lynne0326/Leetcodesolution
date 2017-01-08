import java.util.*;

/**
 * Created by lingyanjiang on 16/10/11.
 */
public class BuildingOutline {
    class Building{
        int time;
        int height;
        int status;//0 for start 1 for end

        public Building(int time, int height, int status) {
            this.time = time;
            this.height = height;
            this.status = status;
        }
    }
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // write your code here
        if (buildings == null || buildings.length == 0) {
            return null;
        }
        ArrayList<Building> buildingPoints = new ArrayList<Building>();
        for (int i = 0; i < buildings.length; i++) {
            buildingPoints.add(new Building(buildings[i][0],buildings[i][2],0));
            buildingPoints.add(new Building(buildings[i][1],buildings[i][2],1));
        }

        Collections.sort(buildingPoints, new Comparator<Building>(){
            public int compare(Building b1, Building b2) {
                if (b1.time != b2.time) {
                    return b1.time < b2.time ? -1 : 0;
                }
                return b2.status - b1.status;
            }
        });

        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        ArrayList<Building> tmp = new ArrayList<Building>();
        for (Building b :buildingPoints) {
            if (b.status == 0) {
                if (pq.isEmpty() || b.height > pq.peek()) {
                    tmp.add(b);
                }
                pq.add(b.height);
            } else {
                pq.remove(b.height);
                if (pq.isEmpty() || b.height > pq.peek()) {
                    if (pq.isEmpty()) {
                        tmp.add(new Building(b.time,0,1));
                    } else {
                        tmp.add(new Building(b.time,pq.peek(),1));
                    }
                }
            }
        }
        for (int i = 0; i < tmp.size() - 1; i++) {
            if (tmp.get(i).height == 0) {
                continue;
            }
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(tmp.get(i).time);
            list.add(tmp.get(i+1).time);
            list.add(tmp.get(i).height);
            result.add(list);
        }

        return result;
    }

    public static void main(String [] args) {
        BuildingOutline b = new BuildingOutline();
        int [][] data = new int [][]{{1,3,3},{2,4,4},{5,6,1}};
        b.buildingOutline(data);
    }
}
