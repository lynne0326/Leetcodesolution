/**
 * Created by lingyanjiang on 16/9/16.
 */
public class CountAndSay {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        int k = 0;
        String currentNum = "1";
        String result = "";
        char c = currentNum.charAt(0);
        while (k < n) {
            int count = 0;
            c = currentNum.charAt(0);
            for (int i = 0; i < currentNum.length(); i++) {
                if (currentNum.charAt(i) == c) {
                    count++;
                } else {
                    result = "" + count + c + result;
                    c = currentNum.charAt(i);
                    count = 1;
                }
            }
            if (count != 0) {
                result = "" + count + c + result;
                count = 0;
            }
            currentNum = result;
            result = "";
            k++;
        }
        return currentNum;
    }
    public static void main(String [] args) {
        System.out.println(countAndSay(3));
    }
}