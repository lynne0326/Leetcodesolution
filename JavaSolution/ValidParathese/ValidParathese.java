import java.util.Stack;

/**
 * Created by lingyanjiang on 16/6/6.
 */
public class ValidParathese {
    public boolean isValid(String str) {
        char [] characters = str.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char c:characters) {
            if("({[".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if(!stack.isEmpty() || isParathese(stack.peek(),c)) {
                    stack.pop();
                } else{
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isParathese(char c1,char c2) {
        return (c1 == '(' && c2 == ')') ||
                (c1 == '[' && c2 == ']') ||
                (c1 == '{' && c2 == '}');
    }
}
