package PoketGem;

/**
 * Created by lingyanjiang on 17/3/3.
 */
public class BigInt {
    char sign = '+';
    String val;

    //Initiate
    public BigInt(String s) {
        if (s.charAt(0) == '-') {
            this.sign = '-';
            this.val = s.substring(1);
        } else {
            this.val = s;
        }
    }

    public BigInt add(BigInt num) {
        BigInt res = null;
        if (num.sign == '+' && this.sign == '+') {
            res = addHelper(this.val, num.val);
        } else if (num.sign == '-' && this.sign == '-') {
            res = addHelper(this.val, num.val);
            res.sign = '-';
        } else if (this.sign == '+' && num.sign == '-') {
            //If this > num
            if (compareVal(this.val, num.val) == 1) {
                res = subtractHelper(this.val, num.val);
            } else {
                res = subtractHelper(num.val, this.val);
                res.sign = '-';
            }
        } else if (this.sign == '-' && num.sign == '+'){
            //If this > num
            if (compareVal(this.val, num.val) == 1) {
                res = subtractHelper(num.val, this.val);
            } else {
                res = subtractHelper(this.val, num.val);
                res.sign = '-';
            }
        }
        return res;
    }

    public int compareVal(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return 1;
        } else if (s1.length() < s2.length()) {
            return -1;
        } else {
            return s1.compareTo(s2);
        }
    }

    private BigInt addHelper(String n1, String n2) {
        StringBuilder sb = new StringBuilder();
        int i = n1.length() - 1, j = n2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int num1 = i >= 0 ? n1.charAt(i--) - '0' : 0;
            int num2 = j >= 0 ? n2.charAt(j--) - '0' : 0;
            int sum = num1 + num2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return new BigInt(sb.reverse().toString());
    }

    private BigInt subtractHelper(String n1, String n2) {
        if (n1.equals(n2)) {
            return new BigInt("0");
        }
        StringBuilder sb = new StringBuilder();
        int i = n1.length() - 1, j = n2.length() - 1;
        int carry = 0;
        while (i >= 0) {
            int num1 = n1.charAt(i--) - '0';
            int num2 = j >= 0 ? n2.charAt(j--) - '0' : 0;
            int diff = num1 - num2 + carry;
            sb.append((diff + 10) % 10);
            carry = diff < 0 ? -1 : 0;
        }
        sb = sb.reverse();
        int k = 0;
        while (sb.charAt(k) == '0') {
            k++;
        }
        return new BigInt(sb.substring(k));
    }

    @Override
    public String toString() {
        return this.sign + this.val;
    }

    public static void main(String[] args) {
        BigInt n1 = new BigInt("12245");
        BigInt n2 = new BigInt("-300");
        System.out.println(n1.add(n2));
    }
}
