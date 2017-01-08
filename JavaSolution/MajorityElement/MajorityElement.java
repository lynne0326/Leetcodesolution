import java.util.Arrays;

/**
 * Created by lingyanjiang on 16/6/9.
 */
public class MajorityElement {
    public class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            int currentMax = 0;
            int count = 0;
            Integer currentElement = null;
            int max = 0;
            for(int n:nums) {
                if(currentElement == null) {
                    currentElement = new Integer(n);
                    max = currentElement.intValue();
                    count++;
                } else if(currentElement.intValue() == n) {
                    count++;
                } else if(currentElement.intValue() != n) {
                    if(count >= currentMax) {
                        currentMax = count;
                        max = currentElement.intValue();
                        currentElement = new Integer(n);
                        count = 1;
                    } else {
                        count = 1;
                        currentElement = new Integer(n);
                    }
                }
            }
            if(count >= currentMax)
                return currentElement.intValue();
            else
                return max;
        }
    }
}
