public class MaxVacationDays {
//    static int maxVacationDays = 0;

//    public static int maxVacationDays(int[][] flights, int[][] days) {
//        // Write your code here
//        if (flights.length == 0) return 0;
//        for (int i = 0; i < flights[0].length; i++) {
//            dfs(flights, days, i, 0, 0);
//        }
//        return maxVacationDays;
//    }
//
//    private static void dfs(int[][] flights, int[][] days, int curCity, int curWeek, int vacationDays) {
//        if (curWeek == days[0].length) {
//            maxVacationDays = Math.max(maxVacationDays, vacationDays);
//            return;
//        }
//        for (int i = 0; i < flights[curCity].length; i++) {
//            if (i == curCity) {
//                dfs(flights, days, i, curWeek + 1, vacationDays + days[curCity][curWeek]);
//            }
//            if (flights[curCity][i] == 1) {
//                dfs(flights, days, i, curWeek + 1, vacationDays + days[curCity][curWeek]);
//            }
//        }
//    }

    public static int maxVacationDays(int[][] flights, int[][] days) {
        int[][] f = new int[flights.length][days[0].length];
        for (int i = 0; i < f.length; i++) {
            if (flights[0][i] == 1 || i == 0) {
                f[i][0] = days[i][0];
            } else {
                f[i][0] = Integer.MIN_VALUE;
            }
        }
        int res = 0;
        for (int i = 0; i < f.length; i++) {
            for (int j = 1; j < f[i].length; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < f.length; k++) {
                    if (flights[i][k] == 1 || k == i) {
                        max = Math.max(f[k][j-1], max);
                    }
                }
                f[i][j] = max + days[i][j];
                res = Math.max(res, f[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxVacationDays(new int[][]{{0,1,0},{0,0,0},{0,0,0}}, new int[][]{{0,0,7},{2,0,0},{7,7,7}}));
    }
}
