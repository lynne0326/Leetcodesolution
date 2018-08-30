package google;

import java.util.Stack;

/**
 * Created by lingyanjiang on 17/2/20.
 */
public class TernaryExpressionParser {
    //stack
    public String parseTernary2(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();
                char first = stack.pop();
                stack.pop();
                char second = stack.pop();
                if (c == 'T') stack.push(first);
                else stack.push(second);
            } else {
                stack.push(c);
            }
        }
        return "" + stack.peek();
    }

    //dfs
    public String parseTernary(String expression) {
        int i = 0;
        int count = 0;
        if (expression.indexOf(":") == -1) return expression;
        while (i < expression.length()) {
            if (expression.charAt(i) == '?') {
                count++;
            } else if (expression.charAt(i) == ':') {
                count--;
                if (count == 0) break;
            }
            i++;
        }
        String first = expression.substring(2, i);
        String second = expression.substring(i+1);
        return expression.charAt(0) == 'T' ? parseTernary(first):parseTernary(second);
    }
}
