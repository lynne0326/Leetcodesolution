import java.util.HashSet;

public class HappyNumber {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public static boolean isHappy(int n) {

        String num = String.valueOf(n);
        HashSet<String> set = new HashSet<String>();
        int sum = 0;
        while(sum != 1) {

            for (int i = 0; i < num.length();i++) {
                String k = "" + num.charAt(i);
                int kn = Integer.parseInt(k);
                sum += kn*kn;
            }
            System.out.println(sum);
            if(set.contains(String.valueOf(sum))) {
                return false;
            } else {
                if (sum == 1) {
                    return true;
                }
                set.add(String.valueOf(sum));
                num = String.valueOf(sum);
                sum = 0;
            }
        }
        return false;
    }

    public static void main(String [] args) {
        System.out.println(isHappy(19));
    }
}