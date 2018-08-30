package PoketGem;

import java.util.*;

/**
 * Created by lingyanjiang on 17/3/5.
 */
public class Pizza {

    public static int getPizza(int [] slice) {
        if (slice == null || slice.length == 0) return 0;
        int max = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int sum = 0;
        for (int num: slice) {
            q.add(num);
            sum += num;
        }
        for (int i = 0; i < slice.length; i++) {
            int tmp = q.poll();
            int sub = dfs(q, sum - tmp);
            max = Math.max(max, tmp + sub);
            q.offer(tmp);
        }
        return sum - max;
    }

    private static int dfs(ArrayDeque<Integer> q, int sum) {
        if (q.size() == 0) return 0;
        if (q.size() == 1) return q.peek();
        int first = q.pollFirst();
        int pickFirst = dfs(q, sum - first);
        q.addFirst(first);
        int last  = q.pollLast();
        int pickLast = dfs(q, sum - last);
        q.addLast(last);
        return Math.max(pickFirst, pickLast);
    }

    public static int getPizza3(int[] slice) {
        if (slice == null || slice.length == 0) {
            return 0;
        }
        int n = slice.length;
        int[][] sum = new int[n][n];
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            sum[j][j] = slice[j];
            dp[j][j] = slice[j];
            for (int i = j - 1; i >= 0; i--) {
                sum[i][j] = sum[i + 1][j] + slice[i];
                dp[i][j] = sum[i][j] - Math.min(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
//
//    public static int[] toArray(Queue<Integer> q) {
//        List<Integer> list = new ArrayList<>(q);
//        int[] arr = new int[list.size()];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = list.get(i);
//        }
////		System.out.println(Arrays.toString(arr));
//        return arr;
//    }
////
//    public static int getPizza2(int[] slice) {
//        Queue<Integer> q = new LinkedList<>();
//        int sum = 0, result = 0;
//        for (int piece : slice) {
//            q.offer(piece);
//            sum += piece;
//        }
//        for (int i = 0; i < slice.length; i++) {
//            int first = q.poll();
////			System.out.println(first);
//            result = Math.max(result, sum - getPizza2(toArray(q)));
////            System.out.println(result);
//            q.offer(first);
//        }
//        return result;
//    }

    public static void main(String[] args) {
//        int res = getPizza2(new int[]{1,5,1});
        int res = getPizza3(new int[]{1,5,7,6});
//        int res = getPizza(new int[]{1,5,7,6});
        System.out.println(res);
    }
}
