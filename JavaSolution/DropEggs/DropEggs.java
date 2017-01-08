/**
 * Created by lingyanjiang on 16/11/16.
 */
public class DropEggs {
    public static int dropEggs(int n) {
        // Write your code here
        int s = 0;
        n = n - 1;
        int count = 0;
        while (s < n) {
            s = s + (n-s)/2;
            count++;
            System.out.println(s);
        }
        return count;
    }
    public static void main(String [] args) {
        DropEggs.dropEggs(100);
    }
}
