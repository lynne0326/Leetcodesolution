/**
 * Created by lingyanjiang on 16/12/29.
 */
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            sb.append(s.charAt(j));
            while (true) {
                int nextCol = j + (numRows - 1)*2;
                int middle = nextCol - i - j%(numRows-1);
                System.out.println(nextCol);
                if (nextCol > s.length()) {
                    if (middle < s.length()) {
                        sb.append(s.charAt(middle));
                    }
                    break;
                } else {
                    sb.append(s.charAt(middle));
                    if (middle != nextCol) {
                        sb.append(s.charAt(nextCol));
                    }
                }
                j = nextCol;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        convert("PAYPALISHIRING",3);
    }
}
