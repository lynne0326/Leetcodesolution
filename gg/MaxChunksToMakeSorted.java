import java.util.Arrays;

/**
 * Created by lingyanjiang on 18/8/20.
 */
public class MaxChunksToMakeSorted {

    //I 的解法
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if(max == i) res++;
        }
        return res;
    }

    //II, 有duplicate, 会多于n
    //o(n), o(n)
    //partition 再当 左边最大<=右边最小 的时候就cnt++
    public int maxChunksToSortedii(int[] arr) {
        int n = arr.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];
        maxLeft[0] = arr[0];
        for(int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], arr[i]);
        }
        minRight[n-1] = arr[n-1];
        for(int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i+1], arr[i]);
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(i == n - 1 || maxLeft[i] <= minRight[i+1]) {
                res++;
            }
        }
        return res;
    }

    //o(nlogn), o(n)
    //另一个sorted(expected)的array, 如果sum sorted[i]==sum[i],则说明这个地方可以切割
    //比如第一个块儿是数字2和1，和为3，而排序后的前两个数字为1和2，和也是3，那么我们就知道原数组的前两个数字可以拆成一个块儿。
    public int maxChunksToSortediio(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int res = 0;
        int sortSum = 0;
        int arrSum = 0;
        for(int i = 0; i < arr.length; i++) {
            sortSum += sorted[i];
            arrSum += arr[i];
            if(sortSum == arrSum) res++;
        }
        return res;
    }

}
