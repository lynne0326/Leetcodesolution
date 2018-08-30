package google;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lingyanjiang on 18/4/4.
 */
public class MaxMeeting {


//    public static int maxMeetings(int [][] meetings) {
//        if (meetings == null || meetings.length == 0) return 0;
//        int [][] f = new int [meetings.length + 1][3];
//        // 0 when adding
//        // 1 when not adding
//        // 2 timestamp
//        f[1][0] = 1;
//        f[1][1] = 0;
//        f[1][2] = meetings[0][1];
//        for (int i = 2; i < f.length ; i++) {
//            //if cannot add
//            if (meetings[i - 1][0] < f[i - 1][0])
//
//        }
//        return Math.max(f[f.length - 1][0], f[f.length - 1][1]);
//    }

// dfs暴力破解法 2^n
    public static int maxMeetings(int [][] meetings) {
        if (meetings == null || meetings.length == 0) return 0;
        Arrays.sort(meetings, new Comparator<int []>(){
            @Override
            public int compare(int [] o1, int [] o2) {
                return o1[0] == o1[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        return helper(meetings, 0, 0);
    }

    public static int helper(int [][] meetings, int curIdx, int maxTmstp) {
        if (curIdx >= meetings.length || maxTmstp > 24 ) return 0;

        if (meetings[curIdx][0] < maxTmstp) {
            return helper(meetings, curIdx + 1, maxTmstp);
        }
        return Math.max(helper(meetings, curIdx + 1, meetings[curIdx][1]) + 1, helper(meetings, curIdx + 1, maxTmstp));
    }

//    public static int maxMeetingCount(int [][] meetings) {
//        if (meetings == null || meetings.length == 0) return 0;
//        int maxCnt = 0;
//        int [][] points = new int [meetings.length * 2][2];
//        int idx = 0;
//        for (int [] meeting: meetings) {
//            points[idx][0] = meeting[0];
//            points[idx++][1] = 0;
//            points[idx][0] = meeting[1];
//            points[idx++][1] = 1;
//        }
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] == o1[0] ? o1[1] - o2[1] : o1[0] - o2[0];
//            }
//        });
//        int cur = 0;
//        for (int [] point: points) {
//            if (point[1] == 0) {
//                cur++;
//            } else {
//                cur--;
//            }
//            maxCnt = Math.max(cur, maxCnt);
//        }
//        return maxCnt;
//    }

    public static void main(String[] args) {
        int [][] meetings = new int[][] {
                {0, 2},
                {3, 5}
        };
        int res = maxMeetings(meetings);
        System.out.println(res);
        meetings = new int[][] {
                {0, 5},
                {2, 3},
                {2, 2},
                {3,5},
                {3,8}
        };
        res = maxMeetings(meetings);
        System.out.println(res);
    }
}
