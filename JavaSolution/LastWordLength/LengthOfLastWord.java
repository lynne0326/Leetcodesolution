/**
 * Created by lingyanjiang on 16/6/14.
 */
public class LengthOfLastWord {
    public int lengthOfLast(String words) {
        if(words.length() == 0 || words == null) {
            return 0;
        }
        String [] splited = words.split("\\s+");
        if(splited.length == 0)
            return words.length();
        else
            return splited[splited.length-1].length();

    }
}
