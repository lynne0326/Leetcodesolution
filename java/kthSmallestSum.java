import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

class Number {
    public int i;
    public int j;
    public int value;
    public Number(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Number)) {
            return false;
        }
        Number o = (Number) obj;
        return (this.i == o.i && this.j == o.j);
    }

    @Override
    public int hashCode() {
        return i * 101 + j;
    }
}

public class kthSmallestSum {

    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public static int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        if (A.length == 0 || B.length == 0 || A == null || B == null) {
            return -1;
        }
        Queue<Number> queue =  new PriorityQueue<Number>(k, new Comparator<Number>() {
            public int compare(Number o1, Number o2) {
                return o1.value - o2.value;
            }
        });
        HashSet<Number> set = new HashSet<Number>();

        int n1 = 0;
        int n2 = 0;
        Number result = null;
        queue.add(new Number(n1,n2,A[n1]+B[n1]));
        int count = 0;
        while (count < k) {
            if (!queue.isEmpty()) {
                Number tmp = queue.poll();
                result = tmp;
                if (set.contains(tmp)) {
                    continue;
                }
                set.add(tmp);
                n1 = tmp.i;
                n2 = tmp.j;
                if (n1+1 < A.length) {
                    queue.add(new Number(n1+1,n2,A[n1+1]+B[n2]));
                }
                if (n2+1 < B.length) {
                    queue.add(new Number(n1,n2+1,A[n1]+B[n2+1]));
                }
                count++;
            }
        }
        for(Number n:set ) {
            System.out.println(n.value+" "+n.i+" "+n.j);
        }
        return result.value;
    }
    public static void main(String [] args) {
        System.out.println(kthSmallestSum(new int[]{1,7,11}, new int[]{2,4,6}, 8));
    }
}
