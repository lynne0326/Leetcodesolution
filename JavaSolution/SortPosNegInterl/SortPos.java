class SolrtPos {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public static void swap(int [] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static void rerange(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        boolean iFlag = false;
        boolean jFlag = false;
        int i = 0, j = i + 1, cur = 0;
        while (cur < A.length && jFlag && iFlag) {
            if (A[cur] >= 0) {
                swap(A, cur, j);
                cur ++;
                j += 2;
                if (i > A.length -3) {
                    jFlag = true;
                }
            } else if (A[cur] < 0) {
                swap(A, cur, i);
                i += 2;
                if (i > A.length -3) {
                    iFlag = true;
                }
            } else {
                cur ++;
            }
        }
    }
    public static void main (String [] args) {
        int [] a = new int []{-33,-19,30,26,21,-9};
        rerange(a);
        System.out.println(a);
    }
}