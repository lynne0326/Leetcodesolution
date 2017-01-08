/**
 * Created by lingyanjiang on 16/6/9.
 */
public class TitleToNumber {
    //excel column number
    //solution pattern:   AB: 1* 26^1 + 2*26^0
    //(A 26字母排位顺序) * 26 ^ (位数-1) 循环
    public int titleToNumber(String s) {
        if(s == null)
            return 0;
        int sum = 0;
        for(int i=0;i<s.length();i++) {
            sum += (s.charAt(i) - 'A'+1 ) * Math.pow(26,s.length()-i-1);
        }
        return sum;
    }
}
