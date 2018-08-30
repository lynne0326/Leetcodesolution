/**
 * Created by lingyanjiang on 18/6/10.
 */
public class AddTwoString {
    public static String addStrings(String num1, String num2) {
        // write your code here
        String res = "";
        int carry = 0;
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        while (m >=0 && n >= 0) {
            int c1 = num1.charAt(m) - '0';
            int c2 = num2.charAt(n) - '0';
            int tmp = c1 + c2 + carry;
            res = "" + tmp % 10 + res;
            carry = tmp / 10;
            m--;
            n--;
        }
        while (m >= 0) {
            int c = num1.charAt(m) - '0' + carry;
            res = "" + c % 10 + res;
            carry = c / 10;
            m--;
        }
        while (n >= 0) {
            int c = num2.charAt(n) - '0' + carry;
            res = "" + c % 10 + res;
            carry = c / 10;
            n--;
        }
        if (carry != 0) {
            res = "" + carry + res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(addStrings("187182781728", "1298912891289189189898198291"));
    }
}
