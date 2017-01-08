package Lyft;

/**
 * Created by lingyanjiang on 16/12/9.
 */
class Intvl {
    int start;
    int end;
    public Intvl(){}
    public Intvl(int start, int end) {
        this.end = end;
        this.start = start;
    }
}
public class DriverMode {
    public boolean canDrive(Intvl [] intervals) {
        int totalDrivenHour = 0;
        int breakTime = 0;
        int lastStart = intervals[intervals.length - 1].start;
        for (int i = intervals.length - 1; i >= 0; i--) {
            totalDrivenHour += intervals[i].end - intervals[i].start;
            if (totalDrivenHour >= 12) {
                return false;
            }
            breakTime += intervals[i].end - lastStart;
            lastStart = intervals[i].start;
        }
        if (breakTime < 8) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        DriverMode dm = new DriverMode();
        boolean res = dm.canDrive(new Intvl[]{
                new Intvl(9,10),
                new Intvl(12,22)
        });
        System.out.println(res);
    }
}
