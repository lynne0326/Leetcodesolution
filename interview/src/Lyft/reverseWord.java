package Lyft;

/**
 * Created by lingyanjiang on 16/12/5.
 */
public class reverseWord {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String [] splited = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = splited.length - 1; i >= 0; i--) {
            if (splited[i].matches("\\s+")) {
                continue;
            }
            sb.append(splited[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static String reverseInplace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char [] chars = s.toCharArray();
        reverse(chars, 0, s.length() - 1);
        int mark = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, mark, i - 1);
                mark = i + 1;
            }
        }
        return new String(chars);
    }

    private static void reverse(char [] tmpArray, int start, int end) {
        while (start <= end) {
            char tmp = tmpArray[start];
            tmpArray[start] = tmpArray[end];
            tmpArray[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseInplace("1  "));
        System.out.println(reverseInplace("I am"));
        System.out.println(reverseInplace(" do it just now"));
        System.out.println(reverseInplace("  this    is  "));
    }
}
