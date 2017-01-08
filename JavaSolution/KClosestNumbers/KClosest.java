/**
 * Created by lingyanjiang on 16/6/25.
 */
public class KClosest {
    /**
     * @param A      an integer array
     * @param target an integer
     * @param k      a non-negative integer
     * @return an integer array
     */
    public static int[] kClosestNumbers(int[] A, int target, int k) {
        if (k > A.length) {
            return A;
        }
        // Write your code here
        int[] result = new int[k];
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
                break;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (Math.abs(A[start]-target) > Math.abs(A[end]-target)) {
            start = end;
        }
        int i = 0, j = 1;
        for (int l = 0; l < k; l++) {
            if (start + i > A.length - 1) {
                System.out.println("4");
                result[l] = A[start - j];
                j++;
            } else if (start - j < 0) {
                System.out.println("5");
                result[l] = A[start + i];
                i++;
            } else {
                if (Math.abs(A[start + i] - target) < Math.abs(A[start - j] - target)) {
                    System.out.println("1");
                    result[l] = A[start + i];
                    i++;
                } else if (A[start + i] == A[start - j]) {
                    System.out.println("2");
                    result[l] = A[start + i];
                    result[++l] = A[start - j];
                    i++;
                    j++;
                } else {
                    System.out.println("3");
                    result[l] = A[start - j];
                    j++;
                }
            }
        }
        return result;
    }

    public static void main ( String [] args) {
        System.out.println(kClosestNumbers(new int[]{1,2,3}, 2, 3));
    }
}

