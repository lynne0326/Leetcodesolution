package Amazon;

import java.util.Arrays;

/**
 * Created by lingyanjiang on 16/12/18.
 */
public class FourInteger {

    public int[] Solution(int A, int B, int C, int D) {
        //记住交换顺序01,23,03
        int[] rvalue = new int[4];
        rvalue[0] = A;
        rvalue[1] = B;
        rvalue[2] = C;
        rvalue[3] = D;
        Arrays.sort(rvalue);
        swap(rvalue, 0, 1);
        swap(rvalue, 2, 3);
        swap(rvalue, 0, 3);
        return rvalue;
    }

    private static void swap(int [] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int [] array = new int[]{10,2,4,5};
        swap(array, 0,1);
        System.out.println(array[0]);
    }

}
