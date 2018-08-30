package quantcast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 17/3/31.
 */
public class Zipcode {

    public List<String> findRangesWithEnding(String start, String end) {
        List<String> res = new ArrayList<>();
        res.add(start);
        if (start.equals(end)) return res;
        int left = stringToInt(start.substring(0, 2));
        int right = stringToInt(end.substring(0, 2));
        int startNum = Integer.parseInt(start.substring(2, 5));
        int endNum = Integer.parseInt(end.substring(2, 5));
        char startChar = start.charAt(start.length() - 1);
        char endChar = end.charAt(end.length() - 1);
        for (int i = left; i <= right; i++) {
            String cur = intToString(i);
            for (char c = 'A' ; c <= 'Z'; c++) {
                int l = 0, r = 999;
                if (i == left && c < startChar) continue;
                if (i == right && c > endChar) break;
                if (i == left && c == startChar) l = startNum;
                if (i == right && c == endChar) r = endNum;
                for (int j = l; j <= r; j++) {
                    res.add(cur + String.format("%03d", j) + c);
                }
            }
        }
        return res;
    }

    public List<String> findRanges(String start, String end) {
        List<String> res = new ArrayList<>();
        res.add(start);
        if (start.equals(end)) return res;
        int left = stringToInt(start.substring(0, 2));
        int right = stringToInt(end.substring(0, 2));
        int startNum = Integer.parseInt(start.substring(2, 5));
        int endNum = Integer.parseInt(end.substring(2, 5));
        char startChar = start.charAt(start.length() - 1);

        for (int i = left; i <= right; i++) {
            String cur = intToString(i);
            if (i == left && left != right) {
                for (int j = startNum; j <= 999; j++) {
                    res.add(cur + String.format("%03d", j) + startChar);
                }
            } else if (i == right) {
                for (int j = 0; j <= endNum; j++) {
                    res.add(cur + String.format("%03d", j));
                }
            } else {
                for (int j = 0; j <= 999; j++) {
                    for (char c = 'A'; c <= 'Z'; c++) {
                        res.add(cur + String.format("%03d", j) + c);
                    }
                }
            }
        }
        return res;
    }

    public int stringToInt(String s) {
        return (s.charAt(0) - 'A') * 26 + (s.charAt(1) - 'A');
    }

    public String intToString(int n) {
        char first = (char) ('A' + n / 26);
        char second = (char) ('A' + n % 26);
        return "" + first + second;
    }

    public static void main(String[] args) {
        new Zipcode().findRangesWithEnding("AA111A", "AA111B");
//        AB111A, BZ121B
    }
}
