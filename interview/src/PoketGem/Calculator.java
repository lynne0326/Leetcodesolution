package PoketGem;

import java.util.Stack;

/**
 * Created by lingyanjiang on 17/2/22.
 */
public class Calculator {

    public static int calculator(String s) {
        if (s == null || s.length() == 0) return 0;
        int num = 0;
        int prev = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= s.length(); i++) {
            char c = i == s.length() ? ' ' : s.charAt(i);
            if (i == s.length() || "+-*/^".indexOf(c) != -1) {
                switch(sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '^':
                        //9 * 2 ^ 3
                        //现在stack里面是18,
                        //然后poll出来, 18/ prev, which is 2, then we get 9, the previous most number
                        //然后再implement 2 ^ 3,
                        int tmp = prev;
                        prev = (int)Math.pow((double)prev, num);
                        stack.push(stack.pop() / tmp * prev);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }
                prev = num;
                num = 0;
                sign = c;
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (s.charAt(i) == '(') {
                int j = i + 1, count = 1;
                while (j < s.length()) {
                    if (s.charAt(j) == '(') {
                        count++;
                    } else if(s.charAt(j) == ')') {
                        count--;
                    }
                    if (count == 0) {
                        break;
                    }
                    j++;
                }
                num = calculator(s.substring(i + 1, j));
                i = j;
            }
        }
        int res = 0;

        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public int calculateWithoutBracket(String s) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= s.length(); i++) {
            char c = i < s.length() ? s.charAt(i) : ' ';
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (i == s.length() || "+-/*".indexOf(c+"") != -1) {
                switch(sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        //坑:这里i要走到s.length()
        for (int i = 0; i <= s.length(); i++) {
            char c = i == s.length() ? ' ' : s.charAt(i);
            if (Character.isDigit(c)) {
                num  = num * 10 + (c - '0');
                //坑2:注意i在走到最后的时候也要考虑
            } else if (i == s.length() || c == '+' || c == '-') {
                if (sign == '+') stack.push(num);
                else if (sign == '-') stack.push(-num);
                sign = c;
                num = 0;
            } else if (c == '(') {
                int j = i + 1, count = 1;
                while (count > 0) {
                    if (s.charAt(j) == '(') {
                        count++;
                    } else if (s.charAt(j) == ')') {
                        count--;
                    }
                    j++;
                }
                num = calculate(s.substring(i + 1, j - 1));
                i = j - 1;
            }
        }
        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }


    public static int calculate2(String s) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= s.length(); i++) {
            char c = i < s.length() ? s.charAt(i) : ' ';
            if (i == s.length() || c == '+' || c == '-' || c == '*' || c == '/'){
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if(sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                int j = i + 1, count = 1;
                while (count > 0) {
                    if (s.charAt(j) == '(') {
                        count++;
                    } else if(s.charAt(j) == ')') {
                        count--;
                    }
                    j++;
                }
                num = calculate2(s.substring(i + 1, j - 1));
                i = j - 1;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }


    public static void main(String[] args) {
//        int res = calculator("3 * 5");
//        int res = calculator("9 + 2^3"); // see a caret ^
        int res = calculator("125 + 3^3");
//        int res = calculator("13-4*(5 + 3)^2");
        System.out.println(res);
    }
}
