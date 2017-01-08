import java.util.Arrays;

/**
 * Created by lingyanjiang on 16/6/4.
 */
public class ArrayIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            int [] temp = null;
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int [] result = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] == nums2[j]) {
                if ( k == 0 || result[k - 1] != nums1[i] ) {
                    result[k++] = nums1[i];
                }
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOf(result,k);
    }
}
