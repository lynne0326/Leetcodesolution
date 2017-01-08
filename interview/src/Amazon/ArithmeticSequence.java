package Amazon;

/**
 * Created by lingyanjiang on 16/12/18.
 */
public class ArithmeticSequence {
    public static int Solution(int [] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int res = 0;
        int start = 0;
        int curDiff = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i++) {
            int diff = A[i] - A[i-1];
            if (diff == curDiff) {
                //如果是递增数列,到这里为止就有i - start - 1个新增的数列
                res += (i - start - 1);
            } else {
                start = i - 1;
                curDiff = diff;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Solution(new int []{1,2,3,2,1}));
        System.out.println(Solution(new int []{0,1,2,3,2,1}));
    }
}
