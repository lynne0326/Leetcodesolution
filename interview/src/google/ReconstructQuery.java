package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lingyanjiang on 17/2/20.
 */
public class ReconstructQuery {
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0) return people;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
            }
        });
        List<int[]> result = new ArrayList();
        for(int[] person : people) {
            //add to list according to index
            result.add(person[1], person);
        }

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        new ReconstructQuery().reconstructQueue(new int[][]{
                {4, 4},
                {5, 2},
                {5, 0},
                {6, 1},
                {7, 1},
                {7, 0}
        });
    }
}
