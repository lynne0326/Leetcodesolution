/**
 * Created by lingyanjiang on 16/5/29.
 */
public class NimeGame {
    //Any chance to leave 4 or times 4 will win the game
    public boolean canWinNim(int n) {
        if(n%4 == 0) return false;
        else return true;
    }
}
