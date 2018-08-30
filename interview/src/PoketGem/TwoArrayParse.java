package PoketGem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lingyanjiang on 17/2/22.
 */
public class TwoArrayParse {
    public int[] parseArray2(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: A) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            counts.put(entry.getValue(), entry.getKey());
        }
        int [] res = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            res[i] = counts.containsKey(B[i]) ? counts.get(B[i]) : -1;
        }

        for(int n: res) {
            System.out.print(n +",");
        }
        System.out.println();
        return res;

    }

    public int[] parseArray(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num: A) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
            max = Math.max(max, map.get(num) + 1);
        }

        List[] counts = new List[max+1];
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int value = entry.getValue();
            int key = entry.getKey();
            if (counts[value] == null) {
                counts[value] = new ArrayList<Integer>();
            }
            counts[value].add(key);
        }

        int [] res = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            if (B[i] >= counts.length || counts[B[i]] == null) {
                res[i] = -1;
            } else {
                res[i] = (int)((List)counts[B[i]]).get(0);
            }
        }
        for(int n: res) {
            System.out.print(n +",");
        }
        System.out.println();
        return res;
    }

    public static void main(String[] args) {
        TwoArrayParse twoArrayParse = new TwoArrayParse();
        twoArrayParse.parseArray2(new int[]{5,5,5,8,8,4,4,1,1,1,1,2,2,2,2,2}, new int[]{3,5,1,2,4});
//        twoArrayParse.parseArray(new int[]{}, new int[]{});
    }
}
