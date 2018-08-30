package util;

/**
 * Created by lingyanjiang on 17/1/9.
 */
public class Test {
    public Test(int s, int a) {

    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            if(sum != 0) {
                ans |= sum << i;
//                System.out.println(sum + " " + i + " " +" " + ans+" "+ (sum << i)+" " + ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        List<Double> list = new ArrayList<>();
//        list.add(new Double(42));
//        list.add(42.0);
//        int ans = 0;
//        ans |= 1 << 4;
//        System.out.println(ans);
//        System.out.println(singleNumber(new int []{1,1,1,2,2,2,3}));
//        int ans = 1;
//        ans |= 2;
//        System.out.println(ans);
//        Deque<Integer> dq = new ArrayDeque<>();
//        dq.add(1);
//        dq.offer(2);
//        System.out.println(dq.toString());
        String s = "abcabcabc";
        System.out.println(s.indexOf("abc"));
    }
}
