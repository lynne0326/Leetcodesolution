package Lyft;

import java.util.HashMap;

/**
 * Created by lingyanjiang on 16/12/8.
 */
public class ReplaceAll {
    public static void main(String[] args) {
        String test = "  8832";
        System.out.println(test.replaceAll("\\s+",""));
        test = test.replaceAll("\\s+", "");
        System.out.println(test.matches("[0-9]{0,}"));
        HashMap map = new HashMap();
    }
}
