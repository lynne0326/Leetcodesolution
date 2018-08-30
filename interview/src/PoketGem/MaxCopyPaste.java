package PoketGem;

/**
 * Created by lingyanjiang on 17/3/1.
 */
public class MaxCopyPaste {


    public static int maxAs(int n ) {
        return helper(0, n, 0);
    }

    //O(3^n) 对每一次操作,有3种情况
    private static int helper(int aCount, int nLeft, int clipCount) {
        //Three situation here
        //Either press A,
        //or press V, when there are A left in clip board
        //or Press ACV, new copy and paste
        if (nLeft == 0) return aCount;
        if (nLeft < 0) return -1;
        int pressA = helper(aCount + 1, nLeft - 1, clipCount);
        int pressV = helper(aCount + clipCount, nLeft - 1, clipCount);
        int pressACV = helper(aCount + aCount, nLeft - 3, clipCount + aCount);
        return Math.max(Math.max(pressA, pressV), pressACV);
    }

    public static int getOccurance(int n) {
        if (n <= 3) {
            return n;
        }
        int[] len = new int[3];
        len[1 % 3] = 1;
        len[2 % 3] = 2;
        len[3 % 3] = 3;
        int dpaste = 3, pl1 = 1;
        int cpaste = 0, pl2 = 0;
        for (int i = 4; i <= n; i++) {
            int tmp = Math.max(dpaste + pl1, cpaste + pl2);
            pl1 = (dpaste + pl1) == (cpaste + pl2) ? Math.max(pl1, pl2) : (dpaste + pl1) > (cpaste + pl2) ? pl1 : pl2;
            dpaste = tmp;
            cpaste = len[i % 3] * 2;
            pl2 = len[i % 3];
            len[i % 3] = Math.max(dpaste, cpaste);
        }
        return len[n % 3];
    }

    public static void main(String[] args) {
        System.out.println(maxAs(1));
        System.out.println(maxAs(2));
        System.out.println(maxAs(3));
        System.out.println(maxAs(4));
        System.out.println(maxAs(7));
        System.out.println(maxAs(9));
        System.out.println();
        System.out.println(getOccurance(1));
        System.out.println(getOccurance(2));
        System.out.println(getOccurance(3));
        System.out.println(getOccurance(4));
        System.out.println(getOccurance(7));
        System.out.println(getOccurance(9));
    }
}
