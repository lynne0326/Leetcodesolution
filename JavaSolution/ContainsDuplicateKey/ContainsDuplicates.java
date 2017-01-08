import java.util.HashSet;

/**
 * Created by lingyanjiang on 16/6/11.
 */
public class ContainsDuplicates {

    //Use hashset
    public boolean containsDuplicate(int[] nums) {
        if( nums == null || nums.length == 0)
            return false;
        HashSet set = new HashSet();
        for(int num:nums) {
            if(set.contains(num))
                return true;
            else
                set.add(num);
        }
        return false;
    }
}
