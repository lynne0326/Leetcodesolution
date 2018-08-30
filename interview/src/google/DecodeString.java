package google;

import java.util.Stack;

/**
 * Created by lingyanjiang on 17/2/18.
 */
public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Integer> counts = new Stack<>();
        Stack<String> tmpString = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                counts.push(num);
                tmpString.push(sb.toString());
                sb = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int count = counts.pop();
                StringBuilder tmp = new StringBuilder(tmpString.pop());
                for (int j = 0; j < count; j++) {
                    tmp.append(sb);
                }
                sb = tmp;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
