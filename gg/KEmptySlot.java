import java.util.TreeSet;

/**
 * Created by lingyanjiang on 18/8/25.
 */
public class KEmptySlot {
    // sliding window
//    只return第一个符合的，所以要走完全部去比min.
//            如果符合任意一个，那第一个就可以return了
//
//    1. TreeSet. nlogn
//    2. Sliding window, reverse create一个array第i朵花bloom的idx天数，
//    符合答案的区间有个特征，就是在days[i], days[j]中间的days都必须在他们俩之后，即都在他们之后开, o(n)
//    3. bucket, 有点麻烦，但是非常省空间，尤其k大的时候
    public int kEmptySlots(int[] flowers, int k) {
        int[] days = new int[flowers.length];
        for(int i = 0; i < flowers.length; i++) {
            days[flowers[i]-1] = i + 1;
        }
        int left = 0, right = k + 1;
        int min = Integer.MAX_VALUE;
        for(int i = 1; right < days.length; i++) {
            if(days[i] < days[left] || days[i] <= days[right]) {
                //to the end
                if(i == right) {
                    min = Math.min(min, Math.max(days[left], days[right]));
                }
                left = i;
                right = left + k + 1;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // tree set
    public int kEmptySlots2(int[] flowers, int k) {
         if(flowers.length == 0) return -1;
         TreeSet<Integer> bloomed = new TreeSet<>();
         for(int i = 0; i < flowers.length; i++) {
             bloomed.add(flowers[i]);
             Integer lower = bloomed.lower(flowers[i]);
             Integer higher = bloomed.higher(flowers[i]);
             if((lower != null && flowers[i] - lower == k + 1 )||
               (higher != null && higher - flowers[i] == k + 1)) {
                 return i + 1;
             }
         }
         return -1;
     }


}
