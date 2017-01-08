import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lingyanjiang on 16/9/12.
 */
public class SubarraySumClosest {
    class Pair {
        int sum;
        int index;

        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return null;
        }
        //Get prefix sum array
        Pair [] sumSet = new Pair [nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumSet[i] = new Pair(sum, i);
        }
        for (Pair p:sumSet) {
            System.out.print(p.sum);
        }
        System.out.println();
        //Sort array find minDiff
        int minDiff = Integer.MAX_VALUE;
        Pair [] minPair = new Pair [2];
        Arrays.sort(sumSet, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        for (Pair p:sumSet) {
            System.out.print(p.sum + ":" + p.index + " ");
        }
        for (int i = 0; i < sumSet.length - 1; i++) {
            int diff = sumSet[i+1].sum - sumSet[i].sum;
            if (diff < minDiff) {
                minDiff = diff;
                minPair[0] = sumSet[i];
                minPair[1] = sumSet[i + 1];
            }
        }
        int [] result = new int [] {minPair[0].index, minPair[1].index};
        Arrays.sort(result);
        return result;
    }
    public static void main (String [] args) {
        SubarraySumClosest sub = new SubarraySumClosest();
        int [] array = new int []{6,-4,-8,3,1,7};
        sub.subarraySumClosest(array);
    }
}