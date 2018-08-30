import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lingyanjiang on 18/8/4.
 */
public class NumOfRescueBoat {

    //https://leetcode.com/contest/weekly-contest-96/problems/boats-to-save-people/

    public int numRescueBoats(int[] people, int limit) {
        if (people.length == 0) return 0;
        Arrays.sort(people);
        Map<Integer, Integer> map = new HashMap<>();
        for (int p: people) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        int cnt = 0;

        for (int i = people.length - 1; i >= 0; i--) {
            if (map.get(people[i]) <= 0) continue;
            map.put(people[i], map.get(people[i]) - 1);
            int comp = limit - people[i];
            while (comp > 0) {
                if (map.containsKey(comp) && map.get(comp) > 0) {
                    map.put(comp, map.get(comp) - 1);
                    break;
                }
                comp--;
            }
            cnt++;
        }
        return cnt;
    }

//    //brute force tle 2^n ?  int res = Integer.MAX_VALUE;
//    public int numRescueBoats(int[] people, int limit) {
//        if (people.length == 0) return 0;
//        helper(people, limit, new boolean[people.length], 0, 1, 0, 0);
//        return res;
//    }
//
//    private void helper(int[] people, int limit, boolean[] visited, int curWht, int cnt, int saved, int peopleOnBoat) {
//        // System.out.println(curWht + " " + cnt);
//        if (saved == people.length) {
//            // System.out.println("----" + curWht + " " + cnt);
//            res = Math.min(cnt, res);
//            return;
//        }
//        for (int i = 0; i < people.length; i++) {
//            if (visited[i]) continue;
//            visited[i] = true;
//            if (curWht + people[i] > limit || peopleOnBoat > 1) {
//                helper(people, limit, visited, people[i], cnt + 1, saved + 1, 1);
//            } else {
//                helper(people, limit, visited, curWht + people[i], cnt, saved + 1, peopleOnBoat + 1);
//            }
//            visited[i] = false;
//        }
//    }
}
