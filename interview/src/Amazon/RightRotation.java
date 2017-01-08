package Amazon;

/**
 * Created by lingyanjiang on 16/12/15.
 */
public class RightRotation {
    /**
     * 一个Stirng是否是另一个的right rotation
     */
    public boolean isRightRotation(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0) {
            return false;
        }
        String tmp = word1 + word1;
        return tmp.indexOf(word2) != -1 ? true : false;
    }

    public static void main(String[] args) {
        RightRotation rightRotation = new RightRotation();
        System.out.println(rightRotation.isRightRotation("right", "ghtri"));
    }
}
