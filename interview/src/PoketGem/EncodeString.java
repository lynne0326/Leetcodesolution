package PoketGem;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by lingyanjiang on 17/2/22.
 */
public class EncodeString {
    public static String encode2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char curr = s.charAt(0);
        int num = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) != curr) {
                sb.append(num).append(curr);
                curr = i == s.length() ? ' ' : s.charAt(i);
                num = 1;
            } else {
                num++;
            }
        }
        return sb.toString();
    }

    public static String encode(String s) {
        if (s == null || s.length() == 0) return s;
        int count = 1;
        char cur = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == cur) {
                count++;
            } else {
                sb.append(count);
                sb.append(cur);
                cur = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(cur);
        return sb.toString();
    }

    public static void encode3 (char[] arr) {
        char curr = arr[0];
        int num = 1, j = 0;
        for (int i = 1; i <= arr.length; i++) {

            if (i == arr.length || arr[i] != curr) {
                if (num > 1) {
                    arr[j++] = (char)(num + '0');
                }
                arr[j++] = curr;
                curr = i == arr.length ? ' ' : arr[i];
                num = 1;
            } else {
                num++;
            }
        }
        while (j < arr.length) {
            arr[j++] = '\0';
        }
        for (char c: arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void encode4(char [] s) {
        if (s == null || s.length == 0) return;
        int j = 0;
        char cur = s[0];
        int count = 0;
        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] != cur) {
                //if not equals
                if (count > 1) {
                    s[j++] = (char) ('0' + count);
                }
                s[j++] = cur;
                cur = i == s.length ? ' ' : s[i];
                count = 1;
            } else if (s[i] == cur) {
                //if equals to current char
                count++;
            }
        }
        while (j < s.length) {
            s[j++] = ' ';
        }
        System.out.println(new String(s));
        PriorityQueue<Map.Entry> pq = new PriorityQueue<>(10, new Comparator<Map.Entry>(){
            public int compare(Map.Entry e1, Map.Entry e2) {
                return (int)e1.getKey() - (int) e2.getKey();
            }
        });
    }

    public static void main(String[] args) {
//        encode3("aaacbbc".toCharArray());
//        String res = encode2("1b");
//        String res = encode("aaacbbcc");
//        String res = encode2("aaacbbcc");
        encode4("aaacbbcc".toCharArray());
//        System.out.println(res);
    }
}
