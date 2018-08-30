package quantcast;

import java.util.Random;

/**
 * Created by lingyanjiang on 17/3/30.
 */
public class Generate7Using5 {
    public int foo() {
        return new Random().nextInt(5);
    }

    public int generate() {
        int [][] vals = new int[][]{
                {1,2,3,4,5},
                {6,7,1,2,3},
                {4,5,6,7,1},
                {2,3,4,5,6},
                {7,0,0,0,0}
        };

        int x = foo();
        int y = foo();
        return vals[x][y];
    }

    public int generate2() {
        return (7 * foo() - 7) % 7;
    }



}
